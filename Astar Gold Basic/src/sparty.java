import java.util.*;
import java.io.*;

public class sparty {
	
	static final int INF = 99999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * Solution Idea:
		 * Run Dijkstra's twice:
		 * Once for the return trip, from party pasture to home pasture
		 * Once for the trip to the party with a reverse Dijkstra's (using adj[i][source] instead of adj[source][i])
		 */

		Scanner in = new Scanner(new File("sparty.in.txt"));
		PrintStream out = new PrintStream(new File("sparty.out.txt"));
		
		int pastures = in.nextInt();
		int paths = in.nextInt();
		int source = in.nextInt() - 1;
		
		// initialize adjacency matrix with INF
		int[][] adj = new int[pastures][pastures];
		for (int i = 0; i < pastures; i++) {
			for (int j = 0; j < pastures; j++) {
				adj[i][j] = INF;
			}
		}
		
		// populate adjacency matrix with initial distances
		for (int i = 0; i < paths; i++) {
			int vertex1 = in.nextInt() - 1;
			int vertex2 = in.nextInt() - 1;
			int dist = in.nextInt();
			adj[vertex1][vertex2] = Math.min(dist, adj[vertex1][vertex2]);
		}
		
		// distance to itself is 0
		for (int i = 0; i < pastures; i++) {
			adj[i][i] = 0;
		}
		
		boolean[] visitedFrom = new boolean[pastures];
		visitedFrom[source] = true;
		boolean[] visitedTo = new boolean[pastures];
		visitedTo[source] = true;
		
		// initialize distance matrix with values from adjacency matrix
		int[] distancesFrom = new int[pastures];
		for (int i = 0; i < pastures; i++) {
			distancesFrom[i] = adj[source][i];
		}
		int[] distancesTo = new int[pastures];
		for (int i = 0; i < pastures; i++) {
			distancesTo[i] = adj[i][source];
		}
		
		// loop V-1 times
		for (int i = 0; i < pastures - 1; i++) {
			// TO 
			// find the unvisited vertex with minimum distance to visited nodes
			int index = 0, distance = INF;
			for (int j = 0; j < pastures; j++) {
				if (distancesFrom[j] < distance && !visitedFrom[j]) {
					distance = distancesFrom[j];
					index = j;
				}
			}
			visitedFrom[index] = true;
			
			// update distance matrix with better distances
			for (int j = 0; j < pastures; j++) {
				distancesFrom[j] = Math.min(distancesFrom[j], distancesFrom[index] + adj[index][j]);
			}
			
			// FROM
			// find the unvisited vertex with minimum distance to visited nodes
			index = 0;
			distance = INF;
			for (int j = 0; j < pastures; j++) {
				if (distancesTo[j] < distance && !visitedTo[j]) {
					distance = distancesTo[j];
					index = j;
				}
			}
			visitedTo[index] = true;
			
			// update distance matrix with better distances
			for (int j = 0; j < pastures; j++) {
				distancesTo[j] = Math.min(distancesTo[j], distancesTo[index] + adj[j][index]);
			}
			
		}
		
		int maxTime = 0;
		for (int i = 0; i < pastures; i++) {
			maxTime = Math.max(maxTime, distancesTo[i] + distancesFrom[i]);
		}
		System.out.println(maxTime);
		
	}

}

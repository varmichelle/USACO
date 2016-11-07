import java.util.*;
import java.io.*;

public class cgiving2 {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("cgiving2.in.txt"));
		PrintStream out = new PrintStream(new File("cgiving2.out.txt"));
		
		int pastures = in.nextInt();
		int paths = in.nextInt();
		int bulls = in.nextInt();
		
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
			adj[vertex2][vertex1] = adj[vertex1][vertex2];
		}
		
		// distance to itself is 0
		for (int i = 0; i < pastures; i++) {
			adj[i][i] = 0;
		}
		
		boolean[] visited = new boolean[pastures];
		// barn = source
		visited[0] = true;
		
		// initialize distance matrix with values from adjacency matrix
		int[] distances = new int[pastures];
		for (int i = 0; i < pastures; i++) {
			distances[i] = adj[0][i];
		}
		
		// loop V-1 times
		for (int i = 0; i < pastures - 1; i++) {
			// find the unvisited vertex with minimum distance to visited nodes
			int index = 0, distance = INF;
			for (int j = 0; j < pastures; j++) {
				if (distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			
			// update distance matrix with better distances
			for (int j = 0; j < pastures; j++) {
				distances[j] = Math.min(distances[j], distances[index] + adj[index][j]);
			}
		}
		
		// go through each query
		for (int i = 0; i < bulls; i++) {
			int start = in.nextInt() - 1;
			int finish = in.nextInt() - 1;
			System.out.println(distances[start] + distances[finish]);
		}
		
	}

}

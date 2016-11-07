import java.util.*;
import java.io.*;

public class water {
	
	static final int INF = 999999999;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("water.in.txt"));
		PrintStream out = new PrintStream(new File("water.out.txt"));
		
		// read input
		int V = in.nextInt();
		int[] wells = new int[V];
		for (int i = 0; i < V; i++) {
			wells[i] = in.nextInt();
		}
		
		// initialize distances in matrix
		int[][] matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		// update distance to itself (wells)
		for (int i = 0; i < V; i++) {
			matrix[i][i] = wells[i];
		}
		
		int minCost = INF;
		for (int k = 0; k < V; k++) {
			boolean visited[] = new boolean[V];
			int start = k;
			int distances[] = new int[V];
			for (int i = 0; i < V; i++) {
				distances[i] = matrix[0][i];
			}
			visited[start] = true;
			distances[start] = wells[start];
			int cost = wells[start];
			// loop V-1 times
			for (int i = 1; i < V; i++) {
				// find the optimal vertex (minimum distance)
				int index = 0, distance = INF;
				for (int j = 0; j < V; j++) {
					if (distances[j] < distance && !visited[j]) {
						distance = distances[j];
						index = j;
					}
				}
				visited[index] = true;
				cost += distances[index];
				// update distances array
				for (int j = 0; j < V; j++) {
					distances[j] = Math.min(distances[j], matrix[index][j]);
				}
			}
			minCost = Math.min(minCost, cost);
		}
		
		System.out.println(minCost);

	}

}

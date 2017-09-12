import java.util.*;
import java.io.*;

public class water {
	
	static final int INF = 999999999;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * Main concept:
		 * Start Prim's at the least costly pasture to build a well
		 * Building a pasture in k is the same as building a pipe from n to k (just different cost)
		 */
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("water.in.txt"));
		PrintStream out = new PrintStream(new File("water.out.txt"));
		
		// read input
		int V = in.nextInt();
		int[] wells = new int[V];
		int min = INF, min_index = 0;
		for (int i = 0; i < V; i++) {
			wells[i] = in.nextInt();
			if (wells[i] < min) {
				min = wells[i];
				min_index = i;
			}
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
		
		boolean visited[] = new boolean[V];
		
		int start = min_index;
		
		int distances[] = new int[V];
		for (int i = 0; i < V; i++) {
			distances[i] = matrix[start][i];
		}
		
		visited[start] = true;
		distances[start] = wells[start];
		int cost = wells[start];
		
		// loop V-1 times
		for (int i = 1; i < V; i++) {
			// find the optimal vertex (minimum distance)
			int index_pipe = 0, distance_pipe = INF;
			int index_well = 0, distance_well = INF;
			for (int j = 0; j < V; j++) {
				if (distances[j] < distance_pipe && !visited[j]) {
					distance_pipe = distances[j];
					index_pipe = j;
				}
				if (wells[j] < distance_well && !visited[j]) {
					distance_well = wells[j];
					index_well = j;
				}
			}
			if (distance_pipe < distance_well) {
				visited[index_pipe] = true;
				cost += distances[index_pipe];
				// update distances array
				for (int j = 0; j < V; j++) {
					distances[j] = Math.min(distances[j], matrix[index_pipe][j]);
				}
			} else {
				visited[index_well] = true;
				cost += wells[index_well];
				distances[index_well] = wells[index_well];
				// update distances array
				for (int j = 0; j < V; j++) {
					distances[j] = Math.min(distances[j], matrix[index_well][j]);
				}				
			}
		}
		
		System.out.println(cost);

	}

}

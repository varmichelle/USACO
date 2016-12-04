import java.util.*;
import java.io.*;

public class mst2 {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("mst2.in.txt"));
		PrintStream out = new PrintStream(new File("mst2.out.txt"));
		
		// read input
		int V = in.nextInt();
		int E = in.nextInt();
		
		// initialize distances in matrix to INF
		int[][] matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = INF;
			}
		}
		
		// read input distances
		for (int i = 0; i < E; i++) {
			int node1 = in.nextInt() - 1;
			int node2 = in.nextInt() - 1;
			int distance = in.nextInt();
			matrix[node1][node2] = distance;
			matrix[node2][node1] = distance;
		}
		
		boolean visited[] = new boolean[V];
		
		int start = 0;
		
		int distances[] = new int[V];
		for (int i = 0; i < V; i++) {
			distances[i] = matrix[0][i];
		}
		visited[start] = true;
		distances[start] = 0;
		int cost = 0;
		
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
		System.out.println(cost);

	}

}

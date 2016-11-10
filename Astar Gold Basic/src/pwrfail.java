import java.util.*;
import java.io.*;

public class pwrfail {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("pwrfail.in.txt"));
		PrintStream out = new PrintStream(new File("pwrfail.out.txt"));
		
		// read input
		int V = in.nextInt();
		int E = in.nextInt();
		
		// initialize distances in matrix to INF
		double[][] matrix = new double[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = INF;
			}
		}
		
		int[][] coordinates = new int[V][2];
		
		// read in coordinates
		for (int i = 0; i < V; i++) {
			coordinates[i][0] = in.nextInt();
			coordinates[i][1] = in.nextInt();
		}
		
		// read input distances
		for (int i = 0; i < E; i++) {
			int node1 = in.nextInt() - 1;
			int node2 = in.nextInt() - 1;
			double distance = Math.sqrt(Math.pow(coordinates[node1][0] - coordinates[node2][0], 2) + Math.pow(coordinates[node1][1] - coordinates[node2][1], 2));
			matrix[node1][node2] = distance;
			matrix[node2][node1] = distance;
		}
		
		boolean visited[] = new boolean[V];
		
		int start = 0;
		
		double distances[] = new double[V];
		for (int i = 0; i < V; i++) {
			distances[i] = matrix[0][i];
		}
		visited[start] = true;
		distances[start] = 0;
		
		// loop V-1 times
		for (int i = 1; i < V; i++) {
			// find the optimal vertex (minimum distance)
			int index = 0;
			double distance = INF;
			for (int j = 0; j < V; j++) {
				if (distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			// update distances array
			for (int j = 0; j < V; j++) {
				distances[j] = Math.min(distances[j], matrix[index][j]);
			}
		}
		if (distances[V-1] == INF) System.out.println(-1);
		else System.out.println((int) 1000*distances[V-1]);

	}

}

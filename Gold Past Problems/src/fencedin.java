import java.io.*;
import java.util.*;

public class fencedin {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Code works but too slow / memory limit exceeded
		
		Scanner scan = new Scanner(new File("fencedin.in"));
		PrintStream out = new PrintStream(new File("fencedin.out"));
		
		int width = scan.nextInt();
		int length = scan.nextInt();
		int vertical = scan.nextInt();
		int horizontal = scan.nextInt();
		int[] x = new int[vertical + 2];
		int[] y = new int[horizontal + 2];
		x[0] = 0;
		y[0] = 0;
		x[vertical + 1] = width;
		y[horizontal + 1] = length;
		for (int i = 1; i <= vertical; i++) {
			x[i] = scan.nextInt();
		}
		for (int i = 1; i <= horizontal; i++) {
			y[i] = scan.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int vertices = (vertical + 1) * (horizontal + 1);
		int edges = (vertical + 1) * horizontal + (horizontal + 1) * vertical;
		
		// Prim's algorithm for Minimum Spanning Tree:
		long[][] adjacency_matrix = new long[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				adjacency_matrix[i][j] = -1;
			}
		}
		// Fill adjacency matrix with costs for vertical edges
		for (int i = 0; i < horizontal + 1; i++) {
			for (int j = 0; j < vertical; j++) {
				int vertex_1 = (vertical + 1) * i + j;
				int vertex_2 = vertex_1 + 1;
				int cost = y[i + 1] - y[i];
				adjacency_matrix[vertex_1][vertex_2] = cost;
				adjacency_matrix[vertex_2][vertex_1] = cost;
			}
		}
		// Fill adjacency matrix with costs for horizontal edges
		for (int i = 0; i < horizontal; i++) {
			for (int j = 0; j < vertical + 1; j++) {
				int vertex_1 = i * (vertical + 1) + j;
				int vertex_2 = vertex_1 + vertical + 1;
				int cost = x[j + 1] - x[j];
				adjacency_matrix[vertex_1][vertex_2] = cost;
				adjacency_matrix[vertex_2][vertex_1] = cost;
			}
		}
		// Generate MST
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		long total_cost = 0;
		long min;
		int u = 0, v = 0;
		visited[0] = true;
		for (int counter = 1; counter <= vertices - 1; counter++) {
			boolean found = false;
			min = 999999999;
			for (int j = 0; j < vertices; j++) {
				if (visited[j]) {
					for (int k = 0; k < vertices; k++) {
						if (!visited[k]) {
							if (adjacency_matrix[j][k] != -1 && adjacency_matrix[j][k] < min) {
								min = adjacency_matrix[j][k];
								u = j;
								v = k;
								found = true;
							}
						}
					}
				}
			}
			if (found) {
				visited[v] = true;
				total_cost += adjacency_matrix[u][v];
			}
		}
		out.println(total_cost);
	}
}

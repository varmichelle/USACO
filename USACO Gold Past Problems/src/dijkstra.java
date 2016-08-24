import java.io.*;
import java.util.Scanner;

public class dijkstra {

	static int[] distances;
	static boolean[] visited;
	static int vertices, source;
	static int[][] adjacency_matrix;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("dijkstra.in.txt"));
		PrintStream out = new PrintStream(new File("dijkstra.out.txt"));

		vertices = scan.nextInt();
		int edges = scan.nextInt();
		source = scan.nextInt() - 1;
		adjacency_matrix = new int[vertices][vertices];
		distances = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				adjacency_matrix[i][j] = 900000000;
			}
		}
		for (int i = 0; i < edges; i++) {
			int vertex_1 = scan.nextInt() - 1;
			int vertex_2 = scan.nextInt() - 1;
			int cost = scan.nextInt();
			adjacency_matrix[vertex_1][vertex_2] = cost;
			adjacency_matrix[vertex_2][vertex_1] = cost;
		}
		dijkstra();
		for (int i = 0; i < vertices; i++) {
			if (distances[i] == 900000000) System.out.println(-1);
			else System.out.println(distances[i]);
		}

	}

	public static void dijkstra() {
		// Find shortest path from source node to every other node
		visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) distances[i] = 900000000;
		distances[source] = 0;
		int nodesReached = 0, current = 0;
		while (nodesReached < vertices) {
			int curDist = 900000000;
			for (int i = 0; i < vertices; i++) {
				if (!visited[i] && distances[i] < curDist) {
					curDist = distances[i];
					current = i;
				}
			}
			visited[current] = true;
			nodesReached++;
			for (int i = 0; i < vertices; i++) {
				if (!visited[i]) distances[i] = Math.min(distances[i], distances[current] + adjacency_matrix[current][i]);
			}
		}
	}

}

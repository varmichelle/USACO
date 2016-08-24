import java.io.*;
import java.util.Scanner;

public class dijsktra {
	
	static int[] distances;
	static boolean[] visited;
	static int vertices, source;
	static int[][] adjacency_matrix;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("dijkstra.in.txt"));
		PrintStream out = new PrintStream(new File("dijkstra.out.txt"));
		
		vertices = scan.nextInt();
		int edges = scan.nextInt();
		source = scan.nextInt();
		adjacency_matrix = new int[vertices][vertices];
		distances = new int[vertices];
		for (int i = 0; i < edges; i++) {
			for (int j = 0; j < vertices; j++) {
				adjacency_matrix[i][j] = 999999999;
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
		
	}
	
	public static void dijkstra() {
		// Find shortest path from source node to every other node
		visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			distances[i] = 999999999;
		}
		distances[source] = 0;
		int nodesReached = 1;
		visited[source] = true;
		int current, curDist = 999999999;
		while (nodesReached < vertices) {
			current = findShortest(curDist);
			visited[current] = true;
			nodesReached++;
		}
	}
	
	public static int findShortest(int curDist) {
		int current = source;
		for (int i = 0; i < vertices; i++) {
			if (!visited[i] && adjacency_matrix[source][i] < curDist) {
				curDist = adjacency_matrix[source][i];
				current = i;
			}
		}
		distances[current] = curDist;
		return current;
	}

}

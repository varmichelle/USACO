/* import java.io.*;
import java.util.*;

public class pwrfail {

	static double[] distances;
	static boolean[] visited;
	static int num_poles, num_wires;
	static double[][] wires_connected;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("pwrfail.in.txt"));
		PrintStream out = new PrintStream(new File("pwrfail.out.txt"));
		
		num_poles = scan.nextInt();
		num_wires = scan.nextInt();
		double limit = scan.nextDouble();
		int[][] poles = new int[num_poles + 1][2];
		for (int i = 0; i < num_poles; i++) {
			poles[i][0] = scan.nextInt();
			poles[i][1] = scan.nextInt();
		}
		wires_connected = new double[num_poles + 1][num_poles + 1];
		for (int i = 0; i < num_wires; i++) {
			for (int j = 0; j < num_wires; j++) {
				wires_connected[i][j] = 900000000;
			}
		}
		for (int i = 0; i < num_wires; i++) {
			int pole_1 = scan.nextInt();
			int pole_2 = scan.nextInt();
			wires_connected[pole_1][pole_2] = 0;
			wires_connected[pole_2][pole_1] = 0;
		}
		for (int i = 0; i < num_poles; i++) {
			for (int j = 0; j < num_poles; j++) {
				double dist = Math.sqrt(Math.pow(poles[i][0] - poles[j][0], 2) + Math.pow(poles[i][1] - poles[j][1], 2));
				if (dist <= limit && dist < wires_connected[i][j]) {
					wires_connected[i][j] = dist;
					wires_connected[j][i] = dist;
				}
			}
		}
		dijkstra();
		if (distances[num_poles] == 900000000) System.out.println(-1);
		else {
			int dist = (int) (1000 * distances[num_poles]);
			System.out.println(dist);
		}
	}

	public static void dijkstra() {
		distances = new double[num_poles + 1];
		visited = new boolean[num_poles + 1];
		for (int i = 0; i < num_poles; i++) distances[i] = 900000000;
		distances[1] = 0;
		int nodesReached = 0, current = 0;
		while (nodesReached < num_poles) {
			double curDist = 900000000;
			for (int i = 0; i < num_poles; i++) {
				if (!visited[i] && distances[i] < curDist) {
					curDist = distances[i];
					current = i;
				}
			}
			visited[current] = true;
			nodesReached++;
			for (int i = 0; i < num_poles; i++) {
				if (!visited[i]) distances[i] = Math.min(distances[i], distances[current] + wires_connected[current][i]);
			}
		}
	}
	
}
*/


import java.io.*;
import java.util.Scanner;

public class pwrfail2 {

	static int[] distances;
	static boolean[] visited;
	static int vertices, source;
	static int[][] adjacency_matrix;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("pwrfail.in.txt"));
		PrintStream out = new PrintStream(new File("pwrfail.out.txt"));

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

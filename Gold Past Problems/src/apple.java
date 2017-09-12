import java.io.*;
import java.util.*;

public class apple {

	static int num_paths, num_pastures, start, end1, end2, dist;
	static int[][] adjacency_matrix;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("apple.in.txt"));
		PrintStream out = new PrintStream(new File("apple.out.txt"));

		num_paths = scan.nextInt();
		num_pastures = scan.nextInt();
		start = scan.nextInt();
		end1 = scan.nextInt();
		end2 = scan.nextInt();
		adjacency_matrix = new int[num_pastures + 1][num_pastures + 1];
		for (int i = 1; i <= num_pastures; i++) {
			for (int j = 1; j <= num_pastures; j++) {
				adjacency_matrix[i][j] = 900000000;
			}
		}
		for (int i = 1; i <= num_paths; i++) {
			int pasture_1 = scan.nextInt();
			int pasture_2 = scan.nextInt();
			int time = scan.nextInt();
			adjacency_matrix[pasture_1][pasture_2] = Math.min(time, adjacency_matrix[pasture_1][pasture_2]);
			adjacency_matrix[pasture_2][pasture_1] = Math.min(time, adjacency_matrix[pasture_2][pasture_1]);
		}

		dijkstra(start);
		dijkstra(end1);
		System.out.println(dist);
	}

	public static void dijkstra(int source) {
		int[] distances = new int[num_pastures + 1];
		boolean[] visited = new boolean[num_pastures + 1];
		for (int i = 1; i <= num_pastures; i++)
			distances[i] = 900000000;
		distances[source] = 0;
		int nodesReached = 0, current = 0;
		while (nodesReached < num_pastures) {
			int curDist = 900000000;
			for (int i = 1; i <= num_pastures; i++) {
				if (!visited[i] && distances[i] < curDist) {
					curDist = distances[i];
					current = i;
				}
			}
			visited[current] = true;
			nodesReached++;
			for (int i = 1; i <= num_pastures; i++) {
				if (!visited[i])
					distances[i] = Math.min(distances[i], distances[current] + adjacency_matrix[current][i]);
			}
		}
		if (source == start) {
			dist += Math.min(distances[end1], distances[end2]);
		} else {
			dist += distances[end2];
		}
	}
}

import java.io.*;
import java.util.*;

public class bestspot {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("bestspot.in.txt"));
		PrintStream out = new PrintStream(new File("bestspot.out.txt"));

		int num_pastures = scan.nextInt();
		int num_favorites = scan.nextInt();
		int num_paths = scan.nextInt();
		int[] favorites = new int[num_favorites + 1];
		for (int i = 1; i <= num_favorites; i++) {
			favorites[i] = scan.nextInt();
		}
		int[][] adjacency_matrix = new int[num_pastures + 1][num_pastures + 1];
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
		double min_average = 900000000;
		int best_pasture = 0;
		for (int source = 1; source <= num_pastures; source++) {
			// Dijkstra's
			boolean[] visited = new boolean[num_pastures + 1];
			int[] distances = new int[num_pastures + 1];
			for (int i = 1; i <= num_pastures; i++) {
				distances[i] = 900000000;
				visited[i] = false;
			}
			distances[source] = 0;
			int nodesReached = 0, current = 1;
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
					if (!visited[i]) {
						distances[i] = Math.min(distances[i], distances[current] + adjacency_matrix[current][i]);
					}
				}
			}
			double current_average = 0;
			for (int i = 1; i <= num_favorites; i++) {
				current_average += distances[favorites[i]];
			}
			current_average /= num_favorites;
			if (current_average < min_average) {
				min_average = current_average;
				best_pasture = source;
			}
			System.out.println(current_average);
		}

		System.out.println(best_pasture);

	}

}

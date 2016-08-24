import java.io.*;
import java.util.*;

public class cgiving2 {

	static int[] distances;
	static boolean[] visited;
	static int num_pastures, num_paths, num_bulls;
	static int[][] cowpaths;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("cgiving2.in.txt"));
		PrintStream out = new PrintStream(new File("cgiving.out.txt"));
		
		num_pastures = scan.nextInt();
		visited = new boolean[num_pastures];
		num_paths = scan.nextInt();
		num_bulls = scan.nextInt();
		int pasture1, pasture2, cost;
		cowpaths = new int[num_paths][num_paths];
		distances = new int[num_paths];
		for (int i = 0; i < num_paths; i++) {
			for (int j = 0; j < num_paths; j++) {
				cowpaths[i][j] = 999999999;
				cowpaths[j][i] = 999999999;
			}
		}
		for (int i = 0; i < num_paths; i++) {
			pasture1 = scan.nextInt();
			pasture2 = scan.nextInt();
			cost = scan.nextInt();
			if (cost < cowpaths[pasture1][pasture2]) {
				cowpaths[pasture1][pasture2] = cost;
				cowpaths[pasture2][pasture1] = cost;
			}
		}
		dijkstra();
		for (int i = 0; i < num_bulls; i++) {
			pasture1 = scan.nextInt();
			pasture2 = scan.nextInt();
			System.out.println(distances[pasture1] + distances[pasture2]);
		}

	}

	public static void dijkstra() {
		// Find shortest path from source node to every other node
		visited = new boolean[num_pastures];
		for (int i = 1; i < num_pastures; i++) distances[i] = 900000000;
		int nodesReached = 1;
		int current = 0;
		while (nodesReached < num_pastures) {
			int curDist = 900000000;
			for (int i = 0; i < num_pastures; i++) {
				if (!visited[i] && distances[i] < curDist) {
					curDist = distances[i];
					current = i;
				}
			}
			visited[current] = true;
			nodesReached++;
			for (int i = 0; i < num_pastures; i++) {
				if (!visited[i]) distances[i] = Math.min(distances[i], distances[current] + cowpaths[current][i]);
			}
		}
	}
}

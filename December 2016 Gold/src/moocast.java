import java.util.*;
import java.io.*;

public class moocast {
	
	static final int INF = 999999999;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file I/O
		Scanner in = new Scanner(new File("moocast.in"));
		PrintStream out = new PrintStream(new File("moocast.out"));
		
		// read in input
		int N = in.nextInt();
		int[][] pos = new int[N][2];
		for (int i = 0; i < N; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}
		
		int source = 0;
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = (int) (Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
			}
		}
		
		// distance to itself is 0
		for (int i = 0; i < N; i++) {
			adj[i][i] = 0;
		}
		
		boolean[] visited = new boolean[N];
		visited[source] = true;
		
		// initialize distance matrix with values from adjacency matrix
		int[] distances = new int[N];
		for (int i = 0; i < N; i++) {
			distances[i] = adj[source][i];
		}

		// loop N-1 times
		int prev = source;
		for (int i = 0; i < N - 1; i++) {
			// find the unvisited vertex with minimum distance to visited nodes
			int index = 0, distance = INF;
			for (int j = 0; j < N; j++) {
				if (distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			// update distance matrix with better distances
			for (int j = 0; j < N; j++) {
				if (visited[j]) continue;
				distances[j] = Math.min(adj[index][j], distances[j]);
			}
			prev = index;
		}
		int worst = 0;
		for (int i = 0; i < N; i++) {
			worst = Math.max(worst, distances[i]);
		}
		out.println(worst);
		
	}

}

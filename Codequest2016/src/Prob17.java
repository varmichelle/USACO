import java.util.*;
import java.io.*;

public class Prob17 {
	
	static int T;
	static int[][] honeycomb;
	static final int INF = 999999999;
	static Scanner in;
	static PrintStream out;
	static int[][][][] adj;
	static int V, E;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in =  new Scanner(new File("Prob17.in.txt"));
		out =  new PrintStream(new File("Prob17.out.txt"));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();
			V = N*(N+1)/2;
			E = V*6; // less than this
			honeycomb = new int[N][N];
			String input = in.next();
			for (int r = 1; r <= N; r++) {
				String line = in.next();
				String[] rowStr = line.split(",");
				for (int i = 0; i < r; i++) {
					honeycomb[r-1][i] = Integer.parseInt(rowStr[r]);
				}
			}
			int[] dc = {-1,0,-1,1,0,1};
			int[] dr = {-1,-1,0,0,1,1};
			// initialize adjacency matrix to INF
			for (int r1 = 0; r1 < N; r1++) {
				for (int c1 = 0; c1 < N; c1++) {
					for (int r2 = 0; r2 < N; r2++) {
						for (int c2 = 0; c2 < N; c2++) {
							adj[r1][c1][r2][c2] = INF;
							adj[r2][c2][r1][c1] = INF;
						}
					}
				}
			}
			// populate adjacency matrix
			
		}

	}
	
	public static void dijkstra(int source) {
		boolean[] visited = new boolean[V];
		visited[source] = true;
		
		// initialize distance matrix with values from adjacency matrix
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			distances[i] = adj[source][i];
		}

		// loop V-1 times
		for (int i = 0; i < V - 1; i++) {
			// find the unvisited vertex with minimum distance to visited nodes
			int index = 0, distance = INF;
			for (int j = 0; j < V; j++) {
				if (distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			System.out.println(index + " " + distance);
			// update distance matrix with better distances
			for (int j = 0; j < V; j++) {
				distances[j] = Math.min(distances[j], distances[index] + adj[index][j]);
			}
		}
		
		// print distances
		for (int i = 0; i < V; i++) {
			if (distances[i] == INF) System.out.println(-1);
			else System.out.println(distances[i]);
		}
	}

}

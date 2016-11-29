import java.util.*;
import java.io.*;

public class rblock {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("rblock.in.txt"));
		PrintStream out = new PrintStream(new File("rblock.out.txt"));
		
		int V = in.nextInt(); // number of vertices
		int E = in.nextInt(); // number of edges
		
		// initialize adjacency matrix with INF
		int[][] adj = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adj[i][j] = INF;
			}
		}
		
		// populate adjacency matrix with initial distances
		for (int i = 0; i < E; i++) {
			int vertex1 = in.nextInt() - 1;
			int vertex2 = in.nextInt() - 1;
			int dist = in.nextInt();
			adj[vertex1][vertex2] = Math.min(dist, adj[vertex1][vertex2]);
			adj[vertex2][vertex1] = adj[vertex1][vertex2];
		}
		
		// copy into a distance array
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			distances[i] = adj[0][i];
		}

		boolean[] visited = new boolean[V];
		visited[0] = true;
		int[] path = new int[V];
		int worstDistance = 0, originalDistance = 0;
		
		// run Dijkstra's on original matrix to find the edges needed
		for (int i = 0; i < V - 1; i++) {
			// find the unvisited vertex with min distance to visited nodes
			int index = 0, distance = INF;
			for (int j = 0; j < V; j++) {
				if (distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			path[i+1] = index;
			// update distance matrix with better distances
			for (int j = 0; j < V; j++) {
				distances[j] = Math.min(distances[j], distances[index] + adj[index][j]);
			}
			if (index == V - 1) {
				originalDistance = distances[V-1];
				break;
			}
		}
		
		// loop through the edges and double each 
		for (int i = 1; i < V; i++) {
			adj[path[i-1]][path[i]] *= 2;
			for (int j = 0; j < V; j++) {
				distances[j] = adj[0][j];
				visited[j] = false;
			}
			// run Dijkstra's
			for (int k = 0; k < V - 1; k++) {
				// find the unvisited vertex with min distance to visited nodes
				int index = 0, distance = INF;
				for (int j = 0; j < V; j++) {
					if (distances[j] < distance && !visited[j]) {
						distance = distances[j];
						index = j;
					}
				}
				visited[index] = true;
				path[k+1] = index;
				// update distance matrix with better distances
				for (int j = 0; j < V; j++) {
					distances[j] = Math.min(distances[j], distances[index] + adj[index][j]);
				}
				if (index == V - 1) break;
			}
			System.out.println(distances[V-1]);
			worstDistance = Math.max(worstDistance, distances[V-1]);
			// reset
			adj[path[i-1]][path[i]] /= 2;
			if (path[i] == V-1) break;
		}
		
		System.out.println(worstDistance - originalDistance);

	}

}

import java.util.*;
import java.io.*;

public class mst {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("mst.in.txt"));
		PrintStream out = new PrintStream(new File("mst.out.txt"));
		
		// read input
		int V = in.nextInt();
		int E = in.nextInt();
		
		// initialize distances in matrix to INF
		int[][] matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = INF;
			}
		}
		
		// read input distances
		for (int i = 0; i < E; i++) {
			int node1 = in.nextInt() - 1;
			int node2 = in.nextInt() - 1;
			int distance = in.nextInt();
			matrix[node1][node2] = distance;
			matrix[node2][node1] = distance;
		}
		
		// initialize distances to INF
		int distances[] = new int[V];
		for (int i = 0; i < V; i++) {
			distances[i] = INF;
		}
		
		boolean visited[] = new boolean[V];
		
		int start = 0;
		visited[start] = true;
		distances[start] = 0;
		
		for (int i = 0; i < V - 1; i++) {
			
		}

	}

}

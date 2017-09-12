import java.util.*;
import java.io.*;

public class danger {
	
	public static void main(String[] args) throws FileNotFoundException {

		// set up file readers and writers
		Scanner in = new Scanner(new File("danger.in.txt"));
		PrintStream out = new PrintStream(new File("danger.out.txt"));
		
		// read in input
		int N = in.nextInt();
		int M = in.nextInt();
		
		// grab the order in which to visit the islands
		int[] order = new int[M];
		for (int i = 0; i < M; i++) {
			order[i] = in.nextInt() - 1;
		}
		
		// populate the adjacency matrix with danger ratings
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = in.nextInt();
			}
		}
		
		// Floyd-Warshall
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		
		// find the minimally dangerous path
		int danger = 0;
		for (int i = 1; i < M; i++) {
			danger += adj[order[i-1]][order[i]];
		}
		System.out.println(danger);
		
	}

}

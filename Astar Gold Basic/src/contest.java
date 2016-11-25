import java.util.*;
import java.io.*;

public class contest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("contest.in.txt"));
		PrintStream out = new PrintStream(new File("contest.out.txt"));
		
		int N = in.nextInt(); // number of cows
		int M = in.nextInt(); // number of matches
		
		// directed graph with paths from winner to loser
		// 0 = not connected, 1 = connected
		int[][] graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			graph[in.nextInt() - 1][in.nextInt() - 1] = 1;
		}
		
		// Floyd-Warshall
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// if i-k and k-j are connected, then i-j is connected
					if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
				}
			}
		}
		
		// count number of cows whose rank can be determined
		int count = 0;
		for (int c = 0; c < N; c++) {
			boolean answer = true;
			for (int d = 0; d < N; d++) {
				if (d == c) continue;
				if (graph[c][d] == 0 && graph[d][c] == 0) answer = false;
			}
			if (answer) count++;
		}
		
		System.out.println(count);

	}

}

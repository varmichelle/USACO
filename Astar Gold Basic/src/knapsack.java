import java.util.*;
import java.io.*;

public class knapsack {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("knapsack.in.txt"));
		PrintStream out = new PrintStream(new File("knapsack.out.txt"));
		
		// read input
		int N = in.nextInt();
		int C = in.nextInt();
		int[] S = new int[N+1];
		int[] V = new int[N+1];
		for (int i = 1; i <= N; i++) {
			S[i] = in.nextInt();
			V[i] = in.nextInt();
		}
		
		int[][] dp = new int[C+1][N+1];
		// base case: adding the first item
		dp[S[1]][1] = V[1];
		
		for (int y = 2; y <= N; y++) {
			for (int x = 1; x <= C; x++) {
				// copy all cells from above
				dp[x][y] = dp[x][y-1];
				// check if possible to add the yth item
				if (x-S[y] >= 0) dp[x][y] = Math.max(dp[x][y], dp[x-S[y]][y-1] + V[y]);
				// progressively fill with max of current and previous
				dp[x][y] = Math.max(dp[x][y], dp[x-1][y]);
			}
		}
		System.out.println(dp[C][N]);
	}

}

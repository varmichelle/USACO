import java.util.*;
import java.io.*;

public class diet {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("diet.in.txt"));
		PrintStream out = new PrintStream(new File("diet.out.txt"));
		
		// read input
		int H = in.nextInt();
		int N = in.nextInt();
		int[] V = new int[N+1];
		for (int i = 1; i <= N; i++) V[i] = in.nextInt();
		
		int[][] dp = new int[H+1][N+1];
		// base case: adding the first item
		dp[V[1]][1] = 1;
		
		for (int y = 2; y <= N; y++) {
			for (int x = 1; x <= H; x++) {
				// copy all cells from above
				dp[x][y] = dp[x][y-1];
				// check if possible to add the yth item
				if (x-V[y] >= 0) dp[x][y] = Math.max(dp[x][y], dp[x-V[y]][y-1] + V[y]);
				// progressively fill with max of current and previous
				dp[x][y] = Math.max(dp[x][y], dp[x-1][y]);
			}
		}
		for (int i = H; i >= 0; i--) {
			if (dp[i][N] > 0) {
				System.out.println(i);
				break;
			}
		}
	}

}

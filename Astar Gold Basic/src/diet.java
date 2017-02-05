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
		
		boolean[][] dp = new boolean[H+1][N+1];
		// base case: adding the first item
		dp[V[1]][1] = true;
		
		for (int y = 2; y <= N; y++) {
			for (int x = 1; x <= H; x++) {
				// copy all cells from above
				dp[x][y] = dp[x][y-1];
				// check if possible to add the yth item
				if (x-V[y] >= 0) dp[x][y] = dp[x][y] || dp[x-V[y]][y-1];
			}
		}
		for (int i = H; i >= 0; i--) {
			if (dp[i][N]) {
				System.out.println(i);
				break;
			}
		}
	}

}

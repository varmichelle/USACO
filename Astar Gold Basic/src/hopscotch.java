import java.util.*;
import java.io.*;

public class hopscotch {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("hopscotch.in.txt"));
		PrintStream out = new PrintStream(new File("hopscotch.out.txt"));
		
		int R = in.nextInt();
		int C = in.nextInt();
		int K = in.nextInt();
		int[][] grid = new int[R][C];
		long[][] dp = new long[R][C];
		dp[0][0] = 1;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				grid[r][c] = in.nextInt();
				// loop up to r-1 and c-1 because the cow must jump at least 1 row and column
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						// make sure the cow is landing on a different number
						if (grid[i][j] != grid[r][c]) dp[r][c] += dp[i][j];
					}
				}
			}
		}
		
		System.out.println(dp[R-1][C-1] % 1000000007);
		
	}

}

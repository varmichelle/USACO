import java.util.*;
import java.io.*;

public class subset {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("subset.in.txt"));
		PrintStream out = new PrintStream(new File("subset.out.txt"));
		
		int N = in.nextInt();
		
		if (N*(N+1)/2 % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		}
		long[][] dp = new long[N*(N+1)/4+1][N+1];
		for (int i = 1; i <= N; i++) dp[i][i] = 1;
		for (int y = 2; y <= N; y++) {
			for (int x = 1; x <= N*(N+1)/4; x++) {
				// copy all cells from the above row
				dp[x][y] += dp[x][y-1];
			}
			// try adding y
			for (int x = 1; x <= N*(N+1)/4; x++) {
				if (x-y >= 0 && dp[x-y][y-1] > 0) dp[x][y]+= dp[x-y][y-1];
			}
		}
		System.out.println(dp[N*(N+1)/4][N]/2);
		
	}

}

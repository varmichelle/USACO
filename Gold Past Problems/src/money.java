import java.util.*;
import java.io.*;

public class money {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("money.in.txt"));
		PrintStream out = new PrintStream(new File("money.out.txt"));
		
		// read input
		int N = in.nextInt();
		int V = in.nextInt();
		int[] coins = new int[N+1];
		for (int i = 1; i <= N; i++) coins[i] = in.nextInt();
		
		long[][] dp = new long[V+1][N+1];
		// base case
		for (int i = 0; i <= N; i++) dp[0][i] = 1;
		
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= V; x++) {
				// copy everything from previous row
				dp[x][y] += dp[x][y-1];
				// add coin y
				for (int j = coins[y]; j <= V; j+= coins[y]) {
					if (x-j >= 0) dp[x][y]+= dp[x-j][y-1];
				}
			}
		}
		
		System.out.println(dp[V][N]);
		
	}

}

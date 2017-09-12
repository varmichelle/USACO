import java.util.*;
import java.io.*;

public class bullcow {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("bullcow.in.txt"));
		PrintStream out = new PrintStream(new File("bullcow.out.txt"));
		
		int N = in.nextInt();
		int K = in.nextInt();
		long[][] dp = new long[N][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		for (int i = 1; i < N; i++) {
			// can add a cow to anything (both cow and bull)
			dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 5000011;
			if (i > K) dp[i][1] = (dp[i-K-1][0] + dp[i-K-1][1]) % 5000011;
			else dp[i][1] = 1;
		}
		System.out.println((dp[N-1][0] + dp[N-1][1]) % 5000011);

	}

}

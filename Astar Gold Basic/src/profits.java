import java.util.*;
import java.io.*;

public class profits {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("profits.in.txt"));
		PrintStream out = new PrintStream(new File("profits.out.txt"));
		
		int N = in.nextInt();
		int[] profits = new int[N+1];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			profits[i] = in.nextInt();
			dp[i] = profits[i] + Math.max(dp[i-1], 0);
		}
		int max = -999999999;
		for (int i = 1; i <= N; i++) max = Math.max(max, dp[i]);
		System.out.println(max);
				
	}

}

import java.util.*;
import java.io.*;

public class lis {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("lis.in.txt"));
		PrintStream out = new PrintStream(new File("lis.out.txt"));
		
		int N = in.nextInt();
		int[] sequence = new int[N];
		// read in sequence 
		for (int i = 0; i < N; i++) sequence[i] = in.nextInt();
		int[] dp = new int[N];
		// initialize to 1
		for (int i = 1; i < N; i++) dp[i] = 1;
		// loop through to find dp[i]
		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (sequence[j] < sequence[i]) max = Math.max(max,dp[j]);
			}
			dp[i] = max + 1;
		}
		int max = 0;
		for (int i = 1; i < N; i++) max = Math.max(max, dp[i]);
		System.out.println(max);
		
	}

}

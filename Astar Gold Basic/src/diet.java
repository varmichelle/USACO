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
		
		boolean[] dp = new boolean[H+1];
		// base case: adding the first item
		dp[V[1]] = true;
		
		for (int y = 2; y <= N; y++) {
			for (int x = H; x >= V[y]; x--) {
				dp[x] = dp[x] || dp[x-V[y]];
			}
		}
		for (int i = H; i >= 0; i--) {
			if (dp[i]) {
				System.out.println(i);
				break;
			}
		}
	}

}

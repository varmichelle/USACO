/*
ID: michell26
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.*;

public class subset {
				
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("subset.in"));
		PrintStream out = new PrintStream(new File("subset.out"));
		
		int N = in.nextInt();
		// if half the sum isn't an integer, print 0 automatically 
		if (N*(N+1)/2 % 2 != 0) {
			out.println(0);
			System.exit(0);
		}
		// DP solution using recursion: f(n,k) = f(n,k-1) + f(n-k,k-1) 
		// where f(n,k) = number of ways to make n using the first k integers
		// the answer is then f(N(N+1)/4, N)/2 
		// because if some k numbers up to N sum to one subset,
		// then the other N-k numbers must sum to the other subset
		
		// size of DP: N is up to 39, max sum is 780 --> 800 by 40
		long[][] DP = new long[800][40];
		
		for (int i = 0; i <= N; i++) {
			// number of ways to make 0 with any set of numbers is 1
			DP[0][i] = 1;
		}
		
		// populate DP array using the recursion f(n,k) = f(n,k-1) + f(n-k,k-1) 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N*(N+1)/2; j++) {
				DP[j][i] += DP[j][i-1];
				if (j - i >= 0) DP[j][i] += DP[j-i][i-1];
			}
		}
		
		out.println(DP[N*(N+1)/4][N]/2);
		
	}

}

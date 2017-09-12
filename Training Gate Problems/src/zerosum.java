/*
ID: michell26
LANG: JAVA
TASK: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
			
	static int N;
	static PrintStream out;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("zerosum.in"));
		out = new PrintStream(new File("zerosum.out"));
		
		N = in.nextInt();
		dfs(1,"",1);		
		
	}
	
	public static void dfs(int depth, String current, int prev) {
		if (depth == N) {
			int sum = 1, spaceStorage = 1;
			for (int i = 0; i <= N-2; i++) {
				if (current.charAt(i) == '+') {
					spaceStorage = i+2;
					sum += spaceStorage;
					prev = 1;
				} else if (current.charAt(i) == '-') {
					spaceStorage = i+2;
					sum -= spaceStorage;
					prev = -1;
				} else {
					sum -= prev * spaceStorage;
					spaceStorage = spaceStorage * 10 + i+2;
					sum += prev * spaceStorage;
				}
			}
			if (sum == 0) {
				out.print(1);
				for (int i = 2; i <= N; i++) {
					out.print(current.charAt(i-2));
					out.print(i);
				}
				out.println();
			}
		}
		else {
			dfs(depth+1, current + " ", prev);
			dfs(depth+1, current + "+", prev);
			dfs(depth+1, current + "-", prev);
		}
	}

}

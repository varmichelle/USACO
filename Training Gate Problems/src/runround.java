/*
ID: michell26
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.*;

public class runround {
			
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("runround.in"));
		PrintStream out = new PrintStream(new File("runround.out"));
		
		long M = in.nextLong();
		// brute force: generate numbers with unique digits greater than M, check if runaround
		for (long N = M + 1; ; N++) {
			// make sure N has all unique digits
			int[] digits = new int[10];
			boolean works = true;
			for (int i = 1; i <= (N + "").length(); i++) {
				int digit = (int) ((N/(Math.pow(10, i-1)))%10);
				digits[digit]++;
			}
			if (digits[0] > 0) works = false;
			for (int i = 1; i < 10; i++) {
				if (digits[i] >= 2) works = false;
			}
			if (works) {
				// check if N is a runaround number
				int[] visited = new int[10];
				works = true;
				int startPoint = 0;
				for (int i = 0; i < (N + "").length(); i++) {
					int digit = (int) ((N/(Math.pow(10, (N + "").length()-1-startPoint)))%10);
					visited[(startPoint + digit) % (N+"").length()]++;
					startPoint = (startPoint + digit) % ((N+"").length());
				}
				for (int i = 1; i < 10; i++) {
					if (visited[i] >= 2) works = false;
				}
				if (works) {
					out.println(N);
					System.exit(0);
				}

			}
		}

	}

}

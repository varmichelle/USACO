/*
ID: michell26
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface {
			
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("preface.in"));
		PrintStream out = new PrintStream(new File("preface.out"));
		
		int N = in.nextInt();
		int[][] DP = new int[N + 1][7];
		// Roman Numerals: 
		// I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000
		DP[1][0] = 1;
		for (int i = 2; i <= N; i++) {
			// first copy the previous values (for DP)
			for (int j = 0; j < 7; j++) {
				DP[i][j] = DP[i - 1][j];
			}
			// next, check for special cases where it's not just appending a I
			// if going from 999 (CMXCIX) to 1000 (M)
			if (i % 1000 == 0) {
				System.out.println("999 --> 1000: " + i);
				DP[i][0] -= 1;
				DP[i][2] -= 2;
				DP[i][4] -= 2;
			} else if (i % 1000 == 900) {
				System.out.println("899 --> 900: " + i);
				// else if going from 899 (DCCCXCIX) to 900 (CM)
				DP[i][0] -= 1;
				DP[i][2] -= 2;
				DP[i][4] -= 3;
				DP[i][5] -= 1;
				DP[i][6] += 1;
			} else if (i % 500 == 0) {
				System.out.println("499 --> 500: " + i);
				// else if going from 499 (CDXCIX) to 500 (D)
				DP[i][0] -= 1;
				DP[i][2] -= 2;
				DP[i][4] -= 2;
			} else if (i % 1000 == 400) {
				System.out.println("399 --> 400: " + i);
				// if going from 399 (CCCXCIX) to 400 (CD)
				DP[i][0] -= 1;
				DP[i][2] -= 2;
				DP[i][4] -= 3;
				DP[i][5] += 1;
			} else if (i % 100 == 0) {
				System.out.println("99 --> 100: " + i);
				// else if going from 99 (XCIX) to 100 (C)
				DP[i][0] -= 1;
				DP[i][2] -= 2;
			} else if (i % 100 == 90) {
				System.out.println("89 --> 90: " + i);
				// else if going from 89 (LXXXIX) to 90 (XC)
				DP[i][0] -= 1;
				DP[i][2] -= 3;
				DP[i][3] -= 1;
				DP[i][4] += 1;
			} else if (i % 50 == 0) {
				System.out.println("49 --> 50: " + i);
				// else if going from 49 (XLIX) to 50 (L)
				DP[i][0] -= 1;
				DP[i][2] -= 2;
			} else if (i % 100 == 40) {
				System.out.println("39 --> 40: " + i);
				// else if going from 39 (XXXIX) to 40 (XL)
				DP[i][0] -= 1;
				DP[i][2] -= 3;
				DP[i][3] += 1;
			} else if (i % 10 == 0) {
				System.out.println("9 --> 10: " + i);
				// else if going from 9 (IX) to 10 (X)
				DP[i][0] -= 1;
			} else if (i % 10 == 9) {
				// else if going from 8 (VIII) to 9 (IX)
				System.out.println("8 --> 9: " + i);
				DP[i][0] -= 2;
				DP[i][1] -= 1;
				DP[i][2] += 1;
			} else if (i % 5 == 0) {
				System.out.println("4 --> 5: " + i);
				// else if going from 4 (IV) to 5 (V)
				DP[i][0] -= 1;
			} else if (i % 10 == 4) {
				System.out.println("3 --> 4: " + i);
				// else if going from 3 (III) to 4 (IV)
				DP[i][0] -= 2;
				DP[i][1] += 1;
			} else {
				// if none of the above "special moves" apply, simply add 1 I
				DP[i][0]++;
			}
		}
		// print results
		char[] dir = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		for (int i = 0; i < 7; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += DP[j][i];
			}
			if (sum == 0) System.exit(0);
			else out.println(dir[i] + " " + sum);
		}

	}

}

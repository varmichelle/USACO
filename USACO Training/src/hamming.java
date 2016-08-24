/*
ID: michell26
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
			
	static int N, B, D, count;
	static int[] codewords;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hamming.in"));
		PrintStream out = new PrintStream(new File("hamming.out"));
		
		N = in.nextInt();
		B = in.nextInt();
		D = in.nextInt();
		
		codewords = new int[N + 1];
		count = 1;
		codewords[count] = 0;
		for (int i = 1; i < Math.pow(2, B); i++) {
			if (check(i)) {
				count++;
				codewords[count] = i;
			}
			if (count == N) {
				for (int j = 1; j <= N; j++) {
					if (j % 10 == 0 && j != N) out.println(" " + codewords[j]);
					else if (j % 10 == 1) out.print(codewords[j]);
					else out.print(" " + codewords[j]);
				}
				out.println();
				System.exit(0);
			}
		}

	}

	public static boolean check(int i) {
		String a = "00000000" + Integer.toBinaryString(i);
		a = a.substring(a.length() - B);
		// loop through each codeword in the array
		for (int j = 1; j <= count; j++) {
			String b = "00000000" + Integer.toBinaryString(codewords[j]);
			b = b.substring(b.length() - B);
			int dist = 0;
			for (int k = 0; k < B; k++) {
				if (a.charAt(k) != b.charAt(k)) dist++;
			}
			if (dist < D) return false;
		}
		return true;
	}

}

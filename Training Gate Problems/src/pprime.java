/*
ID: michell26
LANG: JAVA
TASK: pprime
*/


import java.io.*;
import java.util.*;

public class pprime {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("pprime.in"));
		PrintStream out = new PrintStream(new File("pprime.out"));
		
		int a = in.nextInt();
		int b = in.nextInt();
		ArrayList<Integer> pprime = new ArrayList<Integer>();
		
		// odd # digit palindromes (up to 7 digits)
		outerloop:
			for (int d1 = 0; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					for (int d3 = 0; d3 <= 9; d3++) {
						for (int d4 = 0; d4 <= 9; d4++) {
							int palindrome = d1 + 10*d2 + 100*d3 + 1000*d4 + 10000*d3 + 100000*d2 + 1000000*d1;
							if (d1 == 0) {
								palindrome /= 10;
								if (d2 == 0) {
									palindrome /= 10;
									if (d3 == 0) {
										palindrome /= 10;
										if (d4 == 0) {
											palindrome /= 10;
										}
									}
								}
							}
							if (palindrome < a) continue;
							if (palindrome > b) break outerloop;
							if (checkPrime(palindrome)) pprime.add(palindrome);
						}
					}
				}
			}
		// the only prime palindrome with an even # digits is 11
		if (11 >= a && 11 <= b) pprime.add(11);
		Collections.sort(pprime);
		for (int i : pprime) out.println(i);
	}

	public static boolean checkPrime(int palindrome) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(palindrome); i++) {
			if (palindrome % i == 0) prime = false;
		}
		return prime;
		
	}

}

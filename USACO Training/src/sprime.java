/*
ID: michell26
LANG: JAVA
TASK: sprime
*/


import java.io.*;
import java.util.*;

public class sprime {

	static int N;
	static PrintStream out;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("sprime.in"));
		out = new PrintStream(new File("sprime.out"));
		
		N = in.nextInt();
		int[] primes = {2, 3, 5, 7};
		for (int i : primes) {
			build_sprime(i, 1);
		}
		
	}
	
	public static void build_sprime(int current, int length) {
		if (length == N) out.println(current);
		else {
			for (int i = 1; i <= 9; i+=2) {
				if (checkPrime(current * 10 + i)) build_sprime(current * 10 + i, length + 1);
			}
		}
	}

	public static boolean checkPrime(int number) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) prime = false;
		}
		return prime;
		
	}

}

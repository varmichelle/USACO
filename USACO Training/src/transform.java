

import java.io.*;
import java.util.*;

public class transform {

	static char[][] check, temporary;
	
	public static void main(String[] args) throws FileNotFoundException {
 
		Scanner scan = new Scanner(new File("transform.in"));
		PrintStream out = new PrintStream(new File("transform.out"));
				
		int N = scan.nextInt();
		char[][] before = new char[N][N];
		String calibrate = scan.nextLine();
		for (int i = 0; i < N; i++) {
			String temp = scan.nextLine();
			for (int j = 0; j < N; j++) {
				before[j][i] = temp.charAt(j);
			}
		}
		char[][] after = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = scan.nextLine();
			for (int j = 0; j < N; j++) {
				after[j][i] = temp.charAt(j);
			}
		}
		check = new char[N][N];
		temporary = new char[N][N];
				
		// Move 1
		check = rotate_90(N, before);
		if (check_equal(check, after, N)){
			out.println("1");
			System.exit(0);
		}
		reset_check(N, before);
		
		// Move 2
		check = rotate_90(N, before);
		copy(N);
		check = rotate_90(N, temporary);
		if (check_equal(check, after, N)){
			out.println("2");
			System.exit(0);
		}
		reset_check(N, before);
		
		// Move 3
		check = rotate_90(N, before);
		copy(N);
		check = rotate_90(N, temporary);
		copy(N);
		check = rotate_90(N, temporary);
		if (check_equal(check, after, N)){
			out.println("3");
			System.exit(0);
		}
		reset_check(N, before);
		
		// Move 4
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[j][i] = before[N-j-1][i];
			}
		}
		if (check_equal(check, after, N)) {
			out.println("4");
			System.exit(0);
		}
		reset_check(N, before);
		
		// Move 5
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[j][i] = before[N-j-1][i];
			}
		}
		for (int i = 0; i < 3; i++) {
			copy(N);
			check = rotate_90(N, temporary);
			if (check_equal(check, after, N)){
				out.println("5");
				System.exit(0);
			} 
		}
		reset_check(N, before);
		
		// Move 6
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (before[j][i] != after[j][i]) {
					out.println("7");
					System.exit(0);
				}
			}
		}
		out.println("6");
		System.exit(0);
	}

	static char[][] rotate_90(int N, char[][] before) {
		// Rotate array 90 degrees
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[j][i] = before[i][N-j-1];
			}
		}
		return check;
	}
	
	static void reset_check(int N, char[][] reset) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[j][i] = reset[j][i];
			}
		}
	}
	
	static boolean check_equal(char[][] array_1, char[][] array_2, int N) {
		boolean equal = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array_1[j][i] != array_2[j][i]) equal = false;
			}
		}
		return equal;
	}
	
	static void copy(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temporary[j][i] = check[j][i];
			}
		}
	}
}

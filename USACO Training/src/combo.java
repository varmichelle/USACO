/*
ID: michell26
LANG: JAVA
TASK: combo
*/


import java.io.*;
import java.util.*;

public class combo {
	
	static int N;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("combo.in"));
		PrintStream out = new PrintStream(new File("combo.out"));
		
		int num_solutions = 0;
		N = in.nextInt();
		int FJ1 = in.nextInt();
		int FJ2 = in.nextInt();
		int FJ3 = in.nextInt();
		int M1 = in.nextInt();
		int M2 = in.nextInt();
		int M3 = in.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					// check if close enough to FJ's combo
					if (close(FJ1, k) && close(FJ2, j) && close(FJ3, i)) num_solutions++;
					// check if close enough to master combo
					else if (close(M1, k) && close(M2, j) && close(M3, i)) num_solutions++;
				}
			}
		}
		out.println(num_solutions);

	}
	
	public static boolean close(int a, int b) {
		if (Math.abs(a-b) <= 2 || Math.abs(a-b) >= (N - 2)) return true;
		else return false;
	}

}

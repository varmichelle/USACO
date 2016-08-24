/*
ID: michell26
LANG: JAVA
TASK: ariprog
*/


import java.io.*;
import java.util.*;

public class ariprog {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("ariprog.in"));
		PrintStream out = new PrintStream(new File("ariprog.out"));
		
		int length = in.nextInt();
		int upper_bound = in.nextInt();
		boolean[] bisquares = new boolean[(int) (2 * Math.pow(upper_bound, 2) + 1)];
		
		// generate all bisquares within bounds to fill bisquare array
		for (int p = 0; p <= upper_bound; p++) {
			for (int q = 0; q <= upper_bound; q++) {
				bisquares[(int) (Math.pow(p, 2) + Math.pow(q, 2))] = true;
			}
		}
		
		boolean any = false;
		// loop through differences between terms
		for (int d = 1; d <= 2 * Math.pow(upper_bound, 2) / (length - 1); d++) {
			// loop through starting numbers
			for (int a = 0; a <= 2 * Math.pow(upper_bound, 2); a++) {
				boolean seq = true;
				if (a + (length - 1) * d <= 2 * Math.pow(upper_bound, 2)) {
					for (int term = 0; term < length; term++) {
						if (bisquares[a + term * d] == false) seq = false; 
					}
					if (seq) {
						out.println(a + " " + d);
						any = true;
					}
				}
			}
		}
		if (!any) out.println("NONE");

	}

}

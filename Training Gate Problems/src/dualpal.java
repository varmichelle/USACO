

import java.io.*;
import java.util.*;

public class dualpal {
	
	public static void main(String[] args) throws FileNotFoundException {
 
		Scanner scan = new Scanner(new File("dualpal.in"));
		PrintStream out = new PrintStream(new File("dualpal.out"));
		
		int N = scan.nextInt();
		int S = scan.nextInt();
		
		int palindromes = 0;
		int current = S + 1;
		int num = 0;
		while (palindromes < N) {
			for (int i = 2; i <= 10; i++) {
				String forward = Long.toString(current, i);
				String reverse = new StringBuilder(forward).reverse().toString();
				if (forward.equals(reverse)) num++;
			}
			if (num > 1) {
				out.println(current);
				palindromes++;
			}
			current++;
			num = 0;
		}
		
	}

}

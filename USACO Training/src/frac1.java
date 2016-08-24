/*
ID: michell26
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("frac1.in"));
		PrintStream out = new PrintStream(new File("frac1.out"));
		
		int n = in.nextInt();
		fraction[] fractions = new fraction[n*n];
		int count = 0;
		for (int num = 0; num < n; num++) {
			for (int den = 1; den <= n; den++) {
				fraction frac = new fraction();
				if (!common(num, den)) {
					frac.num = num;
					frac.den = den;
				} else {
					frac.num = -1;
					frac.den = 1;
				}
				fractions[count] = frac;
				count++;
			}
		}
		Arrays.sort(fractions);
		out.println("0/1");
		for (int i = 0; i < n*n; i++) {
			if (fractions[i].num/fractions[i].den > 0 && fractions[i].num/fractions[i].den < 1) {
				out.println((int) fractions[i].num + "/" + (int) fractions[i].den);
			}
		}
		out.println("1/1");

	}

	public static boolean common(int num, int den) {
		for (int i = 2; i <= num; i++) {
			if (num % i == 0 && den % i == 0) return true;
		}
		return false;
	}

}

class fraction implements Comparable<fraction>{
	float num, den;
	public int compareTo(fraction x) {
		return Double.compare(this.num/this.den, x.num/x.den);
	}
}
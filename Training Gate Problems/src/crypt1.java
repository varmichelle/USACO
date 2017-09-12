/*
ID: michell26
LANG: JAVA
TASK: crypt1
*/


import java.io.*;
import java.util.*;

public class crypt1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("crypt1.in"));
		PrintStream out = new PrintStream(new File("crypt1.out"));
		
		int num_solutions = 0;
		int N = in.nextInt();
		int[] digits = new int[N];
		Set<Integer> digit_set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			int num = in.nextInt();
			digits[i] = num;
			digit_set.add(num);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						for (int m = 0; m < N; m++) {
							// generate all possible values of a, b, c, d, and e
							int a = digits[i];
							int b = digits[j];
							int c = digits[k];
							int d = digits[l];
							int e = digits[m];
							boolean met_req = true;
							// check abc * e
							int p1 = (100*a + 10*b + c) * e;
							if ((1000 - p1) < 0) continue;
							for (int index = 0; index < 3; index++) {
								int last_digit = p1 % 10;
								if (!digit_set.contains(last_digit)) met_req = false;
								p1 /= 10;
							}
							// check abc * d
							int p2 = (100*a + 10*b + c) * d;
							if ((1000 - p2) < 0) continue;
							for (int index = 0; index < 3; index++) {
								int last_digit = p2 % 10;
								if (!digit_set.contains(last_digit)) met_req = false;
								p2 /= 10;
							}
							// check abc * de
							int product = (100*a + 10*b + c) * (10*d + e);
							if (10000 - product < 0) continue;
							for (int index = 0; index < 4; index++) {
								int last_digit = product % 10;
								if (!digit_set.contains(last_digit)) met_req = false;
								product /= 10;
							}
							if (met_req) num_solutions++;
						}
					}
				}
			}
		}
		out.println(num_solutions);

	}

}

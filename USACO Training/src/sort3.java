/*
ID: michell26
LANG: JAVA
TASK: sort3
*/

// NEW (BETTER) SOLUTION
import java.io.*;
import java.util.*;

public class sort3 {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("sort3.in"));
		PrintStream out = new PrintStream(new File("sort3.out"));
		
		int n = in.nextInt();
		int[] records = new int[n];
		int[] sorted = new int[n];
		int num1 = 0, num2 = 0, num3 = 0;
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (num == 1) num1++;
			if (num == 2) num2++;
			if (num == 3) num3++;
			records[i] = num;
			sorted[i] = num;
		}
		Arrays.sort(sorted);
		int s12 = 0, s13 = 0, s23 = 0, s21 = 0, s32 = 0, s31 = 0;
		// check for pairs of misplaced elements
		// check in 1 for 2 and 3
		for (int i = 0; i < num1; i++) {
			if (records[i] == 2) s12++;
			if (records[i] == 3) s13++;
		}
		// check in 2 for 1 and 3
		for (int i = num1; i < num1 + num2; i++) {
			if (records[i] == 1) s21++;
			if (records[i] == 3) s23++;
		}
		// check in 3 for 1 and 2
		for (int i = num1 + num2; i < n; i++) {
			if (records[i] == 1) s31++;
			if (records[i] == 2) s32++;
		}
		int moves = Math.min(s12, s21) + Math.min(s13, s31) + Math.min(s23, s32);
		moves += 2 * (Math.abs(s12 - s21) + Math.abs(s13 - s31) + Math.abs(s23 - s32)) / 3;
		out.println(moves);
	}
	
}

// MY ORIGINAL SOLUTION

/* import java.io.*;
import java.util.*;

public class sort3 {

	static int n, num1 = 0, num2 = 0, num3 = 0, oop_type, oop, oop_index, moves = 0, backup;
	static int[] records, sorted;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("sort3.in"));
		PrintStream out = new PrintStream(new File("sort3.out"));
		
		n = in.nextInt();
		records = new int[n];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (num == 1) num1++;
			if (num == 2) num2++;
			if (num == 3) num3++;
			records[i] = num;
		}
		
		sorted = new int[n];
		for (int i = 0; i < num1; i++) sorted[i] = 1;
		for (int j = num1; j < num1 + num2; j++) sorted[j] = 2;
		for (int k = num1 + num2; k < n; k++) sorted[k] = 3;
		while (!isEqual()) {
			findBestIndex();
		}
		out.println(moves);
	}

	public static boolean isEqual() {
		for (int i = 0; i < n; i++) {
			if (records[i] != sorted[i]) return false;
		}
		return true;
	}
	
	public static void findBestIndex() {
		for (int i = 0; i < n; i++) {
			if (records[i] != sorted[i]) {
				if (i < num1) oop_type = 1;
				else if (i < num1 + num2) oop_type = 2;
				else oop_type = 3;
				if (records[i] == 1) {
					for (int j = 0; j < num1; j++) {
						if (records[j] == oop_type) {
							records[j] = sorted[j];
							records[i] = sorted[i];
							moves++;
							return;
						}
					}
				} else if (records[i] == 2) {
					for (int j = num1; j < num1 + num2; j++) {
						if (records[j] == oop_type) {
							records[j] = sorted[j];
							records[i] = sorted[i];
							moves++;
							return;
						}
					}
				} else if (records[i] == 3) {
					for (int j = num1 + num2; j < n; j++) {
						if (records[j] == oop_type) {
							records[j] = sorted[j];
							records[i] = sorted[i];
							moves++;
							return;
						}
					}
				}
				backup = i;
			}
			if (i == n-1) {
				for (int j = oop_index + 1; j < n; j++) {
					if (records[j] != sorted[j] && records[j] != records[backup]) {
						oop = records[backup];
						records[backup] = records[j];
						records[j] = oop;
						moves++;
						return;
					}
				}
			}
		}
	}

} */

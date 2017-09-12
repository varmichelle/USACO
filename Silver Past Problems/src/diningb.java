import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class diningb {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("diningb.in"));
		PrintStream fileWriter = new PrintStream(new File("diningb.out"));
		int n = fileReader.nextInt();
		// fileWriter.println(n);
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			cows[i] = fileReader.nextInt();
			// fileWriter.println(cows[i]);
		}
		int mintotal = 2147483647;
		int[] total = new int[3*n];
		int group1changeto1 = 0, group2changeto2 = 0, group1changeto2 = 0, group2changeto1 = 0, q = 0;
		for (int split = 0; split < n; split++) {
			for (int i = 0; i < split; i++) {
				// System.out.println("cows["+i+"] is " + cows[i]);
				if (cows[i]==2) {
					group1changeto1++;
					// System.out.println("cows["+i+"] is " + 2);
				} else {
					group1changeto2++;
					// System.out.println("cows["+i+"] is " + 1);
				}
			}
			for (int j = split; j < n; j++) {
				// System.out.println("cows["+j+"] is " + cows[j]);
				if (cows[j]==1) {
					group2changeto2++;
					// System.out.println("cows["+j+"] is " + 1);
				} else {
					group2changeto1++;
					// System.out.println("cows["+j+"] is " + 2);
				}
			}
			total[q] = group1changeto1 + group2changeto2;
			//System.out.println("At breakpoint "+ split + ", total was: " + total[q]);
			q++;
			total[q] = group1changeto1 + group2changeto1;
			// System.out.println("At breakpoint "+ split + ", total was: " + total[q]);
			q++;
			total[q] = group1changeto2 + group2changeto2;
			// System.out.println("At breakpoint "+ split + ", total was: " + total[q]);
			q++;
			group1changeto1 = 0;
			group2changeto2 = 0;
			group1changeto2 = 0;
			group2changeto1 = 0;
		}
		Arrays.sort(total);
		fileWriter.println(total[0]);
		
	}
}

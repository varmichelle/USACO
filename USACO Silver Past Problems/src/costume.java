import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class costume {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("costume.in"));
		PrintStream fileWriter = new PrintStream(new File("costume.out"));

		int n = fileReader.nextInt();
		int s = fileReader.nextInt();
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			cows[i] = fileReader.nextInt();
		}
		Arrays.sort(cows);
		
		/* int low = 0, high = n;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (cows[mid] > s) {
				high = mid;
			} else if (cows[mid] < s) {
				low = mid;
			} else if (cows[mid] == s) {
				for (int i = mid; i < n; i++) {
					cows[i] = 0;
				}
				break;
			}
			if (high == low + 1) {
				for (int i = mid; i < n; i++) {
					cows[i] = 0;
				}
				break;
			}
		} */
		int goodPairs = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j <n; j++) {
				if (cows[i] + cows[j] <= s) {
					goodPairs++;
				}
			}
		}
		fileWriter.println(goodPairs);

	} 

}

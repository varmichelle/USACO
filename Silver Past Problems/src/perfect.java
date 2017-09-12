import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class perfect {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("perfect.in"));
		PrintStream fileWriter = new PrintStream(new File("perfect.out"));
		int n = fileReader.nextInt();

		int[] medians = new int[n];
		for (int i = 0; i < n; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				temp[j] = fileReader.nextInt();
				System.out.print(temp[j] + " ");
			}
			System.out.println();
			Arrays.sort(temp);
			medians[i] = temp[(n + 1) / 2 - 1];
		}
		Arrays.sort(medians);
		fileWriter.println(medians[(n + 1) / 2 - 1]);

	}

}

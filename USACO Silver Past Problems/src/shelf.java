import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class shelf {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("shelf.in"));
		PrintStream fileWriter = new PrintStream(new File("shelf.out"));
		int n = fileReader.nextInt();
		int b = fileReader.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = fileReader.nextInt();
		}
		Arrays.sort(heights);
		int sum = 0;
		int currentCow = 0;
		while (sum < b) {
			sum+=heights[n-currentCow-1];
			currentCow++;
		}
		fileWriter.println(currentCow);

	}

}

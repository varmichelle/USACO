import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class builtInSort {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("strings.txt"));
		PrintStream fileWriter = new PrintStream(new File("builtInSortStrings.txt"));
		// Read in input
		int numStrings = fileReader.nextInt();
		String[] strings = new String[numStrings];
		for (int i = 0; i < numStrings; i++) {
			strings[i] = fileReader.next();
		}
		Arrays.sort(strings);
		fileWriter.println("Alphabetical order: ");
		for (int i = 0; i < numStrings; i++) {
			fileWriter.print(strings[i] + " ");
		}
		fileWriter.println();
		fileWriter.println("Reverse alphabetical order: ");
		for (int i = numStrings - 1; i >= 0; i--) {
			fileWriter.print(strings[i] + " ");
		}
		fileWriter.println();

	}

}

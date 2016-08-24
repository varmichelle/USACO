import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class builtInSortIntegers {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("numbers.txt"));
		PrintStream fileWriter = new PrintStream(new File("builtInSortIntegers.txt"));
		// Read in input
		int numNums = fileReader.nextInt();
		int[] numbers = new int[numNums];
		for (int i = 0; i < numNums; i++) {
			numbers[i] = fileReader.nextInt();
		}
		Arrays.sort(numbers);
		fileWriter.println("Least to greatest: ");
		for (int i = 0; i < numNums; i++) {
			fileWriter.print(numbers[i] + " ");
		}
		fileWriter.println();
		fileWriter.println("Greatest to least: ");
		for (int i = numNums - 1; i >= 0; i--) {
			fileWriter.print(numbers[i] + " ");
		}
		fileWriter.println();

	}

}
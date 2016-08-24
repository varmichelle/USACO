import java.io.*;
import java.util.Scanner;

public class numbers {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("numbers.txt"));
		PrintStream fileWriter = new PrintStream(new File("sorted.txt"));

		// Read in input
		int numNum = fileReader.nextInt() * 2;
		int[] numbers = new int[numNum];
		for (int i = 0; i < numNum; i++) {
			numbers[i] = fileReader.nextInt();
		}

		// switch1 = value of smallest number (ignoring the first j numbers
		// because they have already been sorted)
		int switch1;
		// switch2 = value of number currently at position j
		int switch2;

		for (int j = 0; j < numNum; j++) {
			int index = smallestNum(numbers, numNum, j);
			switch1 = numbers[index];
			switch2 = numbers[j];
			numbers[j] = switch1;
			numbers[index] = switch2;
		}

		for (int m = 0; m < numNum; m++) {
			fileWriter.print(numbers[m] + " ");
		}
		fileWriter.println();

	}

	public static int smallestNum(int[] numbers, int numNum, int currentIndex) {
		int smallest = numbers[currentIndex];
		int indexOfSmallest = currentIndex;
		for (int k = 1 + currentIndex; k < numNum; k++) {
			if (numbers[k] < smallest) {
				smallest = numbers[k];
				indexOfSmallest = k;
			}
		}
		// System.out.println(smallest);
		return indexOfSmallest;
	}

}

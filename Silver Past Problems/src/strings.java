import java.io.*;
import java.util.Scanner;

public class strings {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("strings.txt"));
		PrintStream fileWriter = new PrintStream(new File("sorted.txt"));

		// Read in input
		int numStrings = fileReader.nextInt();
		String[] strings = new String[numStrings];
		for (int i = 0; i < numStrings; i++) {
			strings[i] = fileReader.next();
		}

		// switch1 = value of smallest number (ignoring the first j numbers
		// because they have already been sorted)
		String switch1;
		// switch2 = value of number currently at position j
		String switch2;

		for (int j = 0; j < numStrings; j++) {
			int index = smallestString(strings, numStrings, j);
			switch1 = strings[index];
			switch2 = strings[j];
			strings[j] = switch1;
			strings[index] = switch2;
		}

		for (int m = numStrings-1; m >= 0; m--) {
			fileWriter.print(strings[m] + " ");
		}
		fileWriter.println();

	}

	public static int smallestString(String[] strings, int numStrings, int currentIndex) {
		String smallest = strings[currentIndex];
		int indexOfSmallest = currentIndex;
		for (int k = 1 + currentIndex; k < numStrings; k++) {
			if (strings[k].compareTo(smallest) < 0) {
				smallest = strings[k];
				indexOfSmallest = k;
			}
		}
		// System.out.println(smallest);
		return indexOfSmallest;
	}

}

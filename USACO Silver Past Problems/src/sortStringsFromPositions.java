import java.io.*;
import java.util.Scanner;

public class sortStringsFromPositions {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("stringsPos.txt"));
		PrintStream fileWriter = new PrintStream(new File("sortedStringsPos.txt"));

		// Read in input
		int numStrings = fileReader.nextInt();
		int pos1 = fileReader.nextInt();
		int pos2 = fileReader.nextInt();
		String[] strings = new String[numStrings];
		for (int i = 0; i < numStrings; i++) {
			strings[i] = fileReader.next();
		}

		// switch1 = value of smallest number (ignoring the first j numbers
		// because they have already been sorted)
		String switch1;
		// switch2 = value of number currently at position j
		String switch2;

		for (int j = pos1; j < pos2; j++) {
			int index = smallestString(strings, numStrings, j, pos2);
			switch1 = strings[index];
			switch2 = strings[j];
			strings[j] = switch1;
			strings[index] = switch2;
		}

		for (int m = 0; m < numStrings; m++) {
			fileWriter.print(strings[m] + " ");
		}
		fileWriter.println();

	}

	public static int smallestString(String[] strings, int numStrings,
			int currentIndex, int pos2) {
		String smallest = strings[currentIndex];
		int indexOfSmallest = currentIndex;
		for (int k = 1 + currentIndex; k < pos2; k++) {
			if (strings[k].compareTo(smallest) < 0) {
				smallest = strings[k];
				indexOfSmallest = k;
			}
		}
		// System.out.println(smallest);
		return indexOfSmallest;
	}

}

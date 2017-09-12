import java.util.Scanner;
import java.io.*;

public class coggle {

	static char[][] tempMatrix = new char[5][5];
	static int numWordsFound = 0;
	static char[][] matrix = new char[5][5];
	static PrintStream fileWriter;
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dictionaryLength = 0;
	static boolean wordFound = false;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("coggle.in"));
		fileWriter = new PrintStream(new File("coggle.out"));

		// Read in input
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				matrix[row][col] = fileReader.next().charAt(0);
				tempMatrix[row][col] = matrix[row][col];
			}
		}
		String calibrate = fileReader.nextLine();
		String[] dictionary = new String[25000];
		int currentIndex = -1;
		while (fileReader.hasNextLine()) {
			currentIndex++;
			dictionary[currentIndex] = fileReader.nextLine();
			dictionaryLength++;
		}
		for (int i = 0; i < dictionaryLength; i++) {
			int index = 0;
			String current = "";
			int row = 0;
			int col = 0;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					tempMatrix[j][k] = matrix[j][k];
				}
			}
			wordFound = false;
			findWord(dictionary[i], index, current, row, col);
			if (wordFound == true) {
				numWordsFound++;
			}
		}
		fileWriter.println(numWordsFound);
	}

	public static void findWord(String word, int index, String current,
			int row, int col) {
		if (current.equals(word)) {
			wordFound = true;
			return;
		} else if (!wordFound) {
			if (index == 0) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (tempMatrix[i][j] == word.charAt(index)) {
							tempMatrix[i][j] = '.';
							findWord(word, index + 1, current
									+ word.charAt(index), i, j);
							tempMatrix[i][j] = word.charAt(index);
						}
					}
				}
			} else if (index > 0 && index < word.length()) {
				// Up and left
				char holder;
				if (row > 0 && col > 0) {
					if (tempMatrix[row - 1][col - 1] == word.charAt(index)) {
						tempMatrix[row - 1][col - 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row - 1, col - 1);
						tempMatrix[row - 1][col - 1] = word.charAt(index);
					}
				}
				// Up and right
				if (row > 0 && col < 4) {
					if (tempMatrix[row - 1][col + 1] == word.charAt(index)) {
						tempMatrix[row - 1][col + 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row - 1, col + 1);
						tempMatrix[row - 1][col + 1] = word.charAt(index);
					}
				}
				// Straight up
				if (row > 0) {
					if (tempMatrix[row - 1][col] == word.charAt(index)) {
						tempMatrix[row - 1][col] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row - 1, col);
						tempMatrix[row - 1][col] = word.charAt(index);
					}
				}
				// Straight left
				if (col > 0) {
					if (tempMatrix[row][col - 1] == word.charAt(index)) {
						tempMatrix[row][col - 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row, col - 1);
						tempMatrix[row][col - 1] = word.charAt(index);
					}
				}
				// Straight right
				if (col < 4) {
					if (tempMatrix[row][col + 1] == word.charAt(index)) {
						tempMatrix[row][col + 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row, col + 1);
						tempMatrix[row][col + 1] = word.charAt(index);
					}
				}
				// Down and left
				if (row < 4 && col > 0) {
					if (tempMatrix[row + 1][col - 1] == word.charAt(index)) {
						tempMatrix[row + 1][col - 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row + 1, col - 1);
						tempMatrix[row + 1][col - 1] = word.charAt(index);
					}
				}
				// Straight down
				if (row < 4) {
					if (tempMatrix[row + 1][col] == word.charAt(index)) {
						tempMatrix[row + 1][col] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row + 1, col);
						tempMatrix[row + 1][col] = word.charAt(index);
					}
				}
				// Down and right
				if (row < 4 && col < 4) {
					if (tempMatrix[row + 1][col + 1] == word.charAt(index)) {
						tempMatrix[row + 1][col + 1] = '.';
						findWord(word, index + 1, current + word.charAt(index),
								row + 1, col + 1);
						tempMatrix[row + 1][col + 1] = word.charAt(index);
					}
				}
			} else {
				return;
			}

		}
	}

}

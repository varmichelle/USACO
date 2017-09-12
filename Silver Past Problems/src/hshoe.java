import java.util.*;
import java.io.*;

public class hshoe {

	static char[][] tempMatrix;
	static char[][] matrix;
	static PrintStream fileWriter;
	static int length;
	static int n;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("hshoe.in"));
		fileWriter = new PrintStream(new File("hshoe.out"));

		// Read in input
		n = fileReader.nextInt();
		String temp = "";
		matrix = new char[n][n];
		tempMatrix = new char[n][n];
		for (int i = 0; i < n; i++) {
			temp = fileReader.next();
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp.charAt(j);
				tempMatrix[i][j] = temp.charAt(j);
			}
		}
		length = (n * n) - ((n * n) % 2);
		String string = "";
		for (int i = length; i >= 0; i -= 2) {
			for (int k = 0; k < i / 2; k++) {
				string += "(";
			}
			for (int k = 0; k < i / 2; k++) {
				string += ")";
			}
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					tempMatrix[j][k] = matrix[j][k];
				}
			}
			char holder = tempMatrix[0][0];
			tempMatrix[0][0] = '.';
			findString(string, 1, "" + holder, 0, 0, i);
			string = "";
		}
		fileWriter.println(0);
	}

	public static void findString(String string, int index, String current,
			int row, int col, int length) {
		if (current.equals(string)) {
			fileWriter.println(length);
			System.exit(0);
		} else if (index < string.length()) {
			// Straight up
			if (row > 0) {
				if (tempMatrix[row - 1][col] == string.charAt(index)) {
					tempMatrix[row - 1][col] = '.';
					findString(string, index + 1,
							current + string.charAt(index), row - 1, col, length);
					tempMatrix[row - 1][col] = string.charAt(index);
				}
			}
			// Straight left
			if (col > 0) {
				if (tempMatrix[row][col - 1] == string.charAt(index)) {
					tempMatrix[row][col - 1] = '.';
					findString(string, index + 1,
							current + string.charAt(index), row, col - 1, length);
					tempMatrix[row][col - 1] = string.charAt(index);
				}
			}
			// Straight right
			if (col < n - 1) {
				if (tempMatrix[row][col + 1] == string.charAt(index)) {
					tempMatrix[row][col + 1] = '.';
					findString(string, index + 1,
							current + string.charAt(index), row, col + 1, length);
					tempMatrix[row][col + 1] = string.charAt(index);
				}
			}
			// Straight down
			if (row < n - 1) {
				if (tempMatrix[row + 1][col] == string.charAt(index)) {
					tempMatrix[row + 1][col] = '.';
					findString(string, index + 1,
							current + string.charAt(index), row + 1, col, length);
					tempMatrix[row + 1][col] = string.charAt(index);
				}
			}
		} else {
			return;
		}
	}
}

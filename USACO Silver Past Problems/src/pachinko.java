import java.io.*;
import java.util.Scanner;

public class pachinko {
	static int currentMax = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("pachinko.in"));
		PrintStream fileWriter = new PrintStream(new File("pachinko.out"));
		int numRows = fileReader.nextInt();
		int[][] points = new int[numRows][numRows];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j <= i; j++) {
				points[i][j] = fileReader.nextInt();
			}
		}
		int currentRow = 0, currentCol = 0, testMax = 0;
		recurse(currentRow, currentCol, numRows, points, testMax);
		fileWriter.println(currentMax);
	}

	public static void recurse(int currentRow, int currentCol, int numRows,
			int[][] points, int testMax) {
		if (currentRow == numRows) {
			if (testMax > currentMax)
				currentMax = testMax;
		} else {
			recurse(currentRow + 1, currentCol + 1, numRows, points, testMax
					+ points[currentRow][currentCol]);
			recurse(currentRow + 1, currentCol, numRows, points, testMax
					+ points[currentRow][currentCol]);
		}
	}
}
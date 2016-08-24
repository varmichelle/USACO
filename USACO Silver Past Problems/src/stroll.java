import java.util.Scanner;
import java.io.*;

public class stroll {

	static char[][] field;
	static int[][] pathLengths;
	static int rows, cols;
	static PrintStream fileWriter;
	static int start_row, start_col, finish_row, finish_col;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("stroll.in"));
		fileWriter = new PrintStream(new File("stroll.out"));
		
		rows = fileReader.nextInt();
		cols = fileReader.nextInt();
		field = new char[rows][cols];
		pathLengths = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pathLengths[i][j] = 1;
			}
		}
		
		String calibrate = fileReader.nextLine();
		for (int i = 0; i < rows; i++) {
			String temp = fileReader.nextLine();
			for (int j = 0; j < cols; j++) {
				field[i][j] = temp.charAt(2 * j);
				if (field[i][j] == 'B') {
					if (i != start_row && j != start_col) {
						finish_row = i;
						finish_col = j;
					} else {
						start_row = i;
						start_col = j;
					}
				}
			}
		}
		searchForRocks();
		calculatePaths();
		fileWriter.println(pathLengths[finish_row][finish_col]);
	}

	public static void calculatePaths() {
		for (int i = start_row + 1; i < rows; i++) {
			if (pathLengths[i][start_col] != 0) {
				pathLengths[i][start_col] = 1;
			}
		}
		for (int i = start_col + 1; i < cols; i++) {
			if (pathLengths[start_row][i] != 0) {
				pathLengths[start_row][i] = 1;
			}
		}
		for (int i = start_row + 1; i < rows; i++) {
			for (int j = start_col + 1; j < cols; j++) {
				if (pathLengths[i][j] != 0) {
					pathLengths[i][j] = pathLengths[i][j - 1] + pathLengths[i - 1][j];
				}
			}
		}
		
	}

	public static void searchForRocks() {
		boolean check = false;
		for (int i = start_row + 1; i < rows; i++) {
			if (field[i][start_col] == 'R') {
				check = true;
			}
			if (check) {
				pathLengths[i][start_col] = 0;
			}
		}
		boolean check2 = false;
		for (int i = start_col + 1; i < cols; i++) {
			if (field[start_row][i] == 'R') {
				check2 = true;
			}
			if (check2) {
				pathLengths[start_row][i] = 0;
			}
		}
		for (int i = start_row + 1; i < rows; i++) {
			for (int j = start_col + 1; j < cols; j++) {
				if (field[i][j] == 'R') {
					pathLengths[i][j] = 0;
				}
			}
		}
	}
}

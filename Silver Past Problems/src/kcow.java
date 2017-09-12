import java.io.*;
import java.util.*;

public class kcow {

	static int shortestPath = 2147483647;
	static int numRows;
	static int numCols;
	static int finish_row;
	static int finish_col;
	static int start_row;
	static int start_col;
	static char[][] field;
	static int field2[][];
	static PrintStream fileWriter;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("kcow.in"));
		fileWriter = new PrintStream(new File("kcow.out"));
		numCols = fileReader.nextInt();
		numRows = fileReader.nextInt();
		field = new char[numRows][numCols];
		field2 = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			String temp = fileReader.next();
			for (int j = 0; j < numCols; j++) {
				field[i][j] = temp.charAt(j);
				if (field[i][j] == 'H') {
					finish_row = i;
					finish_col = j;
					field[i][j] = '.';
				}
				if (field[i][j] == 'K') {
					start_row = i;
					start_col = j;
				}
			}
		}
		floodfillBFS(start_row, start_col, 1);
	}

	public static void floodfillBFS(int row, int col, int index) {
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		Queue<Character> indexes = new LinkedList<Character>();
		while (true) {
			// check north east
			if (col < numCols - 1 && row > 1) {
				if (field[row - 2][col + 1] == '.') {
					field[row - 2][col + 1] = '-';
					field2[row - 2][col + 1] = index;
					x.add(col + 1);
					y.add(row - 2);
					indexes.add((char) index);
				}
			}
			// check east north
			if (col < numCols - 2 && row > 0) {
				if (field[row - 1][col + 2] == '.') {
					field[row - 1][col + 2] = '-';
					field2[row - 1][col + 2] = index;
					x.add(col + 2);
					y.add(row - 1);
					indexes.add((char) index);
				}
			}
			// check east south
			if (col < numCols - 2 && row < numRows - 1) {
				if (field[row + 1][col + 2] == '.') {
					field[row + 1][col + 2] = '-';
					field2[row + 1][col + 2] = index;
					x.add(col + 2);
					y.add(row + 1);
					indexes.add((char) index);
				}
			}
			// check south east
			if (col < numCols - 1 && row < numRows - 2) {
				if (field[row + 2][col + 1] == '.') {
					field[row + 2][col + 1] = '-';
					field2[row + 2][col + 1] = index;
					x.add(col + 1);
					y.add(row + 2);
					indexes.add((char) index);
				}
			}
			// check south west
			if (col > 0 && row < numRows - 2) {
				if (field[row + 2][col - 1] == '.') {
					field[row + 2][col - 1] = '-';
					field2[row + 2][col - 1] = index;
					x.add(col - 1);
					y.add(row + 2);
					indexes.add((char) index);
				}
			}
			// check west south
			if (col > 1 && row < numRows - 1) {
				if (field[row + 1][col - 2] == '.') {
					field[row + 1][col - 2] = '-';
					field2[row + 1][col - 2] = index;
					x.add(col - 2);
					y.add(row + 1);
					indexes.add((char) index);
				}
			}
			// check west north
			if (col > 1 && row > 0) {
				if (field[row - 1][col - 2] == '.') {
					field[row - 1][col - 2] = '-';
					field2[row - 1][col - 2] = index;
					x.add(col - 2);
					y.add(row - 1);
					indexes.add((char) index);
				}
			}
			// check north west
			if (col > 0 && row > 1) {
				if (field[row - 2][col - 1] == '.') {
					field[row - 2][col - 1] = '-';
					field2[row - 2][col - 1] = index;
					x.add(col - 1);
					y.add(row - 2);
					indexes.add((char) index);
				}
			}
			if (row == finish_row && col == finish_col) {
				fileWriter.println(field2[finish_row][finish_col]);
				System.exit(0);
			}
			row = y.peek();
			y.remove();
			col = x.peek();
			x.remove();
			index = indexes.peek() + 1;
			indexes.remove();
		}
	}
}
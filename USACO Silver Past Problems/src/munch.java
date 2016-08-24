import java.io.*;
import java.util.*;

public class munch {

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

		Scanner fileReader = new Scanner(new File("munch.in"));
		fileWriter = new PrintStream(new File("munch.out"));
		numRows = fileReader.nextInt();
		numCols = fileReader.nextInt();
		field = new char[numRows][numCols];
		String calibrate = fileReader.nextLine();
		field2 = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			String temp = fileReader.nextLine();
			for (int j = 0; j < numCols; j++) {
				field[i][j] = temp.charAt(j);
				if (field[i][j] == 'B') {
					finish_row = i;
					finish_col = j;
					field[i][j] = '.';
				}
				if (field[i][j] == 'C') {
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
			if (col > 0) {
				if (field[row][col - 1] == '.') {
					field[row][col - 1] = 'k';
					field2[row][col - 1] =  index;
					x.add(col - 1);
					y.add(row);
					indexes.add((char) index);
				}
			}
			// check right
			if (col < numCols - 1) {
				if (field[row][col + 1] == '.') {
					field[row][col + 1] = 'k';
					field2[row][col + 1] = index;
					x.add(col + 1);
					y.add(row);
					indexes.add((char) index);
				}
			}
			// check up
			if (row > 0) {
				if (field[row - 1][col] == '.') {
					field[row - 1][col] = 'k';
					field2[row - 1][col] = index;
					x.add(col);
					y.add(row - 1);
					indexes.add((char) index);
				}
			}
			// check down
			if (row < numRows - 1) {
				if (field[row + 1][col] == '.') {
					field[row + 1][col] = 'k';
					field2[row + 1][col] = index;
					x.add(col);
					y.add(row + 1);
					indexes.add((char) index);
				}
			}
			if (row == finish_row && col == finish_col) {
				fileWriter.println(field2[finish_row][finish_col]);
				return;
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
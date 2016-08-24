import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.*;

public class feedtime {

	static char[][] field;
	static int rows, cols;
	static PrintStream fileWriter;
	static int largestPastureSize = 0;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("feedtime.in"));
		fileWriter = new PrintStream(new File("feedtime.out"));

		cols = fileReader.nextInt();
		rows = fileReader.nextInt();
		field = new char[rows][cols];
		String calibrate = fileReader.nextLine();
		for (int i = 0; i < rows; i++) {
			String temp = fileReader.nextLine();
			for (int j = 0; j < cols; j++) {
				field[i][j] = temp.charAt(j);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (field[i][j] == '.') {
					floodfillBFS(i, j);
				}
			}
		}

		fileWriter.println(largestPastureSize);

	}

	public static void floodfillBFS(int row, int col) {
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		int pastureSize = 0;
		x.add(col);
		y.add(row);
		while (!x.isEmpty()) {
			row = y.peek();
			y.remove();
			col = x.peek();
			x.remove();
			// Check left
			if (col > 0) {
				if (field[row][col - 1] == '.') {
					field[row][col - 1] = 'f';
					pastureSize++;
					x.add(col - 1);
					y.add(row);
				}
			}
			// check right
			if (col < cols - 1) {
				if (field[row][col + 1] == '.') {
					field[row][col + 1] = 'f';
					pastureSize++;
					x.add(col + 1);
					y.add(row);
				}
			}
			// check up
			if (row > 0) {
				if (field[row - 1][col] == '.') {
					field[row - 1][col] = 'f';
					pastureSize++;
					x.add(col);
					y.add(row - 1);
				}
			}
			// check down
			if (row < rows - 1) {
				if (field[row + 1][col] == '.') {
					field[row + 1][col] = 'f';
					pastureSize++;
					x.add(col);
					y.add(row + 1);
				}
			}
			// check up and left
			if (row > 0 && col > 0) {
				if (field[row - 1][col - 1] == '.') {
					field[row - 1][col - 1] = 'f';
					pastureSize++;
					x.add(col - 1);
					y.add(row - 1);
				}
			}
			// check down and left
			if (row < rows - 1 && col > 0) {
				if (field[row + 1][col - 1] == '.') {
					field[row + 1][col - 1] = 'f';
					pastureSize++;
					x.add(col - 1);
					y.add(row + 1);
				}
			}
			// check up and right
			if (row > 0 && col < cols - 1) {
				if (field[row - 1][col + 1] == '.') {
					field[row - 1][col + 1] = 'f';
					pastureSize++;
					x.add(col + 1);
					y.add(row - 1);
				}
			}
			// check down and right
			if (row < rows - 1 && col < cols - 1) {
				if (field[row + 1][col + 1] == '.') {
					field[row + 1][col + 1] = 'f';
					pastureSize++;
					x.add(col + 1);
					y.add(row + 1);
				}
			}
		}
		if (pastureSize > largestPastureSize) {
			largestPastureSize = pastureSize;
		}

	}

}

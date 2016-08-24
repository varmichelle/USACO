import java.io.*;
import java.util.*;

public class maze {

	static char[][] maze;
	static int numRows;
	static int numCols;
	static String best = "teststringRRRRRDDDRRRURRUURRRDDRDDDRRRRUURRRUUURRRRRRDRRRRRRRRDRRDRRRRURURRRDDRRRRRUURRRRRU"
			+ "RRRDRRRRRDRDDDLDDDDDRRRDDDRDLLRLUDLDDDLDUUUURULUDLDDDDLDDLDDLLRLULUDLDUULDDLLRLUDLUURRUULDULUDLDLLRLDULDU"
			+ "LDULLRLDULLRLDLLRLLRLUUUURRUULDUUURUULLRLLRLDULDDDLDULUDLLRLDDLUURULLRLDUUUULDUUUURUULDULLRLDDDDDDDDLUUUUUL"
			+ "DDLLRLDUULDDDLDUULDDLUDLUDLLRLLRLUURULLRLLRLDDDLUDLUURULLRLDDLDUUULLRLDDDLDDDDLUDLDUULDDDDRRRRRRRRDRRRRRRRDR"
			+ "RRRDLDLDDLUULLRLDDDDLUDLULLRLUDLDLDLDULUDLUDLDDRDDDDRRDRDRRRRRUURRDRDRRUURRRRRRRRDDRRRRRURRRUUUURRRRRDRRRRDRR"
			+ "RDRDRRRRURRDRDRRRRURRRRDRRRRRRDDDRRRURRUURRRDDRDDDRRRRUURRRUUURRRRRRDRRRRRRRRDRRDRRRRURURRRDDRRRRRUURRRRRURRRD"
			+ "RRRRRDRDDDLDDDDDRRRDDDRDLLRLUDLDDDLDUUUURULUDLDDDDLDDLDDLLRLULUDLDUULDDLLRLUDLUURRUULDULUDLDLLRLDULDULDULLRLDUL"
			+ "LRLDLLRLLRLUUUURRUULDUUURUULLRLLRLDULDDDLDULUDLLRLDDLUURULLRLDUUUULDUUUURUULDULLRLDDDDDDDDLUUUUULDDLLRLDUULDDDLD"
			+ "UULDDLUDLUDLLRLLRLUURULLRLLRLDDDLUDLUURULLRLDDLDUUULLRLDDDLDDDDLUDLDUULDDDDRRRRRRRRDRRRRRRRDRRRRDLDLDDLUULLRLDDDD"
			+ "LUDLULLRLUDLDLDLDULUDLUDLDDRDDDDRRDRDRRRRRUURRDRDRRUURRRRRRRRDDRRRRRURRRUUUURRRRRDRRRRDRRRDRDRRRRURRDRDRRRRURRRRDR";

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("maze.in"));
		PrintStream fileWriter = new PrintStream(new File("maze.out"));
		numRows = fileReader.nextInt();
		numCols = fileReader.nextInt();

		String calibrate = fileReader.nextLine();
		maze = new char[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			String temp = fileReader.nextLine();
			for (int j = 0; j < numCols; j++) {
				maze[i][j] = temp.charAt(j);
			}
		}
		boolean[][] wentBefore = new boolean[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				wentBefore[i][j] = false;
			}
		}
		int row = 1;
		int col = 1;
		String currentPath = "";
		findMazePath(wentBefore, row, col, currentPath, fileWriter);
		//print the best
		fileWriter.println(best);

	}

	public static void findMazePath(boolean[][] wentBefore, int row, int col,
			String currentPath, PrintStream fileWriter) {
		if (row == 36 && col == 69) {
			//set current best
			if (currentPath.length() < best.length()) {
				best = currentPath;
			}
			return;
		}
		// System.out.println("Row: " + row);
		// System.out.println("Col: " + col);
		// System.out.println(currentPath);
		// System.out.println();
		if (col < numCols - 2) {
			if ((maze[row][col + 1] != '#') && !wentBefore[row][col + 1]) {
				// Move right
				wentBefore[row][col + 1] = true;
				findMazePath(wentBefore, row, col + 1, currentPath + "R",
						fileWriter);
			}
		}
		if (row < numRows - 2) {
			if ((maze[row + 1][col] != '#')
					&& !wentBefore[row + 1][col]) {
				// Move down
				wentBefore[row + 1][col] = true;
				findMazePath(wentBefore, row + 1, col, currentPath + "D",
						fileWriter);
			}
		}
		if (row > 1) {
			if ((maze[row - 1][col] != '#') && !wentBefore[row - 1][col]) {
				// Move up
				wentBefore[row - 1][col] = true;
				findMazePath(wentBefore, row - 1, col, currentPath + "U",
						fileWriter);
			}
		}
		if (col > 1) {
			if ((maze[row][col - 1] != '#') && !wentBefore[row][col - 1]) {
				// Move left
				wentBefore[row - 1][col] = true;
				findMazePath(wentBefore, row, col - 1, currentPath + "L",
						fileWriter);
			}
		}
	}

}

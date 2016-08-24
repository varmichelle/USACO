/*
ID: michell26
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle {

	static int cols, rows, room = 0, bestSum = 0;
	static int[][] walls, castle;
	static int[] modulesPerRoom;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("castle.in"));
		PrintStream out = new PrintStream(new File("castle.out"));

		cols = in.nextInt();
		rows = in.nextInt();
		String wallRemove = "";
		
		walls = new int[cols][rows];
		castle = new int[cols][rows];
		// modulesPerRoom[i] stores the number of modules that room i has
		modulesPerRoom = new int[rows * cols + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				walls[j][i] = in.nextInt();
			}
		}

		// floodfill with dfs
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (castle[j][i] == 0) {
					room++;
					floodfill(j, i, room);
				}
			}
		}
		// check for largest room after removing wall
		for (int j = 0; j <= cols - 1; j++) {
			for (int i = rows - 1; i >= 0; i--) {
				// check up
				if (i > 0 && castle[j][i] != castle[j][i-1]) {
					if (modulesPerRoom[castle[j][i]] + modulesPerRoom[castle[j][i-1]] > bestSum) {
						bestSum = modulesPerRoom[castle[j][i]] + modulesPerRoom[castle[j][i-1]];
						wallRemove = (i+1) + " " + (j+1) + " N";
					}
				}
				// check right
				if (j < cols - 1 && castle[j][i] != castle[j+1][i]) {
					if (modulesPerRoom[castle[j][i]] + modulesPerRoom[castle[j+1][i]] > bestSum) {
						bestSum = modulesPerRoom[castle[j][i]] + modulesPerRoom[castle[j+1][i]];
						wallRemove = (i+1) + " " + (j+1) + " E";
					}
				}
			}
		}
		Arrays.sort(modulesPerRoom, 1, room + 1);
		out.println(room);
		out.println(modulesPerRoom[room]);
		out.println(bestSum);
		out.println(wallRemove);

	}

	public static void floodfill(int col, int row, int fill) {
		modulesPerRoom[fill]++;
		castle[col][row] = fill;
		String wall = String.format("%4s", Integer.toBinaryString(walls[col][row])).replace(" ", "0");
		// check down
		if (row < rows - 1 && castle[col][row+1] == 0 && wall.charAt(0) == '0') floodfill(col, row + 1, fill);
		// check right
		if (col < cols - 1 && castle[col+1][row] == 0 && wall.charAt(1) == '0') floodfill(col + 1, row, fill);
		// check up
		if (row > 0 && castle[col][row-1] == 0 && wall.charAt(2) == '0') floodfill(col, row - 1, fill);
		// check left
		if (col > 0 && castle[col-1][row] == 0 && wall.charAt(3) == '0') floodfill(col - 1, row, fill);
	}

}

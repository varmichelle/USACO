import java.util.*;
import java.io.*;

public class fliptile {
	
	static int rows, cols;
	static int[][] grid, copy, flips;
	
	public static void main(String[] args) throws FileNotFoundException {

		/**
		 * General solution: Try all possible values for flips of the first row
		 * Based on what tiles still need to be flipped in the first row, 
		 * the appropriate flips for the second row can be determined
		 * (repeat for the other rows)
		 * Realize that only either 0 or 1 flip is needed (2 is the same as 0)
		 */
		
		// read input
		Scanner in = new Scanner(new File("fliptile.in.txt"));
		PrintStream out = new PrintStream(new File("fliptile.out.txt"));
		rows = in.nextInt();
		cols = in.nextInt();
		grid = new int[cols][rows];
		copy = new int[cols][rows];
		flips = new int[cols][rows];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				grid[x][y] = in.nextInt();
				copy[x][y] = grid[x][y];
				flips[x][y] = 0;
			}
		}
		
		// generate all possible flip combinations for the first row
		for (int num = 0; num < Math.pow(2, cols); num++) {
			String map = "000000000000000" + Integer.toBinaryString(num);
			// generate the flips for the first row
			map = map.substring(map.length() - cols, map.length());
			for (int i = 0; i < cols; i++) {
				if (map.charAt(i) == '1') flip(i,0);
			}
			// check the other rows
			for (int j = 1; j < rows; j++) {
				for (int i = 0; i < cols; i++) {
					if (grid[i][j - 1] == '1') flip(i, j);
				}
			}
			// check if the solution works
			boolean works = true;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[j][i] == 1) works = false;
				}
			}
			// if it does, print the results
			if (works) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						System.out.print(flips[j][i]);
						if (j < cols - 1) System.out.print(" ");
					}
					System.out.println();
				}
			}
			reset();
		}
	}

	// execute a flip (flip the tile itself + 4 adjacent tiles)
	public static void flip(int x, int y) {
		int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
		copy[x][y] = 1 - copy[x][y];
		flips[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			if (x + dir[i][0] >= 0 && x + dir[i][0] < cols) {
				if (y + dir[i][1] >= 0 && y + dir[i][1] < rows) {
					copy[x][y] = 1 - copy[x][y];
				}
			}
		}
	}
	
	public static void reset() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				copy[j][i] = grid[j][i];
				flips[j][i] = 0;
			}
		}
	}

}

import java.util.*;
import java.io.*;

public class fliptile {
	
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
		int rows = in.nextInt();
		int cols = in.nextInt();
		int[][] grid = new int[cols][rows];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				grid[x][y] = in.nextInt();
			}
		}
		
		// generate all possible flip combinations for the first row
		for (int num = 0; num < Math.pow(2, cols); num++) {
			
		}
	}

}

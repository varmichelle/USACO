import java.io.*;
import java.util.*;

public class fliptile2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File("fliptile.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("fliptile.out.txt"));
		
		int n_row = fileReader.nextInt();
		int n_col = fileReader.nextInt();
		int[][] grid = new int[n_row][n_col];
		int[][] gridTemp = new int[n_row][n_col];
		int[][] flipped = new int[n_row][n_col];
		for (int row = 0; row < n_row; row++) {
			for (int col = 0; col < n_col; col++) {
				if (fileReader.nextInt() == 1) grid[row][col] = 1;
				else grid[row][col] = -1;
				gridTemp[row][col] = grid[row][col];
			}
		}
		
		String key = "";
		for (int combo = 0; combo < Math.pow(2, n_col); combo++) {
			for (int numZeroes = 0; numZeroes < n_col - Integer.toBinaryString(combo).length(); numZeroes++) {
				key += "0";
			}
			key += Integer.toBinaryString(combo);
			for (int digit = 0; digit < n_col; digit++) {
				if (key.charAt(digit) == '1') {
					flipped[0][digit] = 1;
					gridTemp[0][digit] *= -1;
					if (n_row > 1) gridTemp[1][digit] *= -1;
					if (digit > 0) gridTemp[0][digit - 1] *= -1;
					if (digit < n_col - 1) gridTemp[0][digit + 1] *= -1;
				}
			}			
			for (int row = 1; row < n_row; row++) {
				for (int digit = 0; digit < n_col; digit++) {
					if (gridTemp[row - 1][digit] == 1) {
						flipped[row][digit] = 1;
						gridTemp[row - 1][digit] *= -1;
						gridTemp[row][digit] *= -1;
						if (row < n_row - 1) gridTemp[row + 1][digit] *= -1;
						if (digit > 0) gridTemp[row][digit - 1] *= -1;
						if (digit < n_col - 1) gridTemp[row][digit + 1] *= -1;
					}
				}
			}
			boolean works = true;
			for (int col = 0; col < n_col; col++) {
				if (gridTemp[n_row - 1][col] == 1) {
					works = false;
					break;
				}
			}
			if (works) {
				for (int row = 0; row < n_row; row++) {
					for (int col = 0; col < n_col; col++) {
						System.out.print(flipped[row][col]);
					}
					System.out.println();
				}
				System.exit(0);
			} else {
				for (int row = 0; row < n_row; row++) {
					for (int col = 0; col < n_col; col++) {
						flipped[row][col] = 0;
						gridTemp[row][col] = grid[row][col];
					}
				}
			}
			key = "";
		}
		System.out.println("IMPOSSIBLE");
	}
}

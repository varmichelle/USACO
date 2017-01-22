import java.util.*;
import java.io.*;

public class pie1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("pie1.in.txt"));
		PrintStream out = new PrintStream(new File("pie1.out.txt"));
		
		int R = in.nextInt();
		int C = in.nextInt();
		int[][] grid = new int[R+2][C+1];
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				grid[r][c] = in.nextInt();
				if (r > c) grid[r][c] = 0;
			}
		}
		
		for (int c = 1; c <= C; c++) {
			for (int r = 1; r <= R; r++) {
				grid[r][c] += Math.max(Math.max(grid[r-1][c-1], grid[r][c-1]), grid[r+1][c-1]);
			}
		}
				
		System.out.println(grid[R][C]);		
		
	}

}

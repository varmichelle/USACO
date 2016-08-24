
import java.util.*;
import java.io.*;

public class stroll {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("stroll.in.txt"));
		PrintStream out = new PrintStream(new File("stroll.out.txt"));
		
		int R = in.nextInt();
		int C = in.nextInt();
		int[][] grid = new int[C + 2][R + 2];
		int  s_x = 0, s_y = 0, e_x = 0, e_y = 0;
		boolean found = false;
		String calibrate = in.nextLine();
		for (int i = 0; i < R; i++) {
			String temp = in.nextLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(2 * j) == 'B') {
					if (found) {
						e_x = j + 1;
						e_y = i + 1;
						// mark the finish spot as -2
						grid[e_x][e_y] = -2;
					} else {
						s_x = j + 1;
						s_y = i + 1;
						// mark the starting spot with 1
						grid[s_x][s_y] = 1;
						found = true;
					}
				} 
				else if (temp.charAt(2 * j) ==  'R') grid[j + 1][i + 1] = 0;
				else grid[j + 1][i + 1] = -1;
			}
		}
		
		// since Bessie can only move down or right, the number of paths 
		// to a certain cell is the sum of the number of paths to the cells up and to the left
		for (int y = s_y; y <= e_y; y++) {
			for (int x = s_x; x <= e_x; x++) {
				if (grid[x][y] == -1) grid[x][y] = grid[x - 1][y] + grid[x][y - 1];
				if (grid[x][y] == -2) out.println(grid[x][y - 1] + grid[x - 1][y]);
			}
		}
		
	}
	
}
	
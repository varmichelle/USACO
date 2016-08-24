
import java.util.*;
import java.io.*;

public class hopscotch {
	
	static int paths = 0, R, C;
	static int[][] grid;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hopscotch.in.txt"));
		PrintStream out = new PrintStream(new File("hopscotch.out.txt"));
		
		R = in.nextInt();
		C = in.nextInt();
		grid = new int[C][R];
		String calibrate = in.nextLine();
		for (int i = 0; i < R; i++) {
			String temp = in.nextLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(j) == 'R') grid[j][i] = -1;
				else grid[j][i] = 1;
			}
		}
		dfs(0, 0);
		out.println(paths);
	}

	public static void dfs(int x, int y) {
		if (x == C - 1 && y == R - 1) paths++;
		for (int i = y + 1; i < R; i++) {
			for (int j = x + 1; j < C; j++) {
				if (grid[j][i] == -1 * grid[x][y]) dfs(j, i);
			}
		}
	}

}

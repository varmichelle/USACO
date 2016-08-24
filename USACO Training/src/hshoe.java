
import java.util.*;
import java.io.*;

public class hshoe {
	
	static char[][] grid;
	static int N;
	static PrintStream out;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hshoe.in.txt"));
		out = new PrintStream(new File("hshoe.out.txt"));
		
		N = in.nextInt();
		grid = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = in.next();
			for (int j = 0; j < N; j++) {
				grid[j][i] = temp.charAt(j);
			}
		}
		
		// iterate through all possible lengths from greatest to least, stopping when a solution is found
		for (int i = (N*N + 1)/2 * 2; i >= 0; i-=2) {
			dfs(0, 0, 1, i);
		}
	}

	static void dfs(int x, int y, int index, int length) {
		// if a string of length equal to the required length exits, print that length and finish
		if (index == length) {
			out.println(length);
			System.exit(0);
		} else {
			// mark the current spot as visited
			grid[x][y] = '.';
			// for each direction (up, down, left, right), DFS
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
					if (index + 1 <= length/2 && grid[x + dx[i]][y + dy[i]] == '(') {
						dfs(x + dx[i], y + dy[i], index + 1, length);
						// remark the spot as unvisited
						grid[x + dx[i]][y + dy[i]] = '(';
					} else if (index + 1 > length/2 && grid[x + dx[i]][y + dy[i]] == ')') {
						dfs(x + dx[i], y + dy[i], index + 1, length);
						// remark the spot as unvisited
						grid[x + dx[i]][y + dy[i]] = ')';
					}
				}
			}
		}
	}
}

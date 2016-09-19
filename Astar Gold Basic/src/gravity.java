import java.util.*;
import java.io.*;

public class gravity {
	
	static Struct start, end;
	static int N, M;
	static char[][] grid;
	static int[][] flips;
	static Queue<Struct> q = new LinkedList<Struct>();

	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * General Solution Idea:
		 * BFS implementing DFS to find all reachable points with the same flip
		 */
	
		Scanner in = new Scanner(new File("gravity.in.txt"));
		PrintStream out = new PrintStream(new File("gravity.out.txt"));
		
		// read input
		N = in.nextInt();
		M = in.nextInt();
		grid = new char[N][M];
		flips = new int[N][M];
		for (int i = 0; i < M; i++) {
			String str = in.next();
			for (int j = 0; j < N; j++) {
				grid[j][i] = str.charAt(j);
				if (grid[j][i] == 'C') {
					start = fall(new Struct(j, i), 1);
					q.add(start);
					flips[j][i] = 0;
				}
				else if (grid[j][i] == 'D') end = new Struct(j, i);			
				else if (grid[j][i] == '#') flips[j][i] = -1;
			}
		}
		while (!q.isEmpty()) {
			Struct current = q.remove();
			if (current.x == end.x && current.y == end.y) {
				System.out.println(flips[end.x][end.y]);
				System.exit(0);
			}
			if (current.x >= 0 && current.y >= 0) dfs(current, flips[current.x][current.y] + 1);
		}
		System.out.println(-1);

	}
	
	public static void dfs(Struct current, int flip) {
		current = fall(current, dir(current));
		if (current.x != -1 && current.y != -1) {
			// left
			if (current.x > 0 && grid[current.x - 1][current.y] != '#') {
				q.add(new Struct(current.x - 1, current.y));
				flips[current.x - 1][current.y] = flips[current.x][current.y];
			}
			// right
			if (current.x < M - 1 && grid[current.x + 1][current.y] != '#') {
				q.add(new Struct(current.x + 1, current.y));
				flips[current.x + 1][current.y] = flips[current.x][current.y];
			}
			// flip
			q.add(fall(current, -dir(current)));
			
		}
	}
	
	public static int dir(Struct s) {
		if (flips[s.x][s.y] % 2 == 0) return 1;
		return 0;
	}
	
	public static Struct fall(Struct s, int dir) {
		for (;;s.y += dir) {
			if (s.x == end.x && s.y == end.y) break;
			if (s.x == N || s.y == M) return new Struct(-1,-1);
			if (grid[s.x][s.y] == '#') break;
		}
		return s;
	}

}

class Struct {
	int x, y;
	Struct(int a, int b) {
		x = a;
		y = b;
	}
}

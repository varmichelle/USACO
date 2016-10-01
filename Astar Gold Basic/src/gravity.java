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
		 * This makes sure we don't revisit points unnecessarily
		 * (i.e. keep going left/right between two points)
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
					dfs(fall(start, dir(start)), 0);
				}
				else if (grid[j][i] == 'D') end = new Struct(j, i);			
			}
		}
		while (!q.isEmpty()) {
			Struct current = q.remove();
			// if reached endpoint, print the number of flips it took
			if (current.x == end.x && current.y == end.y) {
				System.out.println(flips[end.x][end.y]);
				System.exit(0);
			}
			// otherwise, if in bounds, dfs on the current position
			if (current.x >= 0 && current.y >= 0) dfs(current, flips[current.x][current.y] + 1);
		}
		System.out.println(-1);

	}
	
	// dfs and push all points reachable with the same flip to the queue
	public static void dfs(Struct current, int flip) {
		current = fall(current, dir(flip));
		if (current.x != -1 && current.y != -1) {
			// left
			if (current.x > 0 && grid[current.x - 1][current.y] != '#') {
				q.add(new Struct(current.x - 1, current.y));
				flips[current.x - 1][current.y] = flips[current.x][current.y];
				Struct newStruct = new Struct(current.x - 1, current.y);
				dfs(newStruct, flip);
			}
			// right
			if (current.x < M - 1 && grid[current.x + 1][current.y] != '#') {
				q.add(new Struct(current.x + 1, current.y));
				flips[current.x + 1][current.y] = flips[current.x][current.y];
				Struct newStruct = new Struct(current.x + 1, current.y);
				dfs(newStruct, flip);
			}
		}
	}
	
	// return the direction of gravity (1 for down, -1 for up)
	public static int dir(Struct s) {
		if (flips[s.x][s.y] % 2 == 0) return 1;
		return -1;
	}
	
	public static int dir(int flips) {
		if (flips % 2 == 0) return 1;
		return -1;
	}
	
	// return the point the captain falls to due to gravity (-1,-1) if off the grid
	public static Struct fall(Struct s, int dir) {
		for (;;s.y += dir) {
			if (s.x == end.x && s.y == end.y) break;
			if (s.x == N || s.y == M) return new Struct(-1,-1);
			System.out.println(grid[s.x][s.y]);
			if (grid[s.x][s.y] != '.') {
				s.y -= dir;
				break;
			}
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

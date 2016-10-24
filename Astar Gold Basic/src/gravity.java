import java.util.*;
import java.io.*;

public class gravity {
	
	static Struct start, end;
	static int N, M;
	static char[][] grid;
	static int[][] flips;
	static Queue<Struct> q = new LinkedList<Struct>();

	public static void main(String[] args) throws FileNotFoundException {
	
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
					start = new Struct(j, i);
				}
				else if (grid[j][i] == 'D') end = new Struct(j, i);			
			}
		}
		start = fall(start,1);
		add(start, 0);
		while (!q.isEmpty()) {
			Struct current = q.remove();
			System.out.println("current: " + current.x + " " + current.y);
			// if reached endpoint, print the number of flips it took
			if (current.x == end.x && current.y == end.y) {
				System.out.println(flips[end.x][end.y]);
				System.exit(0);
			}
			// otherwise, if in bounds, flip gravity
			Struct p = fall(current, dir(current));
			if (p.x != -1 && p.y != -1) {
				// add all reachable points from the current node
				add(p, flips[p.x][p.y] + 1);
			}
		}
		System.out.println(-1);

	}
	
	// push all reachable nodes with the same flip
	public static void add(Struct current, int flip) {
		current = fall(current, dir(current));
		if (current.x != -1 && current.y != -1) {
			// left
			for (int x = current.x - 1; x >= 0; x--) {
				Struct i = fall(new Struct(x, current.y), dir(current));
				if (i.x != -1 && i.y != -1) {
					if (grid[i.x][i.y] != '#') {
						q.add(i);
						flips[i.x][i.y] = flips[i.x + 1][i.y];
					} else break;
				} else break;
			}
			// right
			for (int x = current.x + 1; x < N; x++) {
				Struct i = fall(new Struct(x, current.y), dir(current));
				if (i.x != -1 && i.y != -1) {
					if (grid[i.x][i.y] != '#') {
						q.add(i);
						flips[i.x][i.y] = flips[i.x - 1][i.y];
					} else break;
				} else break;
			}
			// add the original point
			flips[current.x][current.y] += 1;
			Struct fell = fall(current, dir(current));
			if (fell.x != -1 && fell.y != -1) q.add(fell);
		}
	}
	
	// return the direction of gravity (1 for down, -1 for up)
	public static int dir(Struct s) {
		if (flips[s.x][s.y] % 2 == 0) return 1;
		else return -1;
	}
	
	// return the point the captain falls to due to gravity (-1,-1) if off the grid
	public static Struct fall(Struct s, int dir) {
		while (true) {
			s.y += dir;
			if (s.x == end.x && s.y == end.y) break;
			if (s.x == N || s.y == M || s.x == -1 || s.y == -1) return new Struct(-1,-1);
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

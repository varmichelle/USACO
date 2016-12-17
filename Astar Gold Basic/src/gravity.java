import java.util.*;
import java.io.*;

public class gravity {
	
	static int N, M;
	static char[][] field;
	static boolean[][] v1, v2;
	static Queue<Cell> q;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers
		Scanner in = new Scanner(new File("gravity.in.txt"));
		PrintStream out = new PrintStream(new File("gravity.out.txt"));
		
		// read in input
		M = in.nextInt();
		N = in.nextInt();
		// positions of captain and doctor
		int cx = 0, cy = 0, dx = 0, dy = 0;
		field = new char[N][M];
		v1 = new boolean[N][M];
		v2 = new boolean[N][M];
		for (int y = 0; y < M; y++) {
			String line = in.next();
			for (int x = 0; x < N; x++) {
				field[x][y] = line.charAt(x);
				// check if captain or doctor
				if (field[x][y] == 'C') {
					cx = x;
					cy = y;
				} else if (field[x][y] == 'D') {
					dx = x;
					dy = y;
				}
			}
		}
		
		q = new LinkedList<Cell>();
		
		// add starting position
		Cell start = new Cell(cx, cy, 0, 1);
		Cell fell = fall(start);
		if (fell.x != -1 && fell.y != -1) {
			q.add(fell);
			v1[fell.x][fell.y] = true;
			// push all 0 flip reachable nodes
			push(new Cell(fell.x - 1, fell.y, fell.flips, fell.dir));
			push(new Cell(fell.x + 1, fell.y, fell.flips, fell.dir));
		}
		
		while (!q.isEmpty()) {
			Cell current = q.remove();
			// check if reached end
			if (current.x == dx && current.y == dy) {
				System.out.println(current.flips);
				System.exit(0);
			}
			// otherwise add next nodes with 1 more flip
			Cell next = fall(new Cell(current.x, current.y, current.flips + 1, current.dir * -1));
			// if not out of bounds, push all reachable cells
			if (next.x != -1 && next.y != -1) {
				if (next.dir == 1 && !v1[next.x][next.y]) {
					q.add(next);
					v1[next.x][next.y] = true;
					push(new Cell(next.x-1, next.y, next.flips, next.dir));
					push(new Cell(next.x+1, next.y, next.flips, next.dir));
				} else if (next.dir == -1 && !v2[next.x][next.y]) {
					q.add(next);
					v2[next.x][next.y] = true;
					push(new Cell(next.x-1, next.y, next.flips, next.dir));
					push(new Cell(next.x+1, next.y, next.flips, next.dir));
				}
			}
		}
		
		// print -1 if unreachable
		System.out.println(-1);
		
	}
	
	// returns the position after falling due to gravity ((-1,-1) if fail)
	public static Cell fall(Cell cell) {
		// if out of bounds, return (-1,-1)
		if (cell.x < 0 || cell.x >= N || cell.y < 0 || cell.y >= M) return new Cell(-1,-1,0,0);
		// if at edge and in direction of gravity, return (-1,-1)
		if (cell.y == 0 && cell.dir == -1) return new Cell(-1, -1, 0, 0);
		if (cell.y == M - 1 && cell.dir == 1) return new Cell(-1, -1, 0, 0);
		// try falling
		if (cell.y + cell.dir >= 0 && cell.y + cell.dir < M && field[cell.x][cell.y + cell.dir] != '#') {
			return fall(new Cell(cell.x, cell.y + cell.dir, cell.flips, cell.dir));
		}
		// otherwise the next space must be blocked, so return the original space
		return cell;		
	}
	
	// push all nodes with that flip using DFS
	public static void push(Cell cell) {
		Cell fell = fall(cell);
		// if legal
		if (fell.x != -1 && fell.y != -1) {
			if (fell.dir == 1 && !v1[fell.x][fell.y]) {
				v1[fell.x][fell.y] = true;
				q.add(fell);
				push(new Cell(fell.x-1, fell.y, fell.flips, fell.dir));
				push(new Cell(fell.x+1, fell.y, fell.flips, fell.dir));
			} else if (fell.dir == -1 && !v2[fell.x][fell.y]) {
				v2[fell.x][fell.y] = true;
				q.add(fell);
				push(new Cell(fell.x-1, fell.y, fell.flips, fell.dir));
				push(new Cell(fell.x+1, fell.y, fell.flips, fell.dir));
			}
		}
	}
		
}

class Cell {
	int x, y, flips, dir;
	public Cell(int x, int y, int flips, int dir) {
		this.x = x;
		this.y = y;
		this.flips = flips;
		this.dir = dir;
	}
}

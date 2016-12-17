import java.util.*;
import java.io.*;

public class gravity {
	
	static int N, M;
	static char[][] field;
	static Queue<Cell> q;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers
		Scanner in = new Scanner(new File("gravity.in.txt"));
		PrintStream out = new PrintStream(new File("gravity.out.txt"));
		
		// read in input
		N = in.nextInt();
		M = in.nextInt();
		// positions of captain and doctor
		int cx = 0, cy = 0, dx = 0, dy = 0;
		field = new char[N][M];
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
		q.add(fall(start));
		
		// push all 0 flip reachable nodes
		push(start);
		
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
			if (next.x != -1 && next.y != -1) push(next);
		}
		
	}
	
	// returns the position after falling due to gravity ((-1,-1) if fail)
	public static Cell fall(Cell cell) {
		// if at edge and in direction of gravity, return (-1,-1)
		if (cell.y == 0 && cell.dir == -1) return new Cell(-1, -1, 0, 0);
		if (cell.y == M - 1 && cell.dir == 1) return new Cell(-1, -1, 0, 0);
		// try falling
		if (field[cell.x][cell.y + cell.dir] != '#') {
			return fall(new Cell(cell.x, cell.y + cell.dir, cell.flips, cell.dir));
		}
		// otherwise the next space must be blocked, so return the original space
		return cell;		
	}
	
	// push all nodes with that flip
	public static void push(Cell cell) {
		// check left
		for (int x = cell.x - 1; x >= 0; x--) {
			// fall
			Cell fell = fall(new Cell(x, cell.y, cell.flips, cell.dir));
			// make sure the space is legal
			if (fell.x != -1 && fell.y != -1) q.add(fell);
			else break;
		}
		// check right
		for (int x = cell.x + 1; x < N; x++) {
			// fall
			Cell fell = fall(new Cell(x, cell.y, cell.flips, cell.dir));
			// make sure the space is legal
			if (fell.x != -1 && fell.y != -1) q.add(fell);
			else break;
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

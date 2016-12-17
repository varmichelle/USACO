import java.util.*;
import java.io.*;

public class gravity {
	
	static int N, M;
	static char[][] field;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers
		Scanner in = new Scanner(new File("gravity.in.txt"));
		PrintStream out = new PrintStream(new File("gravity.out.txt"));
		
		// read in input
		N = in.nextInt();
		M = in.nextInt();
		field = new char[N][M];
		for (int y = 0; y < M; y++) {
			String line = in.next();
			for (int x = 0; x < N; x++) {
				field[x][y] = line.charAt(x);
			}
		}
		
		// queue for BFS to store current position and # of flips
		Queue q = new LinkedList<Cell>();
		
		
	}
	
	// returns the position after falling due to gravity ((-1,-1) if fail)
	public Cell fall(Cell cell) {
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

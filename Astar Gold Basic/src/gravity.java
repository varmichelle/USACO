import java.util.*;
import java.io.*;

public class gravity {

	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * General Solution Idea:
		 * BFS implementing DFS to find all reachable points with the same flip
		 */
	
		Scanner in = new Scanner(new File("gravity.in.txt"));
		PrintStream out = new PrintStream(new File("gravity.out.txt"));
		
		// read input
		int N = in.nextInt();
		int M = in.nextInt();
		char[][] grid = new char[N][M];
		int[][] flips = new int[N][M];
		Struct start, end;
		for (int i = 0; i < M; i++) {
			String str = in.next();
			for (int j = 0; j < N; j++) {
				grid[j][i] = str.charAt(j);
				if (grid[j][i] == 'C') start = new Struct(j, i);
				else if (grid[j][i] == 'D') end = new Struct(j, i);			
				else if (grid[j][i] == '#') flips[j][i] = -1;
			}
		}
		Queue<Struct> q = new LinkedList<Struct>();
		while (!q.isEmpty()) {
			Struct current = q.remove();
			
		}

	}

}

class Struct {
	int x, y;
	Struct(int a, int b) {
		x = a;
		y = b;
	}
}

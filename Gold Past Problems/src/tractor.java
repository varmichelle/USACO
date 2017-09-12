import java.io.*;
import java.util.*;

public class tractor {
	
	static int hay;

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * General solution idea:
		 * BFS all possible moves (but don't revisit)
		 * Use a deque to make sure we're finding the best possible move
		 * i.e. push nodes that don't need to remove a hay bale first, and push nodes that do last
		 */
		
		Scanner fileReader = new Scanner(new File("tractor.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("tractor.out.txt"));
		
		// read input
		hay = fileReader.nextInt();
		int startX = fileReader.nextInt();
		int startY = fileReader.nextInt();
		int maxX = 0, maxY = 0;
		int field[][] = new int[1005][1005];
		for (int i = 0; i < hay; i++) {
			int x = fileReader.nextInt();
			int y = fileReader.nextInt();
			maxX = Math.max(x, maxX);
			maxY = Math.max(y, maxY);
			field[x][y] = -1;
		}
		maxX+=3;
		maxY+=3;
		
		// store the four directions (up, down, left, right)
		int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
		// dq stores the current position of FJ
		Deque<Position> dq = new LinkedList<Position>();
		// push the starting node into the dq
		dq.addFirst(new Position(startX, startY, 0));
		while (!dq.isEmpty()) {
			// grab the current position
			Position current = dq.removeFirst();
			// if we're at the origin (termination node), print results and finish
			if (current.x == 0 && current.y == 0) {
				System.out.println(current.hay);
				System.exit(0);
			}
			// if we're not yet finished, push possible nodes
			// check each of the 4 directions (up, down, left, right)
			for (int i = 0; i < 4; i++) {
				Position pos = new Position(current.x + dir[i][0], current.y + dir[i][1], current.hay);
				// if no hay bale, add first
				if (pos.x >= 0 && pos.y >= 0 && pos.x < maxX && pos.y < maxY && field[pos.x][pos.y] == 0) {
					dq.addFirst(pos);
					field[pos.x][pos.y] = 1;
				// if hay bale, add last
				} else if (pos.x >= 0 && pos.y >= 0 && pos.x < maxX && pos.y < maxY && field[pos.x][pos.y] == -1) {
					pos.hay += 1;
					dq.addLast(pos);
					field[pos.x][pos.y] = 1;
				}
			}
			
		}

	}
	
}

// used to store the current position (x, y, and # hay bales needed to get there)
class Position {
	int x, y, hay;
	Position(int newX, int newY, int newHay) {
		x = newX;
		y = newY;
		hay = newHay;
	}
}
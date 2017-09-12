import java.io.*;
import java.util.*;

public class lasers {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * General solution idea:
		 * Use floodfill starting from the starting location of the cow
		 * For each of the positions traversable from the previous position, floodfill on that with 1 more mirror
		 */
		
		Scanner in = new Scanner(new File("lasers.in.txt"));
		PrintStream out = new PrintStream(new File("lasers.out.txt"));
		
		// W = width, H = height
		int W = in.nextInt();
		int H = in.nextInt();
		// stores the pasture with 'C' = positions of cow, '.' = traversable spaces, '*' = blocked spaces
		char[][] pasture = new char[W][H];
		boolean visited[][] = new boolean[W][H];
		int floodfill[][] = new int[W][H];
		String calibrate = in.nextLine();
		int startX = 0, startY = 0;
		// read input
		for (int i = 0; i < H; i++) {
			String line = in.nextLine();
			for (int j = 0; j < W; j++) {
				pasture[j][i] = line.charAt(j);
				floodfill[j][i] = 999999999;
				// grab start positions
				if (pasture[j][i] == 'C') {
					startX = j;
					startY = i;
				}
			}
		}
		// q stores position and number of mirrors to get to that position
		Queue<Point> q = new LinkedList<Point>();
		// push the starting position into the queue
		Point start = new Point(startX, startY, 0);
		q.add(start);
		visited[start.x][start.y] = true;
		floodfill[start.x][start.y] = 0;
		while (!q.isEmpty()) {
			Point current = q.remove();
			// check if the current position is the termination node
			if (!visited[current.x][current.y] && pasture[current.x][current.y] == 'C') {
				System.out.println(current.mirrors - 1);
			}
			visited[current.x][current.y] = true;
			// floodfill in all four directions (update floodfill and push node to queue as needed)
			// up
			for (int y = current.y - 1; y >= 0; y--) {
				if (pasture[current.x][y] != '*' && !visited[current.x][y]) {
					floodfill[current.x][y] = Math.min(floodfill[current.x][y], current.mirrors);
					q.add(new Point(current.x, y, current.mirrors + 1));
				} else break;
			}
			// down
			for (int y = current.y + 1; y < H; y++) {
				if (pasture[current.x][y] != '*' && !visited[current.x][y]) {
					floodfill[current.x][y] = Math.min(floodfill[current.x][y], current.mirrors);
					q.add(new Point(current.x, y, current.mirrors + 1));
				} else break;
			}
			// left
			for (int x = current.x - 1; x >= 0; x--) {
				if (pasture[x][current.y] != '*' && !visited[x][current.y]) {
					floodfill[x][current.y] = Math.min(floodfill[x][current.y], current.mirrors);
					q.add(new Point(x, current.y, current.mirrors + 1));
				} else break;
			}
			// right
			for (int x = current.x + 1; x < W; x++) {
				if (pasture[x][current.y] != '*' && !visited[x][current.y]) {
					floodfill[x][current.y] = Math.min(floodfill[x][current.y], current.mirrors);
					q.add(new Point(x, current.y, current.mirrors + 1));
				} else break;
			}
		}
		
	}
}

// helper class to allow us to store the position of the cow as well as the # mirrors needed to get there
class Point {
	int x, y, mirrors = 0;
	Point(int startX, int startY, int startMirrors) {
		x = startX;
		y = startY;
		mirrors = startMirrors;
	}
}
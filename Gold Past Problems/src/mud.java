import java.util.*;
import java.io.*;

public class mud {

	public static void main(String[] args) throws FileNotFoundException {
		
		// read input
		Scanner in = new Scanner(new File("mud.in.txt"));
		PrintStream out = new PrintStream(new File("mud.out.txt"));
		
		int X = in.nextInt() + 510;
		int Y = in.nextInt() + 510;
		int N = in.nextInt();
		
		int[][] grid = new int[1020][1020]; // x, y coordinates + 510 each
		for (int i = 0; i < N; i++) {
			grid[in.nextInt() + 510][in.nextInt() + 510] = -1;
		}
		boolean[][] visited = new boolean[1020][1020];
		Queue<Puddle> q = new LinkedList<Puddle>();
		q.add(new Puddle(510,510,0));
		while (!q.isEmpty()) {
			Puddle current = q.remove();
			// check if reached Bessie
			if (current.x == X && current.y == Y) {
				System.out.println(current.distance);
				System.exit(0);
			}
			visited[current.x][current.y] = true;
			int[] dir = {-1,0,1};
			// check all 4 directions
			for (int i : dir) {
				for (int j : dir) {
					if (i != 0 && j != 0) continue;
					if (current.x + i >= 0 && current.x + i < 1020) {
						if (current.y + j >= 0 && current.y + j < 1020) {
							if (!visited[current.x + i][current.y + j] && grid[current.x + i][current.y + j] != -1) {
								visited[current.x + i][current.y + j] = true;
								q.add(new Puddle(current.x + i, current.y + j, current.distance + 1));								
							}
						}
					}
				}
			}
		}

	}

}

class Puddle {
	int x, y, distance;
	public Puddle(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
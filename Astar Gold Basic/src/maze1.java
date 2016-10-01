import java.util.*;
import java.io.*;

public class maze1 {

	public static void main(String[] args) throws FileNotFoundException {

		/**
		 * General solution idea: Flood-fill from both exits with the distance
		 * from the closer exit
		 */

		Scanner in = new Scanner(new File("maze1.in.txt"));
		PrintStream out = new PrintStream(new File("maze1.out.txt"));
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		// read input
		int W = in.nextInt();
		int H = in.nextInt();
		int[][] dist = new int[W][H];
		// create the queue to store the current position and distance to get there
		Queue<Triple> q = new LinkedList<Triple>();
		char[][] maze = new char[2 * W + 1][2 * H + 1];
		in.nextLine();
		for (int i = 0; i < 2 * H + 1; i++) {
			String line = in.nextLine();
			for (int j = 0; j < 2 * W + 1; j++) {
				maze[j][i] = line.charAt(j);
			}
		}
		// Find the exits
		for (int i = 1; i < W * 2 + 1; i += 2) {
			if (maze[i][0] == ' ') q.add(new Triple((i - 1) / 2, 0, 1));
			if (maze[i][H * 2] == ' ') q.add(new Triple((i-1)/2, H-1, 1));
		}
		for (int i = 1; i < H * 2; i += 2) {
			if (maze[0][i] == ' ') q.add(new Triple(0, (i-1)/2, 1));
			if (maze[W * 2][i] == ' ') q.add(new Triple(W - 1, (i-1)/2, 1));
		}
		int numFilled = 0;
		while (!q.isEmpty()) {
			Triple current = q.remove();
			// fill the array
			if (dist[current.x][current.y] == 0) {
				dist[current.x][current.y] = current.d;
				numFilled++;
				if (numFilled == W * H) {
					System.out.println(current.d);
					System.exit(0);
				}
				// check all 4 directions (left, right, up, down)
				for (int i = 0; i < 4; i++) {
					// if in bounds
					if ((current.x + dir[i][0]) >= 0 && (current.x + dir[i][0]) < W) {
						if ((current.y + dir[i][1]) >= 0 && (current.y + dir[i][1]) < H) {
							// if there's no wall and not visited
							if (maze[current.x * 2 + 1 + dir[i][0]][current.y * 2 + 1 + dir[i][1]] == ' ') {
								// push the node
								q.add(new Triple(current.x + dir[i][0], current.y + dir[i][1], current.d + 1));
							}
						}
					}
				}
			}
		}
	}

}

class Triple {
	int x, y, d;

	Triple(int a, int b, int c) {
		x = a;
		y = b;
		d = c;
	}
}

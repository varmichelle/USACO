import java.util.*;
import java.io.*;

public class maze1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		/** 
		 * General solution idea:
		 * Flood-fill from both exits with the distance from the closer exit
		 */
		
		Scanner in = new Scanner(new File("maze1.in.txt"));
		PrintStream out = new PrintStream(new File("maze1.out.txt"));
		int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
		// read input
		int W = in.nextInt();
		int H = in.nextInt();
		int k = 0;
		int[][] dist = new int[W][H];
		// create the queue to store the current position and distance to get there
		Queue<Triple> q = new LinkedList<Triple>();
		Triple[] exits = new Triple[2];
		char[][] maze = new char[2*W + 1][2*H + 1];
		String calibrate = in.nextLine();
		for (int i = 0; i < 2*H + 1; i++) {
			String line = in.nextLine();
			for (int j = 0; j < 2*W + 1; j++) {
				maze[j][i] = line.charAt(j);
				// check top for exits
				if (i == 0 && maze[j][i] == ' ') {
					exits[k] = new Triple((j-1)/2, 0, 1);
					dist[(j-1)/2][0] = 1;
					q.add(exits[k++]);
				}
				// check bottom for exits
				if (i == 2*H && maze[j][i] == ' ') {
					exits[k] = new Triple((j-1)/2, H-1, 1);
					dist[(j-1)/2][H-1] = 1;
					q.add(exits[k++]);
				}
				// check left for exits
				if (j == 0 && maze[j][i] == ' ') {
					exits[k] = new Triple(0, (i-1)/2, 1);
					dist[0][(i-1)/2] = 1;
					q.add(exits[k++]);
				}
				// check right for exits
				if (j == 2*W && maze[j][i] == ' ') {
					exits[k] = new Triple(W-1, (i-1)/2, 1);
					dist[W-1][(i-1)/2] = 1;
					q.add(exits[k++]);
				}
			}
		}
		int numFilled = 0;
		while (!q.isEmpty()) {
			Triple current = q.remove();
			// fill the array
			if (dist[current.x][current.y] == 0) {
				dist[current.x][current.y] = current.d;
				numFilled++;
				if (numFilled == W * H) break;
			}
			// check up down left right
			for (int i = 0; i < 4; i++) {
				// if in bounds
				if ((current.x + dir[i][0]) >= 0 && (current.x + dir[i][0]) < W) {
					if ((current.y + dir[i][1]) >= 0 && (current.y + dir[i][1]) < H) {
						// if there's no wall
						if (maze[current.x * 2 + dir[i][0]][current.y * 2 + dir[i][1]] == ' ') {
							// push the node
							q.add(new Triple(current.x + dir[i][0], current.y + dir[i][1], current.d + 1));
						}
					}
				}
			}
		}

		int worst = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				worst = Math.max(worst, dist[j][i]);
			}
		}
		System.out.println(worst);
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

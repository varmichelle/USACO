import java.util.*;
import java.io.*;

public class wall {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * General solution idea:
		 * Brute force BFS 
		 * Optimize by only checking nodes within 1000 
		 */
		
		Scanner in = new Scanner(new File("wall.in.txt"));
		PrintStream out = new PrintStream(new File("wall.out.txt"));
		
		// read input
		int H = in.nextInt();
		int F = in.nextInt();
		int[][] footholds = new int[F][2];
		int[] dist = new int[F];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < F; i++) {
			footholds[i][0] = in.nextInt();
			footholds[i][1] = in.nextInt();
			dist[i] = 99999999;
			// push all legal starting positions into the queue
			if (footholds[i][1] <= 1000) {
				dist[i] = 1;
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			// grab the index of the current foothold
			int current = q.remove();
			// if the current position is within 1000 mm of the top
			if (H - footholds[current][1] <= 1000) {
				System.out.println(dist[current]);
				System.exit(0);
			}
			// for each foothold
			for (int i = 0; i < F; i++) {
				// if it's not the current foothold and we can get a better distance than previous
				if (i != current && dist[current] + 1 < dist[i]) {
					// if within 1000 mm
					if (Math.sqrt(Math.pow(footholds[i][0] - footholds[current][0], 2) + Math.pow(footholds[i][1] - footholds[current][1], 2)) <= 1000) {
						dist[i] = dist[current] + 1;
						q.add(i);
					}
				}
			}
		}
		
	}
	
}

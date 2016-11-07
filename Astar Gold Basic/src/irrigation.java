import java.util.*;
import java.io.*;

public class irrigation {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("irrigation.in.txt"));
		PrintStream out = new PrintStream(new File("irrigation.out.txt"));
		
		// read input
		int V = in.nextInt();
		int C = in.nextInt();
		int[][] coordinates = new int[V][2];
		for (int i = 0; i < V; i++) {
			coordinates[i][0] = in.nextInt();
			coordinates[i][1] = in.nextInt();
		}
		
		boolean visited[] = new boolean[V];
		
		int start = 0;
		
		int distances[] = new int[V];
		for (int i = 0; i < V; i++) {
			int x = coordinates[i][0] - coordinates[start][0];
			int y = coordinates[i][1] - coordinates[start][1];
			distances[i] = x*x + y*y;
		}
		visited[start] = true;
		distances[start] = 0;
		int cost = 0;
		
		// loop V-1 times
		for (int i = 1; i < V; i++) {
			// find the optimal vertex (minimum distance)
			int index = 0, distance = INF;
			for (int j = 0; j < V; j++) {
				if (distances[j] >= C && distances[j] < distance && !visited[j]) {
					distance = distances[j];
					index = j;
				}
			}
			visited[index] = true;
			cost += distances[index];
			// update distances array
			for (int j = 0; j < V; j++) {
				int x = coordinates[j][0] - coordinates[start][0];
				int y = coordinates[j][1] - coordinates[start][1];
				distances[j] = Math.min(distances[j], x*x + y*y);
			}
		}
		System.out.println(cost);

	}
	
}

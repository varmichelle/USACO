import java.util.*;
import java.io.*;

public class alake {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("alake.in.txt"));
		PrintStream out = new PrintStream(new File("alake.out.txt"));
		
		// read in input
		int N = in.nextInt();
		// model a simplified linked list with arrays
		int[] prev = new int[N+2];
		int[] next = new int[N+2];
		int[] widths = new int[N+2];
		int[] heights = new int[N+2];
		long[] times = new long[N+2];
		int index = 1; // index of level being filled with water
		for (int i = 1; i <= N; i++) {
			widths[i] = in.nextInt();
			heights[i] = in.nextInt();
			prev[i] = i-1;
			next[i] = i+1;
			if (heights[i] < heights[index]) index = i;
		}
		
		// model the ends of the lake as levels with infinite height
		heights[0] = INF;
		heights[N+1] = INF;
		
		long current = 0;
		
		// continue until the current level is one of the walls (finished)
		while (heights[index] < INF) {
			// calculate the time it takes to fill the current level
			times[index] = current + widths[index];
			// delete the current level (merge)
			next[prev[index]] = next[index];
			prev[next[index]] = prev[index];
			// find next lowest level (shortest of two neighbors)
			if (heights[prev[index]] < heights[next[index]]) {
				current += widths[index] * (heights[prev[index]] - heights[index]);
				widths[prev[index]] += widths[index];
				index = prev[index];
				// find the next index
				while (index > 0 && heights[prev[index]] < heights[index]) index = prev[index];
			} else {
				current += widths[index] * (heights[next[index]] - heights[index]);
				widths[next[index]] += widths[index];
				index = next[index];
				// find the next index
				while (index <= N && heights[next[index]] < heights[index]) index = next[index];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(times[i]);
		}

	}

}

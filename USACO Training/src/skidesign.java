/*
ID: michell26
LANG: JAVA
TASK: skidesign
*/


import java.io.*;
import java.util.*;

public class skidesign {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("skidesign.in"));
		PrintStream out = new PrintStream(new File("skidesign.out"));
		
		int num_hills = in.nextInt();
		int[] heights = new int[num_hills];
		for (int i = 0; i < num_hills; i++) {
			heights[i] = in.nextInt();
		}
		Arrays.sort(heights);
		int min_height = heights[0];
		int least_cost = 999999999;
		while (min_height <= heights[num_hills - 1] - 17) {
			int current_sum = 0;
			for (int i = 0; i < num_hills; i++) {
				if (min_height > heights[i]) current_sum += Math.pow(heights[i] - min_height, 2);
				else if (heights[i] > min_height + 17) current_sum += Math.pow(heights[i] - min_height - 17, 2);
			}
			least_cost = Math.min(least_cost, current_sum);
			min_height++;
		}
		out.println(least_cost);

	}

}

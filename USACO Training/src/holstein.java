/*
ID: michell26
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {
	
	static int V, F, min = 999999999;
	static int[] vitamins;
		
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("holstein.in"));
		PrintStream out = new PrintStream(new File("holstein.out"));
		
		V = in.nextInt();
		vitamins = new int[V];
		for (int i = 0; i < V; i++) {
			vitamins[i] = in.nextInt();
		}
		F = in.nextInt();
		boolean[] solution = new boolean[F];
		int[][] feeds = new int[V][F];
		for (int i = 0; i < F; i++) {
			for (int j = 0; j < V; j++) {
				feeds[j][i] = in.nextInt();
			}
		}
		for (int i = 1; i <= Math.pow(2, F); i++) {
			String map = "000000000000000" + Integer.toBinaryString(i);
			boolean[] eat = new boolean[F];
			int[] current = new int[V];
			int numF = 0;
			map = map.substring(map.length() - F);
			for (int j = 0; j < F; j++) {
				if (map.charAt(j) == '1') {
					eat[j] = true;
					numF++;
					for (int k = 0; k < V; k++) current[k] += feeds[k][j];
				}
			}
			if (metReq(current) && numF <= min) {
				min = numF;
				for (int j = 0; j < F; j++) {
					solution[j] = eat[j];
				}
			}
		}
		out.print(min);
		for (int i = 0; i < F; i++) {
			if (solution[i]) out.print(" " + (i+1));
		}
		out.println();
		
	}

	public static boolean metReq(int[] current) {
		for (int i = 0; i < V; i++) {
			if (current[i] < vitamins[i]) return false;
		}
		return true;
	}

}

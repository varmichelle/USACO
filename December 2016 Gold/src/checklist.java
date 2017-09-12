import java.io.*;
import java.util.*;

public class checklist {
	
	public static final int INF = 999999999;
	public static int H, G, min = INF, limit = INF;
	public static int[][] hpos, gpos, dp_g, dp_h;
	
	public static void main (String[] args) throws FileNotFoundException {
		
		// set up file I/O
		Scanner in = new Scanner(new File("checklist.in.txt"));
		PrintStream out = new PrintStream(new File("checklist.out.txt"));
		
		// read in input
		H = in.nextInt();
		G = in.nextInt();
		hpos = new int[H][2];
		gpos = new int[G][2];
		for (int i = 0; i < H; i++) {
			hpos[i][0] = in.nextInt();
			hpos[i][1] = in.nextInt();
		}
		for (int i = 0; i < G; i++) {
			gpos[i][0] = in.nextInt();
			gpos[i][1] = in.nextInt();
		}
		
		/*
		 * DP solution
		 * Define h(n,m) = min energy needed to visit n h's and m g's and end on an h
		 * Define g(n,m) = min energy needed to visit n h's and m g's and end on a g
		 * We seek h(H,G)
		 * Recurrence: h(n,m) = min[h(n-1,m)+dist[h[n-1]][h[n]],g(n-1,m)+dist[g[m]][h[n]]
		 * Mirror for g(n,m)
		 * Base case h(1,0)=0
		 */
		dp_g = new int[H+1][G+1];
		dp_h = new int[H+1][G+1];
		for (int h = 0; h <= H; h++) {
			for (int g = 0; g <= G; g++) {
				dp_g[h][g] = -1;
				dp_h[h][g] = -1;
			}
		}
		dp_h[1][0] = 0;
		int energy = recurse(H, G, true);
		System.out.println(energy);
		
	}
	
	public static int recurse(int h, int g, boolean endOnH) {
		System.out.println(h+" "+g+" "+endOnH);
		if (h == 0) return INF;
		// want to compute dp_h(h,g)
		if (endOnH) {
			if (dp_h[h][g] != -1) {
				System.out.println("value is " + dp_h[h][g]);
				return dp_h[h][g];
			}
			else {
				int hAnswer = INF;
				if (h >= 2) hAnswer = (int) (recurse(h-1,g,true) + Math.pow(hpos[h-2][0]-hpos[h-1][0],2) + Math.pow(hpos[h-2][1]-hpos[h-1][1],2));
				int gAnswer = INF;
				if (g >= 1 && h >= 1) gAnswer = (int) (recurse(h-1,g,false) + Math.pow(gpos[g-1][0]-hpos[h-1][0],2) + Math.pow(gpos[g-1][1]-hpos[h-1][1],2));
				int min = Math.min(hAnswer, gAnswer);
				System.out.println("h min is " + min);
				if (min != INF) dp_h[h][g] = min;
				return dp_h[h][g];
			}
		}
		// want to compute dp_g(h,g)
		else {
			if (dp_g[h][g] != -1) {
				System.out.println(dp_g[h][g]);
				return dp_g[h][g];
			}
			else {
				int hAnswer = INF;
				if (h >= 2 && g >= 1) hAnswer = (int) (recurse(h,g-1,false) + Math.pow(hpos[h-2][0]-gpos[g-1][0],2) + Math.pow(hpos[h-2][1]-gpos[g-1][1],2));
				int gAnswer = INF;
				if (g >= 2) gAnswer = (int) (recurse(h,g-1,true) + Math.pow(gpos[g-2][0]-gpos[g-1][0],2) + Math.pow(gpos[g-2][1]-gpos[g-1][1],2));
				int min = Math.min(hAnswer, gAnswer);
				System.out.println("g min is " + min);
				if (min != INF) dp_g[h][g] = min;
				return dp_g[h][g];
			}
		}
	}
	
}
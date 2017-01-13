import java.io.*;
import java.util.*;

public class checklist {
	
	public static int H, G, min = 999999999, limit = 999999999;
	public static int[][] hpos, gpos;
	
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
		recurse(1,0,hpos[0][0], hpos[0][1],0);
		System.out.println(limit);
		dfs(1,0,hpos[0][0], hpos[0][1],0);
		System.out.println(min);
		
	}
	
	public static void dfs(int nh, int ng, int px, int py, int energy) {
		// termination condition
		if (ng == G && nh == H - 1) {
			energy += (int) (Math.pow(px - hpos[H-1][0], 2) + Math.pow(py - hpos[H-1][1], 2));
			min = Math.min(min, energy);
			return;
		}
		if (nh < H-1) {
			int newEnergy = energy + (int) (Math.pow(px - hpos[nh][0], 2) + Math.pow(py - hpos[nh][1], 2));
			dfs(nh + 1, ng, hpos[nh][0], hpos[nh][1], newEnergy);
		}
		if (ng < G) {
			int newEnergy = energy + (int) (Math.pow(px - gpos[ng][0], 2) + Math.pow(py - gpos[ng][1], 2));
			dfs(nh, ng + 1, gpos[ng][0], gpos[ng][1], newEnergy);
		}
	}
	
	public static void recurse(int nh, int ng, int px, int py, int energy) {
		// termination condition
		if (ng == G && nh == H - 1) {
			energy += (int) (Math.pow(px - hpos[H-1][0], 2) + Math.pow(py - hpos[H-1][1], 2));
			limit = energy;
			return;
		}
		int hdist = (int) (Math.pow(px - hpos[nh][0], 2) + Math.pow(py - hpos[nh][1], 2));
		int gdist = (int) (Math.pow(px - gpos[ng][0], 2) + Math.pow(py - gpos[ng][1], 2));
		boolean hworks = false, gworks = false;
		if (nh < H-1) hworks = true;
		if (ng < G) gworks = true;
		if (gworks && hworks) {
			if (gdist < hdist) {
				// do g
				int newEnergy = energy + (int) (Math.pow(px - gpos[ng][0], 2) + Math.pow(py - gpos[ng][1], 2));
				dfs(nh, ng + 1, gpos[ng][0], gpos[ng][1], newEnergy);
			} else {
				// do h
				int newEnergy = energy + (int) (Math.pow(px - hpos[nh][0], 2) + Math.pow(py - hpos[nh][1], 2));
				dfs(nh + 1, ng, hpos[nh][0], hpos[nh][1], newEnergy);
			}
		}
		else if (nh < H-1) {
			hworks = true;
			int newEnergy = energy + (int) (Math.pow(px - hpos[nh][0], 2) + Math.pow(py - hpos[nh][1], 2));
			dfs(nh + 1, ng, hpos[nh][0], hpos[nh][1], newEnergy);
		}
		else if (ng < G) {
			gworks = true;
			int newEnergy = energy + (int) (Math.pow(px - gpos[ng][0], 2) + Math.pow(py - gpos[ng][1], 2));
			dfs(nh, ng + 1, gpos[ng][0], gpos[ng][1], newEnergy);
		}
		
	}
	
}
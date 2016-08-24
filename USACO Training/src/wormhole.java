/*
ID: michell26
LANG: JAVA
TASK: wormhole
*/


import java.io.*;
import java.util.*;

public class wormhole {
	
	static int[] pairings, next_wormhole;
	static int num_wormholes, total = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("wormhole.in"));
		PrintStream out = new PrintStream(new File("wormhole.out"));
		
		num_wormholes = in.nextInt();
		// pairings[i] stores the # of the wormhole that the ith wormhole is paired with
		pairings = new int[num_wormholes + 1];
		next_wormhole = new int[num_wormholes + 1];
		coordinates[] pos = new coordinates[num_wormholes + 1];
		for (int i = 1; i <= num_wormholes; i++) {
			pos[i] = new coordinates();
			pos[i].x = in.nextInt();
			pos[i].y = in.nextInt();
		}
		// find the wormhole on the right of the ith wormhole
		for (int i = 1; i <= num_wormholes; i++) {
			for (int j = 1; j <= num_wormholes; j++) {
				if (pos[i].y == pos[j].y && pos[j].x > pos[i].x) {
					if (next_wormhole[i] == 0 || pos[j].x - pos[i].x < pos[next_wormhole[i]].x - pos[i].x) next_wormhole[i] = j;
				}
			}
		}
		pair();
		out.println(total);

	}
	
	public static void pair() {
		int i;
		for (i = 1; i <= num_wormholes; i++) {
			// if the ith wormhole hasn't been paired
			if (pairings[i] == 0) break; 
		}
		// if all wormholes paired, check if loop exists
		if (i > num_wormholes) total+= loop();
		// otherwise pair wormholes
		for (int j = i + 1; j <= num_wormholes; j++) {
			if (pairings[j] == 0) {
				pairings[i] = j;
				pairings[j] = i;
				pair();
				pairings[i] = 0;
				pairings[j] = 0;
			}
		}
		
	}

	public static int loop() {
		for (int i = 1; i <= num_wormholes; i++) {
			int position = i;
			for (int j = 1; j <= num_wormholes; j++) {
				position = pairings[position];
				position = next_wormhole[position];
			}
			if (position != 0) return 1;
		}
		return 0;
	}

}

class coordinates {
	int x, y;
}
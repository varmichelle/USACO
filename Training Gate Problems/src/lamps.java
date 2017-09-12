/*
ID: michell26
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;

public class lamps {
			
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("lamps.in"));
		PrintStream out = new PrintStream(new File("lamps.out"));
		
		int N = in.nextInt();
		int C = in.nextInt();
		while (C > 4) C-=2;
		int[] on = new int[101];
		int[] off = new int[101];
		// read in on/off lamps
		int next = in.nextInt();
		int cnt1 = 1;
		while (next != -1) {
			on[cnt1] = next;
			next = in.nextInt();
			cnt1++;
		}
		next = in.nextInt();
		int cnt2 = 1;
		while (next != -1) {
			off[cnt2] = next;
			next = in.nextInt();
			cnt2++;
		} 
		
		int[][] seq = new int[101][16];
		index[] sort = new index[16];
		for (int i = 0; i < 16; i++) {
			sort[i] = new index();
			sort[i].binary = "999999999";
			sort[i].index = -1;
		}
		// only 16 combinations of button presses (mod 2, order doesn't matter)
		for (int count = 0; count <= 15; count++) {
			for (int i = 1; i <= N; i++) {
				seq[i][count] = 1;
			}
			String bin = "0000" + Integer.toBinaryString(count);
			bin = bin.substring(bin.length() - 4);
			int numButtons = 0;
			for (int i = 0; i < 4; i++) {
				if (bin.charAt(i) == '1') numButtons++;
			}
			if (numButtons != C && numButtons != C-2 && numButtons != C-4) continue;
			// button 1
			if (bin.charAt(0) == '1') {
				for (int i = 1; i <= N; i++) {
					seq[i][count] = 1 - seq[i][count];
				}
			}
			// button 2
			if (bin.charAt(1) == '1') {
				for (int i = 1; i <= N; i+=2) {
					seq[i][count] = 1 - seq[i][count];
				}
			}
			// button 3
			if (bin.charAt(2) == '1') {
				for (int i = 2; i <= N; i+=2) {
					seq[i][count] = 1 - seq[i][count];
				}
			}
			// button 4
			if (bin.charAt(3) == '1') {
				for (int i = 1; i <= N; i+=3) {
					seq[i][count] = 1 - seq[i][count];
				}
			}
			boolean works = true;
			// check on lamps
			for (int j = 1; j < cnt1; j++) {
				if (seq[on[j]][count] == 0) {
					works = false;
					break;
				}
			}
			// check off lamps
			for (int j = 1; j < cnt2; j++) {
				if (seq[off[j]][count] == 1) {
					works = false;
					break;
				}
			}
			String binary = "";
			if (works) {
				for (int j = 1; j <= N; j++) binary+= seq[j][count];
				sort[count].binary = binary;
				sort[count].index = count;
			}
		}			
		Arrays.sort(sort);
		for (int i = 0; i < 16; i++) {
			if (sort[i].binary != "999999999") {
				for (int j = 1; j <= N; j++) out.print(seq[j][sort[i].index]);
				out.println();
			} else if (i == 0){
				out.println("IMPOSSIBLE");
				System.exit(0);
			}
		}
	}

}

class index implements Comparable<index>{
	String binary; 
	int index;
	public int compareTo(index x) {
		return this.binary.compareTo(x.binary);
	}
}

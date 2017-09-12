

import java.io.*;
import java.util.*;

public class barn1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("barn1.in"));
		PrintStream out = new PrintStream(new File("barn1.out"));
		
		int max = in.nextInt();
		int num_stalls = in.nextInt();
		int num_cows = in.nextInt();
		boolean[] stalls = new boolean[num_stalls];
		Arrays.fill(stalls, false);
		for (int i = 0; i < num_cows; i++) {
			int index = in.nextInt() - 1;
			stalls[index] = true;
		}
		int[] space_between = new int[num_stalls];
		int consecutive_empty = 0;
		int num_boards = 1;
		int length = 0;
		boolean knock = false;
		for (int i = 0; i < num_stalls; i++) {
			if (stalls[i] == true) knock = true;
			if (stalls[i] == false && knock) consecutive_empty++;
			if (stalls[i] == true && consecutive_empty != 0){
				space_between[i] = consecutive_empty;
				consecutive_empty = 0;
				num_boards++;
			}
			if (stalls[i] == true) length++;
		}
		Arrays.sort(space_between);
		int upper = num_boards - max;
		for (int i = 0; i < upper; i++) {
			if (space_between[i] == 0) upper++;
			else length += space_between[i];
		}
		out.println(length);

	}

}

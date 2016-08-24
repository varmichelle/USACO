import java.io.*;
import java.util.*;

public class feast {

	static int max, orange, lemon, min;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("feast.in"));
		PrintStream out = new PrintStream(new File("feast.out"));

		max = scan.nextInt();
		orange = scan.nextInt();
		lemon = scan.nextInt();
		min = max;
		int current_fullness = 0;
		// find_max(0);
		int c1_diff = max, c2_diff = max, c3_diff = max, c4_diff = max;
		for (int i = 0; i <= max / orange; i++) {
			for (int j = 0; j <= max / lemon; j++) {
				if (i * orange + j * lemon > max)
					break;
				current_fullness = Math.max(i * orange + j * lemon, current_fullness);
			}
		}
		c1_diff = max - current_fullness;
		if (c1_diff == 0) {
			out.println(max);
			System.exit(0);
		}

		// case for even orange, odd lemon:
		current_fullness = 0;
		for (int i = 0; i <= max / orange; i++) {
			for (int j = 1; j <= max / lemon; j++) {
				if (i * orange + j * lemon > max + (lemon + 1) / 2)
					break;
				current_fullness = Math.max(i * orange + j * lemon, current_fullness);
			}
		}
		c2_diff = max + (lemon + 1) / 2 - current_fullness;
		if (c2_diff == 0) {
			out.println(max);
			System.exit(0);
		}

		// case for odd orange, even lemon:
		current_fullness = 0;
		for (int i = 1; i <= max / orange; i++) {
			for (int j = 0; j <= max / lemon; j++) {
				if (i * orange + j * lemon > max + (orange + 1) / 2)
					break;
				current_fullness = Math.max(i * orange + j * lemon, current_fullness);
			}
		}
		c3_diff = max + (orange + 1) / 2 - current_fullness;
		if (c3_diff == 0) {
			out.println(max);
			System.exit(0);
		}
		
		// case for odd orange, odd lemon:
		current_fullness = 0;
		if (max >= orange + lemon) {
			for (int i = 1; i <= max / orange; i++) {
				for (int j = 1; j <= max / lemon; j++) {
					if (i * orange + j * lemon > max + (lemon + 1 + orange) / 2)
						break;
					current_fullness = Math.max(i * orange + j * lemon, current_fullness);
				}
			}
			c4_diff = max + (lemon + 1 + orange) / 2 - current_fullness;
		}
		if (c4_diff == 0) {
			out.println(max);
			System.exit(0);
		}

		min = Math.min(Math.min(c1_diff, c2_diff), Math.min(c3_diff, c4_diff));
		out.println(max - min);

	}

}

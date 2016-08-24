import java.io.*;
import java.util.*;

public class angry {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("angry.in"));
		PrintStream out = new PrintStream(new File("angry.out"));
		
		// BRONZE VERSION
		/* int N = scan.nextInt();
		int[] hay_bales = new int[N];
		for (int i = 0; i < N; i++) {
			hay_bales[i] = scan.nextInt();
		}
		Arrays.sort(hay_bales);
		int num_explosions = 1;
		// Loop through each possible hay bale start position
		for (int i = 0; i < N; i++) {
			int left_index = get_index(N, hay_bales, i, false);
			int right_index = get_index(N, hay_bales, i, true);
			num_explosions = Math.max(num_explosions, right_index - left_index + 1);
		}
		out.println(num_explosions); */
		
		// SILVER VERSION
		
		
	}	
	
	public static int get_index (int N, int[] hay_bales, int start, boolean right) {
		int last_index = start;
		int radius = 1;
		while (last_index > 0 && last_index < N - 1) {
			int direction;
			if (right) direction = 1;
			else direction = -1;
			int next_index = last_index;
			while (next_index + direction >= 0 && next_index + direction < N && Math.abs(hay_bales[next_index + direction] - hay_bales[last_index]) <= radius) {
				next_index += direction;
			}
			if (next_index == last_index) break;
			last_index = next_index;
			radius++;
		}
		return last_index;
	}

}

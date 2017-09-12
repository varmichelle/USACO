import java.util.*;
import java.io.*;

public class bphoto {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("bphoto.in"));
		PrintStream out = new PrintStream(new File("bphoto.out"));
		
		int N = in.nextInt();
		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = in.nextInt();
		}
		int count = 2;
		// 0=idk, 1=left>, 2=right>
		int[] answer = new int[N];
		answer[0] = 2;
		answer[N-1] = 1;
		// loop through each cow to check if unbalanced
		for (int i = 1; i < N - 1; i++) {
			// check each cow
			int l = 0, r = 0;
			// left
			for (int j = i-1; j >= 0; j--) {
				if (heights[j] > heights[i]) l++;
			}
			// right
			for (int j = i+1; j < N; j++) {
				if (heights[j] > heights[i]) r++;
				if (r > 2*l) break;
			}
			if (l > 2*r) {
				answer[i] = 1;
				count++;
			} else if (r > 2*l) {
				answer[i] = 2;
				count++;
			}
		}
		out.println(count);

	}

}

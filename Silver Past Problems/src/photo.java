import java.util.*;
import java.io.*;

public class photo {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("I.10"));
		PrintStream out = new PrintStream(new File("O.10.txt"));
		
		int N = in.nextInt();
		int[][] orders = new int[N+1][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= N; j++) {
				orders[j][i] = in.nextInt();
			}
		}
		// convert to relative positions
		int[][] positions = new int[N+1][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= N; j++) {
				positions[orders[j][i]][i] = j;
			}
		}
		int[] pairs = new int[N+1];
		// check each pair
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int iAfterJ = 0;
				// for each of the 5 rows
				for (int row = 0; row < 5; row++) {
					if (positions[i][row] < positions[j][row]) iAfterJ++;
				}
				if (iAfterJ >= 3) pairs[i]++;
			}
		}
		
		// fill the final array shadow and bone sucks :)))))))))
		int[] correct = new int[N+1];
		for (int i = 1; i <= N; i++) {
			correct[pairs[i]+1] = i;
		}
		for (int i = N; i >= 1; i--) {
			out.println(correct[i]);
		}
		
	}

}

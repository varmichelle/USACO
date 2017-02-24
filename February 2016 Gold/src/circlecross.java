import java.io.*;
import java.util.*;

public class circlecross {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("circlecross.in"));
		PrintStream out = new PrintStream(new File("circlecross.out"));
		
		int N = in.nextInt();
		/*boolean[] open = new boolean[N+1];
		int[] ans = new int[N+1];
		open[in.nextInt()] = true;
		for (int i = 1; i < 2*N; i++) {
			int id = in.nextInt();
			for (int j = 1; j <= N; j++) {
				// adding another in between
				if (open[j] && id != j) ans[j]++;				
			}
			// if open already, subtract from everything open
			if (open[id]) {
				for (int j = 1; j <= N; j++) {
					if (j != id && open[j] && ans[id] < ans[j]) ans[j]-=2;
				}
				open[id] = false;
			}
			// open the current if it isn't already open
			else open[id] = true;
			System.out.println("round " + i);
			for (int j = 1; j <= N; j++) System.out.print(ans[j] + " ");
			System.out.println();
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += ans[i];
		}
		out.println(sum/2);
		*/
		boolean arr[][] = new boolean[N+1][N+1];
		int first = in.nextInt();
		for (int i = 1; i < 2*N; i++) {
			int id = in.nextInt();
			for (int j = 1; j <= N; j++) {
				if (!arr[j][0]) {
					for (int k = 1; k <= N; k++) arr[j][k] = !arr[j][k];
				}
			}
		}
		
	}

}

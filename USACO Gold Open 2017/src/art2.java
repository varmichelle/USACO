import java.util.*;
import java.io.*;

public class art2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("art2.in"));
		PrintStream out = new PrintStream(new File("art2.out"));
		
		int N = in.nextInt();
		int[] painting = new int[N+1];
		int[][] bounds = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			bounds[i][0] = -1;
			bounds[i][1] = -1;
		}
		for (int i = 1; i <= N; i++) {
			painting[i] = in.nextInt();
			if (bounds[painting[i]][0] == -1) bounds[painting[i]][0] = i;
			else bounds[painting[i]][1] = i;
		}
		int maxLayers = 0;
		for (int i = 1; i <= N; i++) {
			int current = 0;
			for (int j = 1; j <= N; j++) {
				if (bounds[j][0] == -1) continue;
				if (bounds[j][1] == -1 && bounds[j][0] == i) current++;
				else if (i >= bounds[j][0] && i <= bounds[j][1]) current++;
			}
			maxLayers = Math.max(maxLayers, current);
		}
		out.println(maxLayers);
	}

}
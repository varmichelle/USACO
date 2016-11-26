import java.util.*;
import java.io.*;

public class ccski {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("ccski.in.txt"));
		PrintStream out = new PrintStream(new File("ccski.out.txt"));
		
		// read in input
		int M = in.nextInt();
		int N = in.nextInt();
		int[][] elevations = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				elevations[i][j] = in.nextInt();
			}
		}
		int[][] isWaypoint = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				isWaypoint[i][j] = in.nextInt();
			}
		}
		
		

	}

}

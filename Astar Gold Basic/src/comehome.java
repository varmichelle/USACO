import java.util.*;
import java.io.*;

public class comehome {
	
	static final int INF = 999999999;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("comehome.in.txt"));
		PrintStream out = new PrintStream(new File("comehome.out.txt"));
		
		// read in input
		int P = in.nextInt();
		int[][] adj = new int[52][52];
		
		// populate the adj matrix with INF initially
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				adj[i][j] = INF;
			}
		}
		
		// update the adj matrix with the lengths
		for (int i = 0; i < P; i++) {
			char pasture1 = in.next().charAt(0);
			char pasture2 = in.next().charAt(0);
			// do some ASCII conversion to convert chars to ints
			int p1 = (int) pasture1 - 65;
			// -6 accounts for the weird characters between uppercase and lowercase
			if (p1 > 25) p1 -= 6;
			int p2 = (int) pasture2 - 65;
			if (p2 > 25) p2 -= 6;
			// because there could be multiple paths between the same barns with different distances
			adj[p1][p2] = Math.min(in.nextInt(), adj[p1][p2]);
			adj[p2][p1] = adj[p1][p2];
		}
		
		// account for paths going to themselves
		for (int i = 0; i < 52; i++) adj[i][i] = 0;
				
		// Floyd-Warshall
		for (int k = 0; k < 52; k++) {
			for (int i = 0; i < 52; i++) {
				for (int j = 0; j < 52; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		
		int bestDist = INF, barnNum = 0;
		for (int i = 0; i <= 24; i++) {
			if (adj[i][25] < bestDist) {
				bestDist = adj[i][25];
				barnNum = i + 65;
			}
		}
		
		System.out.println((char) barnNum + " " + bestDist);

	}

}

import java.io.*;
import java.util.*;

public class contest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("contest.in.txt"));
		PrintStream out = new PrintStream(new File("contest.out.txt"));
		
		int numCows = scan.nextInt();
		int numRounds = scan.nextInt();
		
		int[][] results = new int[numRounds][2];
		for (int i = 0; i < numRounds; i++) {
			// winner
			results[i][0] = scan.nextInt();
			// loser
			results[i][1] = scan.nextInt();
		}
		
		
		
	}
	
}

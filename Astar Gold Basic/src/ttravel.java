import java.util.*;
import java.io.*;

public class ttravel {

	public static void main(String[] args) throws FileNotFoundException {
	
		// set up file readers and writers
		Scanner in = new Scanner(new File("ttravel.in.txt"));
		PrintStream out = new PrintStream(new File("ttravel.out.txt"));
		
		// read in input
		int N = in.nextInt();
		// 0: last cow index, 1: parent
		int[][] cows = new int[N + 2][2];
		cows[0][0] = -1;
		cows[0][1] = -1;
		for (int i = 1; i <= N; i++) {
			String letter = in.next();
			if (letter.equals("a")) {
				cows[i][0] = in.nextInt();
				cows[i][1] = i-1;
			} else if (letter.equals("s")) {
				cows[i][1] = cows[cows[i-1][1]][1];
				cows[i][0] = cows[cows[i][1]+1][0];
			} else if (letter.equals("t")) {
				int index = in.nextInt();
				cows[i][1] = cows[index-1][1];
				cows[i][0] = cows[index-1][0];
			}
			System.out.println(cows[i][0]);
		}

	}

}

import java.util.*;
import java.io.*;

public class ttravel {

	public static void main(String[] args) throws FileNotFoundException {
	
		// set up file readers and writers
		Scanner in = new Scanner(new File("ttravel.in.txt"));
		PrintStream out = new PrintStream(new File("ttravel.out.txt"));
		
		// read in input
		int N = in.nextInt();
		String[] queries = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String letter = in.next();
			if (letter == "a") {
				int number = in.nextInt();
				queries[i] = letter + " " + number;
			} else if (letter == "s") {
				queries[i] = letter;
			} else if (letter == "t") {
				int number = in.nextInt();
				queries[i] = letter + " " + number;
			}
		}
		
		// create the herd
		Stack<Integer> cows = new Stack<Integer>();
		for (int i = 1; i <= N; i++) {
			String query = queries[i];
			if (query.charAt(0) == 's') cows.pop();
			else cows.push((int) query.charAt(2));
		}

	}

}

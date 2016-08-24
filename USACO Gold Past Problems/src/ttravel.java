import java.io.*;
import java.util.*;

public class ttravel {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("ttravel.in.txt"));
		PrintStream out = new PrintStream(new File("ttravel.out.txt"));
		
		int num_queries = scan.nextInt();
		Stack<String> cows = new Stack<String>();
		String[][] queries = new String[num_queries][2];
		for (int i = 0; i < num_queries; i++) {
			queries[i][0] = scan.next();
			if (queries[i][0].equals("a")) queries[i][1] = scan.next();
			else if (queries[i][0].equals("t")) {
				queries[i][1] = scan.next();
			}
		}
		for (int j = num_queries - 1; j >= 0; j--) {
			if (queries[j][0].equals("t")) {
				for (int i = j; i >= Integer.parseInt(queries[j][1]) - 1; i--) {
					queries[i][0] = "";
				}
			}
		}
		for (int k = 0; k < num_queries; k++) {
			if (queries[k][0].equals("a")) cows.push(queries[k][1]);
			else if (queries[k][0].equals("s")) cows.pop();
		}
	}

}

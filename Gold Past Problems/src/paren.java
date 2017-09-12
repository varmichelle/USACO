
import java.util.*;
import java.io.*;

public class paren {

	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * General solution idea:
		 * Keep track of depth (add 1 if open, subtract 1 if close)
		 * Every time you see a "()", add 2^depth to the sum
		 */
		
		Scanner in = new Scanner(new File("paren.in.txt"));
		PrintStream out = new PrintStream(new File("paren.out.txt"));
		
		int length = in.nextInt();
		int depth = 0, prev = 0;
		long sum = 0;
		// loop through the string
		for (int i = 0; i < length; i++) {
			int input = in.nextInt();
			// if it's an opening parentheses, increment depth by 1 and move on
			if (input == 0) depth++;
			// if it's a closing parentheses and previous was opening -> "()"
			else if (input == 1 && prev == 0) {
				// add 2^(depth-1)
				long pow = 1L;
				for (int j = 1; j < depth; j++) {
					pow *= 2;
					pow %= 12345678910L;
				}
				sum += pow;
				sum %= 12345678910L;
				depth--;
			} else {
				depth--;
			}
			prev = input;
		}
		System.out.println(sum);
		
	}

}

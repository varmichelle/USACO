import java.io.*;
import java.util.*;

public class lookup {

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("lookup.in.txt"));
		PrintStream out = new PrintStream(new File("lookup.out.txt"));
		
		// read in input
		int N = in.nextInt();
		int[] heights = new int[N];
		int[] lookups = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = in.nextInt();
		}
		
		// stores the indexes of the cows that need someone to look up to
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty()) {
				// if the current cow is taller than the previous cow in the stack, update lookups
				if (heights[i] > heights[stack.peek()]) {
					// add one because array index starts from 0 but given index starts from 1
					lookups[stack.peek()] = i + 1;
					stack.pop();
				} else break;
			}
			stack.push(i);
		}
		
		// print the results
		for (int i = 0; i < N; i++) {
			System.out.println(lookups[i]);
		}

	}

}

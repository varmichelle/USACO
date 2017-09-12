import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class haybales {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("haybales.in"));
		PrintStream fileWriter = new PrintStream(new File("haybales.out"));
		
		int n = fileReader.nextInt();
		int[] stacks = new int[n];
		int total = 0;
		int goal;
		
		for (int i = 0; i < n; i++) {
			stacks[i] = fileReader.nextInt();
			total += stacks[i];
		}
		goal = total / n;
		int numSteps = 0;
		for (int i = 0; i < n; i++) {
			numSteps += Math.abs(goal-stacks[i]);
		}
		fileWriter.println(numSteps/2);
		
	}

}

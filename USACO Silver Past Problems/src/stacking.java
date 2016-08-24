import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class stacking {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("stacking.in"));
		PrintStream fileWriter = new PrintStream(new File("stacking.out"));
		// n = number of haystacks
		int n = fileReader.nextInt();
		// k = number of commands
		int k = fileReader.nextInt();
		int[] commandsStart = new int[k];
		int[] commandsEnd = new int[k];
		int[] haystacks = new int[n];
		int[] differences = new int[n];
		// Haystacks ex: 1 2 3 2 0 9
		// Differences ex: 1 1 -1 -1 9
		for (int i = 0; i < k; i++) {
			commandsStart[i] = fileReader.nextInt();
			commandsEnd[i] = fileReader.nextInt();
		}
		// Map commands to differences[]
		for (int i = 0; i < k; i++) {
			differences[commandsStart[i]-1] += 1;
			if (commandsEnd[i] != n) {
				differences[commandsEnd[i]] -= 1;
			}
		}
		
		// Map differences to haystacks[]
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				haystacks[i] = differences[i];
			} else {
				haystacks[i] = differences[i] + haystacks[i - 1];
			}
		}
		Arrays.sort(haystacks);
		fileWriter.println(haystacks[(n + 1) / 2 - 1]);

	}

}

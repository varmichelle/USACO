import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class elect {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("elect.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("elect.out.txt"));

		// Read in input
		int n = fileReader.nextInt();
		int k = fileReader.nextInt();
		int[] r1 = new int[n];
		int[] r2 = new int[n];
		for (int i = 0; i < n; i++) {
			// r1 is for round 1 (unsorted) (includes all cows)
			r1[i] = fileReader.nextInt();
			// r2 is for round 2 (unsorted) (includes all cows)
			r2[i] = fileReader.nextInt();
		}
		// sortedR1 is the sorted version of r1 (including all cows)
		int[] sortedR1 = new int[n];
		for (int i = 0; i < n; i++) {
			// copy elements of r1 (round1) into sortedR1 and sort sortedR1
			sortedR1[i] = r1[i];
		}
		Arrays.sort(sortedR1);

		// Current highest number of votes in round 2 
		// (should become the winning cow's votes after checking all votes)
		int r2WinningCowNumVotes = 0;
		// Array index of the winning cow
		int r2WinningCowIndex = 0;
		
		// Looping through the cows that advanced to the second round: 
		for (int i = n - 1; i >= n - k; i--) {
			// Looping through the original unsorted array to find the indexes
			// of cows that advanced to the second round
			for (int j = 0; j < n; j++) {
				// sortedR1 (index n-1 through n-k) contains the round 1 vote counts of winning cows
				// If a match is found (found the cows that advanced to round 2 in the original array)
				if (r1[j] == sortedR1[i]) {
					// Check the matching vote count for round 2 from the cows that advanced to round 2
					// If the current # votes in round 2 is greater than the highest vote count so far, 
					if (r2[j] > r2WinningCowNumVotes) {
						// Set the highest vote count equal to the current # votes
						r2WinningCowNumVotes = r2[j];
						// Save the index of the winning cow
						r2WinningCowIndex = j;
					}
				}
			}
		}
		// Add 1 because cow index goes from 1...n but array index is from 0...n-1
		fileWriter.println(r2WinningCowIndex + 1);
	}
}

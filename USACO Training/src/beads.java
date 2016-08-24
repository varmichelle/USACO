

import java.io.*;
import java.util.Scanner;

public class beads {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("beads.in"));
		PrintStream fileWriter = new PrintStream(new File("beads.out"));
		int n = fileReader.nextInt();
		char[] necklace = fileReader.next().toCharArray();
		int currentSum = 0, bestSum = 0;
		char badColor;
		
		// Loop through all possible breakpoints
		for (int i = 0; i < n; i++) {
			badColor = 'a';
			// Check left
			for (int j = 1; j < n; j++) {
				if (necklace[(i-j+n) % n] == badColor) {
					break;
				}
				else {
					if (necklace[(i-j+n) % n] == 'r' && badColor == 'a') {
						badColor = 'b';
					}
					if (necklace[(i-j+n) % n] == 'b' && badColor == 'a') {
						badColor = 'r';
					}
					currentSum++;
				}
			}
			badColor = 'a';
			// Check right
			for (int j = 0; j < n; j++) {
				if (necklace[(i+j) % n] == badColor) {
					break;
				}
				else {
					if (necklace[(i+j) % n] == 'r' && badColor == 'a') {
						badColor = 'b';
					}
					if (necklace[(i+j) % n] == 'b' && badColor == 'a') {
						badColor = 'r';
					}
					currentSum++;
				}
			}
			if (currentSum > bestSum) {
				bestSum = currentSum;
			}
			currentSum = 0;
		}
	
		if (bestSum > n) {
			fileWriter.println(n);
		} else {
			fileWriter.println(bestSum);
		}
	}
}

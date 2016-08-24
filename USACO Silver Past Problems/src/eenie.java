import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class eenie {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("eenie.in"));
		PrintStream fileWriter = new PrintStream(new File("eenie.out"));

		// Read in input
		int numHeifers = fileReader.nextInt();
		int sequenceLength = fileReader.nextInt();
		int[] elimination = new int[sequenceLength];
		for (int i = 0; i < sequenceLength; i++) {
			elimination[i] = fileReader.nextInt();
		}

		// Define some variables
		int currentHeiferIndex = 0;
		int numHeifersLeft = numHeifers;
		// Goes from 0...sequenceLength - 1
		int currentCommand = 0;
		int[] heifers = new int[numHeifers];
		for (int i = 0; i < numHeifers; i++) {
			// i goes from 0...numHeifers - 1
			// heifers[i] goes from 1...numHeifers
			heifers[i] = i + 1;
		}
		int currentCommandIndex = 0;
		int add = 0;
		
		while (numHeifersLeft > 1) {
			currentCommand = elimination[currentCommandIndex];
			for (int i = 0; i < currentCommand + add; i++) {
				if (heifers[(currentHeiferIndex + i) % numHeifers] == 0) {
					add++;
				} else {
					if (i == (currentCommand + add - 1)) {
						numHeifersLeft--;
						heifers[(i + currentHeiferIndex) % numHeifers] = 0;
						currentCommandIndex = (currentCommandIndex + 1) % sequenceLength;
						currentHeiferIndex = (i + currentHeiferIndex) % numHeifers;
					}
				}
			}
			add = 0;
		}
		
		// Print out the last remaining heifer
		Arrays.sort(heifers);
		fileWriter.println(heifers[numHeifers-1]);
	}
}
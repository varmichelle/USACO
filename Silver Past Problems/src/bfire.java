import java.io.*;
import java.util.Scanner;

public class bfire {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("bfire.in"));
		PrintStream fileWriter = new PrintStream(new File("bfire.out"));
		int numCows = fileReader.nextInt();
		int[] cows = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			// i = seat number (0...numCows-1)
			cows[i] = i;
			// cows[i] = cow in that seat (0...numCows-1)
		}
		int currentCow = 0;
		int currentCowSeat = 0;
		int nextCow = 0;
		int nextCowSeat = 0;
		int nextCowSeatCurrentOccupancy = currentCow;
		boolean drillOver = false;
		while (!drillOver) {
			currentCow = nextCow;
			currentCowSeat = nextCowSeat;
			cows[currentCowSeat] = -1;
			nextCow = cows[(currentCow + currentCowSeat + 1) % numCows];
			nextCowSeat = (currentCow + currentCowSeat + 1) % numCows;
			nextCowSeatCurrentOccupancy = cows[nextCowSeat];
			if (nextCowSeatCurrentOccupancy == -1) {
				fileWriter.println(currentCow + 1);
				drillOver = true;
			} else {
				cows[nextCowSeat] = -1;
			}
		}

	}

}

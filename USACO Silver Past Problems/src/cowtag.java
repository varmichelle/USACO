import java.io.*;
import java.util.Scanner;

public class cowtag {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("cowtag.in"));
		PrintStream fileWriter = new PrintStream(new File("cowtag.out"));

		int numCows = fileReader.nextInt();
		// fileWriter.println("Number of cows: " + numCows);
		int[][] cowPos = new int[numCows+1][2];
		for (int i = 0; i < numCows; i++) {
			// cowpos[i][0] = x coordinate
			// cowpos[i][1] = y coordinate
			cowPos[i][0] = fileReader.nextInt();
			// fileWriter.print(cowPos[i][0] + " ");
			cowPos[i][1] = fileReader.nextInt();
			// fileWriter.println(cowPos[i][1]);
		}

		int cowsLeft = numCows;
		int winningCowIndex = 0, currentCowIndex = 0, losingCowIndex = 0;
		// Loop through each cow remaining:
		while (cowsLeft > 1) {
			// If the current cow is already out, move on to the next cow
			if (cowPos[currentCowIndex][0] == -7501) {
				currentCowIndex++;
			} else {
				// Find the cow that's going to be out
				losingCowIndex = findLosingCow(currentCowIndex, cowPos,
						numCows);
				// System.out.println("Losing cow: " + (losingCowIndex+1));
				// Tag the cow as out of the game
				// System.out.println("Losing cow: " + (losingCowIndex + 1));
				cowPos[losingCowIndex][0] = -7501;
				// Move on to the next cow, and decrease the # of cows
				// remaining in the game by 1
				currentCowIndex++;
				cowsLeft--;
			}
			if (currentCowIndex >= numCows) {
				System.out.println("currentCowIndex: " + currentCowIndex);
				currentCowIndex = 0;
			}
			// System.out.println("Cows left: " + cowsLeft);
			if (cowsLeft == 1) {
				// Otherwise (if there is only one cow remaining):
				// Find the index of the winning cow
				winningCowIndex = findWinningCow(cowPos, numCows);
				// Add one to winningCowIndex because cow index goes from 1...n
				// instead of 0...n-1
				// System.out.println("Winning cow: " + (winningCowIndex + 1));
				fileWriter.println(winningCowIndex + 1);
				break;
			}
		}
	}


	// Finds the index of the winning cow
	private static int findWinningCow(int[][] cowPos, int numCows) {
		int winningCowIndex = 0;
		// While the winning cow has not been found, loop through each cow and
		// check if it's in/out of the game
		for (int i = 0; i < numCows; i++) {
			// If the cow is not out of the game, store its index and stop
			// searching
			if (cowPos[i][0] != -7501) {
				winningCowIndex = i;
				break;
			}
		}
		return winningCowIndex;
	}

	// Calculates the distance from the currentCow to all other cows in the game
	// The cow closest to the current cow is out of the game
	private static int findLosingCow(int currentCow, int[][] cowPos, int numCows) {
		double currentDistance = 0;
		double smallestDistance = 1000000000;
		int index = -1;
		for (int i = 0; i < numCows; i++) {
			// Use a^2 + b^2 = c^2 to find diagonal distances
			if (cowPos[i][0] != -7501 && i != currentCow) {
				currentDistance = Math.sqrt(Math.pow((double) cowPos[i][0] - cowPos[currentCow][0], (double) 2)
						+ Math.pow((double) cowPos[i][1] - cowPos[currentCow][1], (double) 2));
				System.out.println("Current distance: " + currentDistance);
				if (currentDistance < smallestDistance) {
					smallestDistance = currentDistance;
					index = i;
				}
			}
		}
		return index;

	}

}
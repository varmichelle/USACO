import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class cropcir {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("cropcir.in"));
		PrintStream fileWriter = new PrintStream(new File("cropcir.out"));
		int numCows = fileReader.nextInt();
		int[][] territory = new int[numCows][numCows];
		for (int i = 0; i < numCows; i++) {
			territory[i][0] = fileReader.nextInt(); // x-coordinate
			territory[i][1] = fileReader.nextInt(); // y-coordinate
			territory[i][2] = fileReader.nextInt(); // radius
		}
		int numOverlaps = 0;
		// Loop through each cow
		for (int i = 0; i < numCows; i++) {
			numOverlaps = 0;
			// Loop through each cow to check for overlaps with the first cow
			for (int j = 0; j < numCows; j++) {
				if (i != j) {				
					numOverlaps += overlap(numCows, territory, i, j);					
				}
			}
			fileWriter.println(numOverlaps);
		}

	}

	public static int overlap(int numCows, int[][] territory, int cow1, int cow2) {
		boolean overlap = false;
		double radiusTotal = territory[cow1][2] + territory[cow2][2];
		double distance = Math.sqrt(Math.pow(territory[cow1][0]-territory[cow2][0], 2) + Math.pow(territory[cow1][1] - territory[cow2][1], 2));
		if (distance < radiusTotal) {
			return 1;
		} else {
			return 0;
		}
	}

}

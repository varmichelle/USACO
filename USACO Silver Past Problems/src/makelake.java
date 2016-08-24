import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class makelake {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("makelake.in"));
		PrintStream fileWriter = new PrintStream(new File("makelake.out"));

		// Reading in input:
		int numRows = fileReader.nextInt();
		int numCols = fileReader.nextInt();
		int elevation = fileReader.nextInt();
		int numCommands = fileReader.nextInt();
		int[][] lake = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				lake[i][j] = fileReader.nextInt();
			}
		}
		int[][] commands = new int[3][numCommands];
		for (int j = 0; j < numCommands; j++) {
			for (int i = 0; i < 3; i++) {
				commands[i][j] = fileReader.nextInt();
			}
		}

		// Stomping simulation
		int finalHeight = 0;
		int row, col, numStomps;
		for (int i = 0; i < numCommands; i++) {
			row = commands[0][i];
			col = commands[1][i];
			numStomps = commands[2][i];
			int currentNum = 0;
			int max = 0;
			for (int j = row-1; j < row+2; j++) {
				for (int k = col-1; k < col+2; k++) {
					currentNum=lake[j][k];
					if (currentNum > max) {
						max = currentNum;
					}
				}
			}
			finalHeight = max - numStomps;
			for (int j = row-1; j <= row+1; j++) {
				for (int k = col-1; k <= col+1; k++) {
					if (lake[j][k] >= finalHeight) {
						lake[j][k] = finalHeight;
					}
				}
			}
		}

		// Water-filling simulation
		int amountWater = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (lake[i][j] < elevation) {
					amountWater += (elevation - lake[i][j]);
				}
			}
		}

		// Print amount of water in the lake * 72 in. * 72 in. 
		fileWriter.println(amountWater * 72 * 72);

	}

}

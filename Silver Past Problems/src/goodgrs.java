import java.io.*;
import java.util.Scanner;

public class goodgrs {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("goodgrs.in"));
		PrintStream fileWriter = new PrintStream(new File("goodgrs.out"));
		
		int numRows = fileReader.nextInt();
		int numCols = fileReader.nextInt();
		int[][] pasture = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				pasture[i][j] = fileReader.nextInt();
			}
		}
		int maxSum = 0;
		int currentSum = 0;
		int maxSum_row = 0;
		int maxSum_col = 0;
		// Looping through every possible starting point
		for (int startRow = 0; startRow < numRows-2; startRow++) {
			for (int startCol = 0; startCol < numCols-2; startCol++) {
				currentSum = findSumAtStartingPoint(pasture, startRow, startCol);
				if (currentSum > maxSum) {
					maxSum = currentSum;
					maxSum_row = startRow;
					maxSum_col = startCol;
				}		
			}
		}
		fileWriter.println(maxSum);
		fileWriter.println((maxSum_row+1) + " " + (maxSum_col+1));		

	}
	
	public static int findSumAtStartingPoint(int[][] pasture, int startRow, int startCol) {
		int sum = 0;
		for (int row = startRow; row < startRow+3; row++) {
			for (int col = startCol; col < startCol + 3; col++) {
				sum+= pasture[row][col];
			}
		}
		return sum;
	}

}

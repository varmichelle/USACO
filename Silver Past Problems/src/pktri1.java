import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class pktri1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("pktri1.in"));
		PrintStream fileWriter = new PrintStream(new File("pktri1.out"));
		int n = fileReader.nextInt();
		int seed = fileReader.nextInt();
		int[][] nums = new int[n][n];
		int currentNum = seed;
		int cRow = 0;
		int cCol = 0;
		for (int i = 0; i < (n*(n+1)/2); i++) {
			nums[cRow][cCol] = currentNum;
			if (cRow == cCol) {
				cRow = 0;
				cCol++;
			} else {
				cRow++;
			}
			if (currentNum == 9) {
				currentNum = 1;
			} else {
				currentNum++;
			}
		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (nums[row][col] == 0) {
					fileWriter.print(" ");
				} else {
					fileWriter.print(nums[row][col]);
				}
				if (col != n-1) {
					fileWriter.print(" ");
				}
			}
			fileWriter.println();
		}
		
	}

}

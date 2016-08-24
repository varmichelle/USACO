import java.io.*;
import java.util.Scanner;

public class claust {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("claust.in"));
		PrintStream fileWriter = new PrintStream(new File("claust.out"));
		
		int n = fileReader.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = fileReader.nextInt();
			y[i] = fileReader.nextInt();
		}
		double minDist = 1000000000;
		double curDist = 0;
		int cow1 = 0;
		int cow2 = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				curDist = distanceBetween(i, j, x[i], y[i], x[j], y[j]);
				if (curDist < minDist) {
					minDist = curDist;
					cow1 = i+1;
					cow2 = j+1;
				}
			}
		} 
		fileWriter.println(cow1 + " " + cow2);

	}
	
	public static double distanceBetween(int i, int j, int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
	}
	
}

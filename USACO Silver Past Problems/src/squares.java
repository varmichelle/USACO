import java.io.*;
import java.util.Scanner;

public class squares {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("squares.in"));
		PrintStream fileWriter = new PrintStream(new File("squares.out"));
		int n = fileReader.nextInt();
		int a, b;
		int numPairs = 0;
		for (a = 1; a < 501; a++) {
			for (b = 1; b < 501; b++) {
				if (Math.pow(a, 2) == Math.pow(b,  2) + n) {
					numPairs++;
				}
			}
		}
		fileWriter.println(numPairs);

	}

}

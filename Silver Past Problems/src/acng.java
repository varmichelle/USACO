import java.io.*;
import java.util.Scanner;

public class acng {

	public static void main(String[] args) throws FileNotFoundException {

		// Note: add .txt for running on this computer, but remove .txt when
		// submitting to the USACO grading machine
		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("acng.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("acng.out.txt"));
		int N = fileReader.nextInt();
		
		int numMoves = 0;
		
		while (N != 1) {
			if (N % 2 == 0) {
				N /=2;
			} else {
				N = N*3 + 1;
			}
			numMoves++;
		}
		fileWriter.println(numMoves);
		
	}

}

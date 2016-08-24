import java.util.Scanner;
import java.io.*;

public class setsub {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("setsub.in"));
		PrintStream fileWriter = new PrintStream(new File("setsub.out"));
		int numNums = fileReader.nextInt();
		// System.out.println(numNums);
		int[] possibleDigits = new int[numNums];
		for (int i = 0; i < numNums; i++) {
			possibleDigits[i] = fileReader.nextInt();
			// System.out.println(possibleDigits[i]);
		}
		int j = 0;
		for (int n = 1; n <= numNums; n++) {
			generateNums("", numNums, possibleDigits, 0, fileWriter, j, n);
			j = 0;
		}
	}
	
	public static void generateNums(String current, int numNums, int[] possibleDigits, int currentDigitIndex, PrintStream fileWriter, int j, int n) {
		if (currentDigitIndex >= n) {
			fileWriter.println(current);
		} else {
		for (int i = j; i < numNums; i++) {
			j = i+1;
			generateNums(current+possibleDigits[i], numNums, possibleDigits, currentDigitIndex + 1, fileWriter, j, n);
		}
		}
	}
}
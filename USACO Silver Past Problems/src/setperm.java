import java.util.Scanner;
import java.io.*;

public class setperm {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("setperm.in"));
		PrintStream fileWriter = new PrintStream(new File("setperm.out"));
		int numNums = fileReader.nextInt();
		int[] possibleDigits = new int[numNums];
		for (int i = 0; i < numNums; i++) {
			possibleDigits[i] = fileReader.nextInt();
		}
		int numDigits = fileReader.nextInt();
		generateNums("", numDigits, numNums, possibleDigits, 0, fileWriter);
		
	}
	
	public static void generateNums(String current, int numDigits, int numNums, int[] possibleDigits, int currentDigitIndex, PrintStream fileWriter) {
		if (currentDigitIndex >= numDigits) {
			fileWriter.println(current);
			return;
		} else {
			for (int i = 0; i < numNums; i++) {
				if (!current.contains("" + possibleDigits[i])) {
					generateNums(current+possibleDigits[i], numDigits, numNums, possibleDigits, currentDigitIndex + 1, fileWriter);
				}
			}
		}
	}

}

import java.util.Scanner;
import java.io.*;

public class setcomb {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("setcomb.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("setcomb.out.txt"));
		int numNums = fileReader.nextInt();
		int[] possibleDigits = new int[numNums];
		for (int i = 0; i < numNums; i++) {
			possibleDigits[i] = fileReader.nextInt();
		}
		int numDigits = fileReader.nextInt();
		int j = 0;
		generateNums("", numDigits, numNums, possibleDigits, 0, fileWriter, j);
		
	}
	
	public static void generateNums(String current, int numDigits, int numNums, int[] possibleDigits, int currentDigitIndex, PrintStream fileWriter, int j) {
		if (currentDigitIndex >= numDigits) {
			fileWriter.println(current);
			return;
		} else {
			for (int i = j; i < numNums; i++) {
				j = i+1;
				generateNums(current+possibleDigits[i], numDigits, numNums, possibleDigits, currentDigitIndex + 1, fileWriter, j);
			}
		}
	}

}

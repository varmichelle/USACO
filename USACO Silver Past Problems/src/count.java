import java.util.Scanner;
import java.io.*;

public class count {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("count.in"));
		PrintStream fileWriter = new PrintStream(new File("count.out"));

		int numCows = fileReader.nextInt();
		int avoidDigit = fileReader.nextInt();
		int currentNumber = 1;
		for (int i = 0; i < numCows; i++) {
			while ((currentNumber + "").contains("" + avoidDigit)) {
				currentNumber++;
			}
			currentNumber++;
		}
		fileWriter.println(currentNumber - 1);
	}

}

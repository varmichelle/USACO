import java.io.*;
import java.util.Scanner;

public class eatpuz {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("eatpuz.in"));
		PrintStream fileWriter = new PrintStream(new File("eatpuz.out"));

		int c = fileReader.nextInt();
		int b = fileReader.nextInt();
		int[] buckets = new int[b];
		for (int i = 0; i < b; i++) {
			buckets[i] = fileReader.nextInt();
		}
		int mostCals = 0;
		int currentCals = 0;
		String tempBinary = "";
		String bZeroes = "";
		for (int i = 0; i < b; i++) {
			bZeroes += "0";
		}
		for (int i = 0; i < Math.pow(2, b); i++) {
			tempBinary = (bZeroes + Integer.toBinaryString(i)).substring(Integer.toBinaryString(i).length());
			for (int j = 0; j < b; j++) {
				if (tempBinary.charAt(j) == '1') {
					currentCals += buckets[j];
				}
			}
			if (currentCals > mostCals && currentCals <= c) {
				mostCals = currentCals;
			}
			currentCals = 0;
		}
		fileWriter.println(mostCals);

	}
}
import java.io.*;
import java.util.Scanner;

public class commas {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("commas.in"));
		PrintStream fileWriter = new PrintStream(new File("commas.out"));
		long n = fileReader.nextLong();
		String number = Long.toString(n);
		char[] digits = number.toCharArray();
		String withCommasReverse = "";
		for (int i = 1; i <= digits.length; i++) {
			if (digits.length >= i) {
				withCommasReverse += digits[digits.length - i];
				if (i % 3 == 0) {
					withCommasReverse += ",";
				}
			}
		}
		char[] withCommas = withCommasReverse.toCharArray();
		for (int i = withCommas.length - 1; i >= 0; i--) {
			if (withCommas[withCommas.length-1] != ',' || i != withCommas.length-1) {
				fileWriter.print(withCommas[i]);
			}
		}
		fileWriter.println();
	}

}

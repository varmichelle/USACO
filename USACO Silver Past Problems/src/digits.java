import java.io.*;
import java.util.Scanner;

public class digits {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("digits.in"));
		PrintStream fileWriter = new PrintStream(new File("digits.out"));
		
		String base2string = fileReader.nextLine();
		String base3string = fileReader.nextLine();
		char[] base2chars = base2string.toCharArray();
		int[] base2ints = new int[base2chars.length];
		for (int i = 0; i < base2chars.length; i++) {
			base2ints[i] = base2chars[i] - 48;
		}
		boolean matchFound = false;
		char[] base3chars = base3string.toCharArray();
		int[] base3ints = new int[base3chars.length];
		for (int i = 0; i < base3chars.length; i++) {
			base3ints[i] = base3chars[i] - 48;
		}
		int tempDigitHolder2 = 0;
		int tempDigitHolder3 = 0;
		int base2to10 = 0;
		int base3to10 = 0;
		// Loop through each possible 1-digit-change of the base 2 number
		for (int i = 0; i < base2ints.length; i++) {
			// store the digit that's about to be changed
			tempDigitHolder2 = base2ints[i];
			// if the digit is currently 0, change it to 1
			// if the digit is currently 1, change it to 0
			base2ints[i] = (base2ints[i]+1) % 2;
			// find the base 10 representation of the changed base 2 number
			for (int z = 0; z < base2ints.length; z++) {
				base2to10 += base2ints[z] * Math.pow(2, base2ints.length-z-1);
			}
			// Loop through each possible 1-digit-change of the base 3 number
			for (int k = 0; k < base3ints.length; k++) {
				if (!matchFound) {
					for (int j = 0; j < 2; j++) {
						if (j == 0) {
							tempDigitHolder3 = base3ints[k];
						}
						base3ints[k] = (base3ints[k]+1) % 3;
						for (int m = 0; m < base3ints.length; m++) {
							base3to10 += base3ints[m] * Math.pow(3, base3ints.length-m-1);
						}
						if (base2to10 == base3to10) {
							fileWriter.println(base3to10);
							matchFound = true;
							break;
						}
						base3to10 = 0;
					}
					base3ints[k] = tempDigitHolder3;
					base2ints[i] = tempDigitHolder2;
				}
			}
			base2to10 = 0;
		}
	}

}


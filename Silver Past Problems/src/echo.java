import java.io.*;
import java.util.Scanner;

public class echo {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("echo.in"));
		PrintStream fileWriter = new PrintStream(new File("echo.out"));

		// Read in input and create character arrays for the moo and the echo
		String moo = fileReader.nextLine();
		String echo = fileReader.nextLine();
		String temp; 
		// Make sure that moo is smaller than echo
		if (moo.length() > echo.length()) {
			temp = moo;
			moo = echo;
			echo = temp;
		}
		int overlap = 0, overlap2 = 0;
		// Starting from the length of the moo and decrementing by 1:
		for (int i = moo.length(); i >= 0; i--) {
			// If the "beginning" of moo equals the "end" of the echo
			if (moo.substring(0, i).equals((echo.substring(echo.length() - i, echo.length() )))) {
				overlap = i;
				break;
			}
		}
		for (int i = moo.length(); i >= 0; i--) {
			// If the "beginning" of moo equals the "end" of the echo
			if (echo.substring(0, i).equals((moo.substring(moo.length() - i, moo.length())))) {
				overlap2 = i;
				break;
			}
		}
		if (overlap2 > overlap) {
			overlap = overlap2;
		}
		fileWriter.println(overlap);

	}
}

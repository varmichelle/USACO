

import java.io.*;
import java.util.*;

public class namenum {
	
	public static void main(String[] args) throws FileNotFoundException {
 
		Scanner scan = new Scanner(new File("namenum.in"));
		PrintStream out = new PrintStream(new File("namenum.out"));
		Scanner dict = new Scanner(new File("dict.txt"));
		
		long serial = scan.nextLong();
		int length = String.valueOf(serial).length();
		String temp;
		boolean equal;
		int count = 0;
		while (dict.hasNextLine()) {
			temp = dict.nextLine();
			equal = true;
			if (temp.length() == length) {
				for (int i = 0; i < length; i++) {
					if (Long.toString(serial).charAt(i) != number(temp.charAt(i))) {
						equal = false;
						break;
					}
				}
				if (equal) {
					out.println(temp);
					count++;
				}
			}
		}
		if (count == 0) out.println("NONE");

	}

	public static char number(char x) {
		if (x == 'A' || x == 'B' || x == 'C') return '2';
		else if (x == 'D' || x == 'E' || x == 'F') return '3';
		else if (x == 'G' || x == 'H' || x == 'I') return '4';
		else if (x == 'J' || x == 'K' || x == 'L') return '5';
		else if (x == 'M' || x == 'N' || x == 'O') return '6';
		else if (x == 'P' || x == 'R' || x == 'S') return '7';
		else if (x == 'T' || x == 'U' || x == 'V') return '8';
		else if (x == 'W' || x == 'X' || x == 'Y') return '9';
		else return '0';
	}

}

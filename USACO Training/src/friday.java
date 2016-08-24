
/* ID: michell26
 LANG: JAVA
 PROG: friday
 */
import java.io.*;
import java.util.Scanner;
public class friday { 
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("friday.in"));
		PrintStream fileWriter = new PrintStream(new File("friday.out"));
		int numYears = fileReader.nextInt();
		int[] occurences13 = new int[7];
		// Saturday = 0, Sunday = 1, Monday = 2, Tuesday = 3,
		// Wednesday = 4, Thursday = 5, Friday = 6
		int begMonth = 2;
		for (int i = 0; i < 7; i++) {
			occurences13[i] = 0;
		}
		int add[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// Saturday is index 0, Sunday is index 1, etc
		for (int currentYear = 1900; currentYear <= 1900 + numYears - 1; currentYear++) {
			if (isLeapYear(currentYear)) add[1] = 29;
			else add[1] = 28;
			for (int i = 0; i < 12; i++) {
				occurences13[(begMonth + 12) % 7]++;
				begMonth = (begMonth + add[i]) % 7;
			}
		}
		for (int i = 0; i < 7; i++) {
			fileWriter.print(occurences13[i]);
			if (i != 6) fileWriter.print(" ");
			else fileWriter.println();
		}
	}

	public static boolean isLeapYear(int year) {
		if ((year % 4) == 0) {
			if ((year % 100) == 0) {
				if ((year % 400) == 0) return true;
				else return false;
			} else return true;
		} else return false;
	}
}
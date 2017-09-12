import java.io.*;
import java.util.Scanner;

public class mathprac {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("mathprac.in"));
		PrintStream fileWriter = new PrintStream(new File("mathprac.out"));
		String input = fileReader.nextLine();
		String[] input1 = input.split(" ");
		long a = Long.parseLong(input1[0]);
		long b = Long.parseLong(input1[1]);
		long power;
		boolean foundNum = false;
		for (long e = a+1; e<63; e++) {
			power = (long) Math.pow(2, e);
			String inputS = "" + power;
			char[] inputArray = inputS.toCharArray();
			if ((inputArray[0] - 48) == b) {
				fileWriter.println(e);
				foundNum = true;
				break;
			}
		}
		if (foundNum == false) {
			fileWriter.println("0");
		}

	}

}

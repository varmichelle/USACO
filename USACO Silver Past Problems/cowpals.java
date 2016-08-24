import java.io.*;
import java.util.Scanner;

public class cowpals {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("cowpals.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("cowpals.out.txt"));
		
		int s = fileReader.nextInt();
		int cow;
		int cow2;
		int factorSum1;
		int factorSum2;
		for (cow = s; cow > 0; cow++) {
			factorSum1 = sumOfFactors(cow);
			cow2 = factorSum1;
			factorSum2 = sumOfFactors(cow2);
			if (cow == factorSum2 && cow != cow2) {
				fileWriter.println(cow + " " + cow2);
				break;
			}
		}
		
	}
	
	public static int sumOfFactors(int serialNumber) {
		int factorSum = 0;
		for (int i = 1; i<serialNumber; i++) {
			if ((serialNumber % i) == 0) {
				factorSum += i;
			}
		}
		return factorSum;
	}

}

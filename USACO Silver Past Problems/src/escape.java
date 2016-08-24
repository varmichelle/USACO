import java.util.Scanner;
import java.io.*;

public class escape {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("escape.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("escape.out.txt"));
		
		int numCows = fileReader.nextInt();
		int[] weights = new int[numCows];
		String[] weightsWithZeroes = new String[numCows];
		int maxLength = 0;
		for (int i = 0; i < numCows; i++) {
			weights[i] = fileReader.nextInt();
			if (("" + weights[i]).length() > maxLength) {
				maxLength = ("" + weights[i]).length();
			}
		}
		int[] digitSums = new int[maxLength];
		String wZeroes = "";
		for (int i = 0; i < maxLength; i++) {
			wZeroes += "0";
		}
		for (int i = 0; i < numCows; i++) {
			weightsWithZeroes[i] = (wZeroes + weights[i]).substring(("" + weights[i]).length());
		}
		String tempBinary = "";
		String bZeroes = "";
		for (int i = 0; i < numCows; i++) {
			bZeroes += "0";
		}
		int maxWeight = 0;
		int bestNumCows = 0;
		for (int i = 0; i < Math.pow(2, numCows); i++) {
			int numCowsCounted = 0;
			for (int m = 0; m < maxLength; m++) {
				digitSums[m] = 0;
			}
			tempBinary = (bZeroes + Integer.toBinaryString(i)).substring(Integer.toBinaryString(i).length());
			int currentWeight = 0;
			for (int j = 0; j < numCows; j++) {
				if (tempBinary.charAt(j) == '1') {
					currentWeight += weights[j];
					numCowsCounted++;
					for (int k = 0; k < maxLength; k++) {
						digitSums[k] += (int) weightsWithZeroes[j].charAt(k) - 48;
					}
				}
			}
			boolean satisfyReq = true;
			for (int l = 0; l < maxLength; l++) {
				if (digitSums[l] > 9) {
					satisfyReq = false;
				}
			}
			if (currentWeight > maxWeight && satisfyReq && numCowsCounted > bestNumCows) {
				maxWeight = currentWeight;
				bestNumCows = numCowsCounted;
			}
		}
		System.out.println(bestNumCows);
	}

}

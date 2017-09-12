import java.io.*;
import java.util.*;

public class bones {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("bones.in"));
		PrintStream fileWriter = new PrintStream(new File("bones.out"));
		int s1 = fileReader.nextInt();
		int s2 = fileReader.nextInt();
		int s3 = fileReader.nextInt();
		int[] numSums = new int[s1 + s2 + s3];
		int[] numSumsSorted = new int[s1 + s2 + s3];
		for (int a = 1; a <= s1; a++) {
			for (int b = 1; b <= s2; b++) {
				for (int c = 1; c <= s3; c++) {
					numSums[a + b + c - 1]++;
					numSumsSorted[a + b + c - 1]++;
				}
			}
		}
		Arrays.sort(numSumsSorted);
		int indexToFind = numSumsSorted[s1+s2+s3-1];
		for (int i = 0; i < numSums.length; i++) {
			if (numSums[i] == indexToFind) {
				fileWriter.println(i+1);
				break;
			}
		}
	}

}

import java.io.*;
import java.util.Scanner;

public class moo {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("moo.in"));
		PrintStream fileWriter = new PrintStream(new File("moo.out"));
		
		long n = fileReader.nextLong();
		long nAligned = n - 1;
		// Create an array of lengths (S(i))
		int[] lengths = new int[1000000];
		// k is the current index of the length being generated (i in S(i))
		int k = 0;
		lengths = generateLengths(n, lengths, k);
		int index = 0;
		// Find the index of the longest length generated
		for (int i = lengths.length - 1; i >= 0; i--) {
			if (lengths[i] != 0) {
				index = i;
				break;
			}
		}
		// Find the character at index n in moo
		findNInMoo(nAligned, lengths, index, fileWriter);
	}

	public static void findNInMoo(long n, int[] lengths, int index, PrintStream fileWriter) {
		if (index == 0) {
			// original string was reduced to the original "moo"
			if (n == 0) {
				fileWriter.println('m');
			} else {
				fileWriter.println('o');
			}
		} else {
			if (n >= lengths[index - 1] && n < lengths[index - 1] + (index + 3)) {
				// The part of the string that n is in is the middle section
				if (n == lengths[index - 1]) {
					fileWriter.println('m');
				} else {
					fileWriter.println('o');
				}
			} else {
				if (n < lengths[index - 1]) {
					// The part of the string that n is in is the first section
					findNInMoo(n, lengths, index - 1, fileWriter);
				} else if (n >= lengths[index - 1] + (index + 3)) {
					// The part of the string that n is in is the third section
					findNInMoo(n - lengths[index - 1] - (index + 3), lengths, index - 1, fileWriter);
				}
			}
		}

	}

	public static int[] generateLengths(long n, int[] lengths, int k) {
		if (k == 0) {
			lengths[0] = 3;
			if (n > lengths[0]) {
				lengths = generateLengths(n, lengths, k + 1);
			}
		} else {
			lengths[k] = (lengths[k - 1] * 2) + (k + 3);
			if (n > lengths[k]) {
				generateLengths(n, lengths, k + 1);
			}
		}
		return lengths;
	}

}

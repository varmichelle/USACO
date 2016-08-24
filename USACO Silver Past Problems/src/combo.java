import java.io.*;
import java.util.*;

public class combo {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("combo.in"));
		PrintStream fileWriter = new PrintStream(new File("combo.out"));

		int n = fileReader.nextInt();
		int[] fjCombo = new int[3];
		int[] mCombo = new int[3];
		for (int i = 0; i < 3; i++) {
			fjCombo[i] = fileReader.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			mCombo[i] = fileReader.nextInt();
		}

		Set combosNoRepeats = new HashSet();
		int currentCombo = 0;
		int digit1 = 0, digit2 = 0, digit3 = 0;
		for (int d1 = fjCombo[0] - 2; d1 < fjCombo[0] + 3; d1++) {
			for (int d2 = fjCombo[1] - 2; d2 < fjCombo[1] + 3; d2++) {
				for (int d3 = fjCombo[2] - 2; d3 < fjCombo[2] + 3; d3++) {
					digit1 = (d1+n) % n;
					if (digit1 == 0) {
						digit1 = n;
					}
					digit2 = (d2+n) % n;
					if (digit2 == 0) {
						digit2 = n;
					}
					digit3 = (d3+n) % n;
					if (digit3 == 0) {
						digit3 = n;
					}
					currentCombo = 100*digit1 + 10*digit2 + digit3;
					combosNoRepeats.add(currentCombo);
				}
			}
		}
		for (int d1 = mCombo[0] - 2; d1 < mCombo[0] + 3; d1++) {
			for (int d2 = mCombo[1] - 2; d2 < mCombo[1] + 3; d2++) {
				for (int d3 = mCombo[2] - 2; d3 < mCombo[2] + 3; d3++) {
					digit1 = (d1+n) % n;
					if (digit1 == 0) {
						digit1 = n;
					}
					digit2 = (d2+n) % n;
					if (digit2 == 0) {
						digit2 = n;
					}
					digit3 = (d3+n) % n;
					if (digit3 == 0) {
						digit3 = n;
					}
					currentCombo = 100*digit1 + 10*digit2 + digit3;
					combosNoRepeats.add(currentCombo);
				}
			}
		}

		fileWriter.println(combosNoRepeats.size());

	}

}

import java.io.*;
import java.util.*;

public class trough2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File("trough.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("trough.out.txt"));
		
		int numT = fileReader.nextInt();
		int numQ = fileReader.nextInt();
		String[][] questions = new String[numQ][2];
		for (int i = 0; i < numQ; i++) {
			questions[i][0] = fileReader.next();
			questions[i][1] = "" + fileReader.nextInt();
		}

		int numCorrect = 0;
		String correct = " ";
		String trough = "";
		int troughsFilled = 0;
		// for each possible combination of troughs filled or not filled
		for (int i = 0; i < Math.pow(2, numT); i++) {
			// generate a binary string to represent troughs being filled or not filled
			for (int k = 0; k < numT - Integer.toBinaryString(i).length(); k++) {
				trough += "0";
			}
			boolean isCorrect = true;
			trough += Integer.toBinaryString(i);
			// for each question
			for (int j = 0; j < numQ; j++) {
				// for each digit in the question
				for (int k = 0; k < numT; k++) {
					// if the trough is considered and it is filled
					if (questions[j][0].charAt(k) == '1' && trough.charAt(k) == '1') troughsFilled++;
				}
				if (troughsFilled != Integer.parseInt(questions[j][1])) {
					troughsFilled = 0;
					isCorrect = false;
					break;
				}
				troughsFilled = 0;
			}
			if (isCorrect) {
				numCorrect++;
				correct = trough;
			}
			trough = "";
		}
		
		if (numCorrect == 0) System.out.println("IMPOSSIBLE");
		else if (numCorrect > 1) System.out.println("NOT UNIQUE");
		else System.out.println(correct);
	
	}
}

import java.util.*;
import java.io.*;

public class trough {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// STRATEGY: Brute force (test all configurations)
		
		Scanner in = new Scanner(new File("trough.in.txt"));
		PrintStream out = new PrintStream(new File("trough.out.txt"));
		int numSolutions = 0;
		String sol = "";
		
		// read input
		int nTroughs = in.nextInt();
		int nQuestions = in.nextInt();
		String[] questions = new String[nQuestions];
		int[] answers = new int[nQuestions];
		for (int i = 0; i < nQuestions; i++) {
			questions[i] = in.next();
			answers[i] = in.nextInt();
		}
		
		// generate all possible configurations
		for (int num = 1; num < Math.pow(2, nTroughs); num++) {
			String map = "00000000000000000000" + Integer.toBinaryString(num);
			map = map.substring(map.length() - nTroughs, map.length());
			for (int i = 0; i < nQuestions; i++) {
				int troughs = 0;
				for (int j = 0; j < nTroughs; j++) {
					if (map.charAt(j) == '1' && questions[i].charAt(j) == '1') troughs++;
				}
				if (troughs != answers[i]) break;
				if (i == nQuestions - 1) {
					numSolutions++;
					sol = map;
					if (numSolutions > 1) {
						System.out.println("NOT UNIQUE");
						System.exit(0);
					}
				}
			}
		}
		if (numSolutions == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(sol);
	}

}

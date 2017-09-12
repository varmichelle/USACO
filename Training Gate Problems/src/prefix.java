/*
ID: michell26
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix {
			
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("prefix.in.txt"));
		PrintStream out = new PrintStream(new File("prefix.out.txt"));
		
		String[] primitives = new String[200];
		int i;
		for (i = 0; i < 200; i++) {
			String input = in.next();
			if (!input.equals(".")) primitives[i] = input;
			else break;
		}
		in.nextLine();
		String sequence = "";
		while (in.hasNextLine()) {
			sequence += in.nextLine();
		}
		String S = sequence;
		int maxLength = 0;
		int currentLength = 0;
		while (true) {
			boolean contains = false;
			int j = 0;
			for (j = 0; j < i; j++) {
				if (S.startsWith(primitives[j])) {
					S = S.substring(primitives[j].length());
					currentLength += primitives[j].length();
					contains = true;
					break;
				}
			}
			System.out.println(sequence.substring(0, sequence.length() - S.length()));
			if (S.length() == sequence.length() && !contains) {
				System.out.println(maxLength);
				System.exit(0);
			}
			if (S.length() < sequence.length() && !contains) {
				maxLength = Math.max(maxLength, currentLength);
				S = sequence;
				currentLength = 0;
			}
		}
		
	}

}

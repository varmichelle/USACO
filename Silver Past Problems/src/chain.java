import java.io.*;
import java.util.*;

public class chain {
	
	static int n;
	static int bestLength = 1000000000;
	static int[] best = new int[1000];

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("chain.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("chain.out.txt"));
		
		n = fileReader.nextInt();
		int[] current = new int[1000];
		int length = 0;
		current[0] = 1;
		generateChain(current, length);
		for (int i = 0; i < 1000; i++) {
			if (best[i] == 0) {
				break;
			} else {
				System.out.print(best[i] + " ");
			}
		}
		System.out.println();
	}

	public static void generateChain(int[] current, int length) {
		length++;
		if (current[length - 1] > n) {
			return;
		} else if (current[length - 1] == n) {
			if (length < bestLength) {
				bestLength = length;
				for (int i = 0; i < length; i++) {
					best[i] = current[i];
				}
			}
			return;
		} else {
			for (int i = 0; i < length; i++) {
				current[length] = current[length - 1] + current[i];
				generateChain(current, length);
			}
		}
	}

}

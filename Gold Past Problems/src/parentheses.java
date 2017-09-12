import java.io.*;
import java.util.*;

public class parentheses {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("parentheses.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("parentheses.out.txt"));

		int n = fileReader.nextInt();
		long mod = 12345678910L;
		long[] current_level_total = new long[n / 2 + 1];
		int current_level = 0;
		for (int i = 0; i < n; i++) {
			if (fileReader.nextInt() == 0) current_level++;
			else {
				if (current_level_total[current_level] == 0) current_level_total[current_level - 1]++;
				else current_level_total[current_level - 1] += current_level_total[current_level] * 2;
				current_level_total[current_level - 1] %= mod;
				current_level_total[current_level--] = 0;
			}
		}
		System.out.println(current_level_total[0] %= mod);

	}
}
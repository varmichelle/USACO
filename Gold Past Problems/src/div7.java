import java.io.*;
import java.util.*;

public class div7 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("div7.in"));
		PrintStream out = new PrintStream(new File("div7.out"));
		
		int N = scan.nextInt();
		int[] ID = new int[N + 1];
		int[] first = new int[7];
		int[] last = new int[7];
		for (int i = 1; i <= N; i++) {
			ID[i] = (scan.nextInt() + ID[i - 1]) % 7;
			if(first[ID[i]] == 0) first[ID[i]] = i;
		}
		for (int i = N - 1; i >= 0; i--) {
			if (last[ID[i]] == 0) last [ID[i]] = i;
		}
		int max_length = 0;
		for (int i = 0; i < 7; i++) {
			max_length = Math.max(max_length, last[i] - first[i]);
		}
		out.println(max_length);
	
	}

}

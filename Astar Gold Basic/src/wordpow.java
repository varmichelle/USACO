import java.util.*;
import java.io.*;

public class wordpow {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("wordpow.in.txt"));
		PrintStream out = new PrintStream(new File("wordpow.out.txt"));
		
		int N = in.nextInt();
		int M = in.nextInt();
		String[] names = new String[N];
		for (int i = 0; i < N; i++) names[i] = in.next();
		String[] goodStrings = new String[M];
		for (int i = 0; i < M; i++) goodStrings[i] = in.next();

	}

}

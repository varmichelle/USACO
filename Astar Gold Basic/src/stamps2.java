import java.util.*;
import java.io.*;

public class stamps2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("stamps2.in.txt"));
		PrintStream out = new PrintStream(new File("stamps2.out.txt"));
		
		int K = in.nextInt();
		int N = in.nextInt();
		int[] stamps = new int[N];
		for (int i = 0; i < N; i++) stamps[i] = in.nextInt();
		
	}

}

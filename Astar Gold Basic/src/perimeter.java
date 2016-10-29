import java.util.*;
import java.io.*;

public class perimeter {

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("perimeter.in.txt"));
		PrintStream out = new PrintStream(new File("perimeter.out.txt"));
		
		// read in input
		int N = in.nextInt();
		int[][] pos = new int[N][2];
		for (int i = 0; i < N; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}

	}

}

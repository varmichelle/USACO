import java.io.*;
import java.util.*;

public class sgraze {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("sgraze.in.txt"));
		PrintStream out = new PrintStream(new File("sgraze.out.txt"));
		
		int N = in.nextInt();
		int[][] pos = new int[N][2];
		for (int i = 0; i < N; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}
		
		
		
	}

}

import java.util.*;
import java.io.*;

public class heights {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("heights.in.txt"));
		PrintStream out = new PrintStream(new File("heights.out.txt"));
		
		int n = in.nextInt();
		int[] numbers = new int[2*n];
		for (int i = 0; i < 2*n; i++) {
			numbers[i] = in.nextInt();
		}
		
		
		
	}

}

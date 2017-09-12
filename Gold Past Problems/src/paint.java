import java.io.*;
import java.util.*;

public class paint {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("paint.in.txt"));
		PrintStream out = new PrintStream(new File("paint.out.txt"));
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int total = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i >= a && i <= b) total++;
			else if (i >= c && i <= d) total++;
		}

		out.println(total - 1);
	}

}

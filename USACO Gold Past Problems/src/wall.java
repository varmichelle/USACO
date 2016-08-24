import java.io.*;
import java.util.*;

public class wall {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("wall.in.txt"));
		PrintStream out = new PrintStream(new File("wall.out.txt"));
		
		int height = scan.nextInt();
		int hh = scan.nextInt();
		int[][] hoofholds = new int[hh][2];
		for (int i = 0; i < hh; i++) {
			// x position
			hoofholds[i][0] = scan.nextInt();
			// y position
			hoofholds[i][1] = scan.nextInt();
		}		
		
	}
	

}

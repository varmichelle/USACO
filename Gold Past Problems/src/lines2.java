import java.io.*;
import java.util.*;

public class lines2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("lines.in.txt"));
		PrintStream out = new PrintStream(new File("lines.out.txt"));
		
		Set<Double> slopes = new HashSet<Double>();
		int num_points = scan.nextInt();
		int[][] points = new int[num_points][2];
		for (int i = 0; i < num_points; i++) {
			points[i][0] = scan.nextInt();
			points[i][1] = scan.nextInt();
		}
		for (int i = 0; i < num_points; i++) {
			for (int j = 0; j < num_points; j++) {
				if (i != j) {
					if (points[i][0] == points[j][0]) slopes.add(2147483647.0);
					else slopes.add(0.0 + (0.0 + points[i][1] - points[j][1])/(0.0 + points[i][0] - points[j][0]));
				} 
			}
		}

		System.out.println(slopes.size());
	}

}

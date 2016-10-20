import java.util.*;
import java.io.*;

public class lines {

	public static void main(String[] args) throws FileNotFoundException {
		
		// read in input
		Scanner in = new Scanner(new File("lines.in.txt"));
		PrintStream out = new PrintStream(new File("lines.out.txt"));
		
		int N = in.nextInt();
		Coord[] points = new Coord[N];
		for (int i = 0; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			points[i] = new Coord(x, y);
		}
		
		// check each pair of points for their slope
		Set<Double> slopes = new HashSet<Double>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (points[i].x == points[j].x) slopes.add(2147483647.0);
				else if (points[i].y == points[j].y) slopes.add(0.0);
				else {
					double y = points[j].y - points[i].y;
					double x = points[j].x - points[i].x;
					double slope = y / x;
					slopes.add(slope);
				}
			}
		}
		int numSlopes = slopes.size();
		System.out.println(numSlopes);

	}

}

class Coord {
	int x, y;
	public Coord(int newX, int newY) {
		x = newX;
		y = newY;
	}
}
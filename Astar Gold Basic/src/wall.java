import java.util.*;
import java.io.*;

public class wall {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("wall.in.txt"));
		PrintStream out = new PrintStream(new File("wall.out.txt"));
		
		// read input
		int H = in.nextInt();
		int F = in.nextInt();
		Coordinate[] footholds = new Coordinate[F];
		for (int i = 0; i < F; i++) {
			Coordinate c = new Coordinate(in.nextInt(), in.nextInt());
		}
		
		
		
	}
	
	// checks if the two coordinates are within 1 meter apart
	public static boolean isWithinDistance(Coordinate a, Coordinate b) {
		// 1000000 mm^2 = 1 m^2
		if (Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2)) <= 1000000) return true;
		return false;
	}

}

class Coordinate {
	int x, y;
	Coordinate(int a, int b) {
		x = a;
		y = b;
	}
}
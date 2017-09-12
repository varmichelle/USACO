import java.util.*;

import javax.management.Query;

import java.io.*;

public class perimeter {

	static int N, perimeter = 0, min_x, min_y, max_x = 0, max_y = 0;
	static Set<Coordinate> haybales = new HashSet<Coordinate>();
	static Set<Coordinate> visited = new HashSet<Coordinate>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("perimeter.in.txt"));
		PrintStream out = new PrintStream(new File("perimeter.out.txt"));
		
		// read in input
		N = in.nextInt();
		min_x = 999999999;
		min_y = 999999999;
		int start_x = 0, start_y = 0;
		for (int i = 0; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			haybales.add(new Coordinate(x,y));
			max_x = Math.max(max_x, x);
			min_x = Math.min(min_x, x);
			max_y = Math.max(max_y, y);
			min_y = Math.min(min_y, y);
			if (x >= start_x) {
				start_x = x;
				start_y = y;
			}
		}
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		q.add(new Coordinate(start_x+1, start_y));
		while (!q.isEmpty()) {
			Coordinate c = q.remove();
			if (isolated(c.x, c.y)) continue;
			// if haybale, increment perimeter
			if (haybales.contains(c)) {
				perimeter++;
				continue;
			}
			if (visited.contains(new Coordinate(c.x-min_x, c.y-min_y))) continue;
			visited.add(new Coordinate(c.x-min_x, c.y-min_y));
			q.add(new Coordinate(c.x+1,c.y));
			q.add(new Coordinate(c.x-1,c.y));
			q.add(new Coordinate(c.x,c.y+1));
			q.add(new Coordinate(c.x,c.y-1));
		}
		System.out.println(perimeter);

	}
	
	static boolean isolated(int x, int y) {
		// check if any of the 8 neighbors are haybales
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (haybales.contains(new Coordinate(x+i, y+j))) return false;
			}
		}
		return true;
	}
}

class Coordinate {
	int x, y;
	public Coordinate(int a, int b) {
		x = a;
		y = b;
	}
	
	@Override
	public int hashCode() {
		return x + y;
	}
	
	@Override
	public boolean equals(Object a) {
		Coordinate b = (Coordinate) a;
		if (this.x == b.x && this.y == b.y) return true;
		else return false;
	}
}

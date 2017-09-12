import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.*;

public class space3d {

	static char[][][] space;
	static int x, y, z;
	static PrintStream fileWriter;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("space3d.in"));
		fileWriter = new PrintStream(new File("space3d.out"));
		x = fileReader.nextInt();
		y = x;
		z = x;
		space = new char[x][y][z];
		String calibrate = fileReader.nextLine();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				String temp = fileReader.nextLine();
				for (int k = 0; k < z; k++) {
					space[i][j][k] = temp.charAt(k);
				}
			}
		}
		int numAsteroids = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++) {
					if (space[i][j][k] == '*') {
						floodfillBFS(i, j, k);
						numAsteroids++;
					}
				}
			}
		}

		fileWriter.println(numAsteroids);

	}

	public static void floodfillBFS(int x1, int y1, int z1) {
		Queue<Integer> x_coord = new LinkedList<Integer>();
		Queue<Integer> y_coord = new LinkedList<Integer>();
		Queue<Integer> z_coord = new LinkedList<Integer>();
		x_coord.add(x1);
		y_coord.add(y1);
		z_coord.add(z1);
		while (!x_coord.isEmpty()) {
			x1 = x_coord.peek();
			x_coord.remove();
			y1 = y_coord.peek();
			y_coord.remove();
			z1 = z_coord.peek();
			z_coord.remove();
			// Check left
			if (x1 > 0  && x1 < x) {
				if (space[x1 - 1][y1][z1] == '*') {
					space[x1 - 1][y1][z1] = 'f';
					x_coord.add(x1 - 1);
					y_coord.add(y1);
					z_coord.add(z1);
				}
			}
			// check right
			if (x1 < x - 1 && x1 >= 0) {
				if (space[x1 + 1][y1][z1] == '*') {
					space[x1 + 1][y1][z1] = 'f';
					x_coord.add(x1 + 1);
					y_coord.add(y1);
					z_coord.add(z1);
				}
			}
			// check forward
			if (y1 > 0 && y1 < y) {
				if (space[x1][y1 - 1][z1] == '*') {
					space[x1][y1 - 1][z1] = 'f';
					x_coord.add(x1);
					y_coord.add(y1 - 1);
					z_coord.add(z1);
				}
			}
			// check backward
			if (y1 < y - 1 && y1 >= 0) {
				if (space[x1][y1 + 1][z1] == '*') {
					space[x1][y1 + 1][z1] = 'f';
					x_coord.add(x1);
					y_coord.add(y1 + 1);
					z_coord.add(z1);
				}
			}
			// check down
			if (z1 < z - 1 && z1 >= 0) {
				if (space[x1][y1][z1 + 1] == '*') {
					space[x1][y1][z1 + 1] = 'f';
					x_coord.add(x1);
					y_coord.add(y1);
					z_coord.add(z1 + 1);
				}
			}
			// check up
			if (z1 > 0 && 1 < z) {
				if (space[x1][y1][z1 - 1] == '*') {
					space[x1][y1][z1 - 1] = 'f';
					x_coord.add(x1);
					y_coord.add(y1);
					z_coord.add(z1 - 1);
				}
			}
		}
	}

}

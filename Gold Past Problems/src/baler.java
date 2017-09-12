import java.io.*;
import java.util.*;

public class baler {

	static int N, powerIndex;
	static Roller[] rollers;
	static int[][] matrix;
	static boolean[] visited, used;
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("baler.in.txt"));
		PrintStream out = new PrintStream(new File("baler.out.txt"));
		
		// read inputs
		N = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int startIndex = 0;
		rollers = new Roller[N];
		for (int i = 0; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();
			if (x == px && y == py) powerIndex = i;
			if (x == 0 && y == 0) startIndex = i;
			rollers[i] = new Roller(x, y, r);
		}
		
		// create an adjacency matrix
		matrix = new int[N][N];
		visited = new boolean[N];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				// if the distance between the centers of 2 rollers equals the sum of their radii
				// then they are connected
				if (Math.pow(rollers[i].x - rollers[j].x, 2) + Math.pow(rollers[i].y - rollers[j].y, 2) == Math.pow(rollers[i].r + rollers[j].r, 2)) {
					matrix[i][j] = 1;
				}
			}
			visited[i] = false;
		}
		
		// dfs to find the path from the driver to the power takeoff
		dfs(startIndex);
		
		// calculate speed
		int prevR = rollers[startIndex].r;
		double prevSpeed = 10000;
		double speed = prevSpeed;
		while (!stack.isEmpty()) {
			int currentIndex = stack.pop();
			int currentR = rollers[currentIndex].r;
			double currentSpeed = prevSpeed * prevR / (double) currentR;
			speed += currentSpeed;
			prevR = currentR;
			prevSpeed = currentSpeed;
		}
		System.out.println((int) speed); 

	}

	public static boolean dfs(int index) {
		visited[index] = true;
		// if reached end
		if (index == powerIndex) {
			return true;
		} else {
			// check all neighbors
			for (int i = 0; i < N; i++) {
				if (!visited[i] && matrix[i][index] == 1) {
					if (dfs(i)) {
						stack.push(i);
						return true;
					}
				}
			}
			return false;
		}
	}

}

class Roller {
	int x, y, r;
	public Roller(int newX, int newY, int newR) {
		x = newX;
		y = newY;
		r = newR;
	}
}
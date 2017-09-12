import java.io.*;
import java.util.*;

public class gravity2 {

	static int m, n, start_x, start_y, end_x, end_y;
	static char[][] field;
	static int[][] mark;
	static int[][] visited;

	public static void main(String[] args) throws FileNotFoundException {
						
		Scanner fileReader = new Scanner(new File("gravity.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("gravity.out.txt"));
		
		m = fileReader.nextInt();
		n = fileReader.nextInt();
		field = new char[n][m];
		mark = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < m; i++) {
			String temp = fileReader.next();
			for (int j = 0; j < n; j++) {
				mark[j][i] = -1;
				field[j][i] = temp.charAt(j);
				if (field[j][i] == 'C') {
					start_x = j;
					start_y = i;
				} else if (field[j][i] == 'D') {
					end_x = j;
					end_y = i;
				}
			}
		}
		// recurse(start_x, start_y, 1, 0);
		// System.out.println(-1);
		
		bfs();
	}
	
	public static void recurse(int x, int y, int gravity, int numFlips) {
		visited[x][y]++;
		if (mark[end_x][end_y] != -1) {
			System.out.println(Math.min(mark[end_x][end_y], numFlips));
			System.exit(0);
		}
		mark[x][y] = numFlips;
		if (gravity == 1 && y == m - 1) return;
		if (gravity == -1 && y == 0) return;
		if (y + gravity > -1 && y + gravity < m && field[x][y + gravity] != '#' && visited[x][y + gravity] < 2) {
			recurse(x, y + gravity, gravity, numFlips);
		} else {
			if (x > 0 && field[x - 1][y] != '#' && visited[x - 1][y] < 2) recurse(x - 1, y, gravity, numFlips);
			if (x < n - 1 && field[x + 1][y] != '#' && visited[x + 1][y] < 2) recurse(x + 1, y, gravity, numFlips);
			if (y - gravity > -1 && y - gravity < m && field[x][y - gravity] != '#' && visited[x][y - gravity] < 2) {
				gravity *= -1;
				recurse(x, y + gravity, gravity, numFlips + 1);
			}
		}
	}
	
	public static void bfs() {
		
	}
}

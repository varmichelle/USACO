import java.io.*;
import java.util.*;

public class dream {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int num_rows, num_cols, min = 999999999;
	static int[][] grid, dir;
	static PrintStream out;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("dream.in.txt"));
		out = new PrintStream(new File("dream.out.txt"));
		
		num_rows = scan.nextInt();
		num_cols = scan.nextInt();
		grid = new int[num_rows][num_cols];
		dir = new int[num_rows][num_cols];
		for (int i = 0; i < num_rows; i++) {
			for (int j = 0; j < num_cols; j++) {
				grid[i][j] = scan.nextInt();
				dir[i][j] = -1;
			}
		}
	
		// traverse(0,0,-2,0, false);
		// traverse(0,0,-2,0, false);
		// floodfillBFS(0,0,-2,0,false);
		if (min != 999999999) System.out.println(min);
		else System.out.println(-1);
		
	}
	
	public static void traverse(int row, int col, int direction_came_from, int num_moves, boolean smell) {
		dir[row][col] = direction_came_from;
		if (row == num_rows - 1 && col == num_cols - 1) {
			min = Math.min(min, num_moves);
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (row + dy[i] >= 0 && row + dy[i] < num_rows && col + dx[i] >= 0 && col + dx[i] < num_cols && dir[row + dy[i]][col + dx[i]] != i) {
						if (grid[row + dy[i]][col + dx[i]] == 1) traverse(row + dy[i], col + dx[i], i, num_moves + 1, false);
						else if (grid[row + dy[i]][col + dx[i]] == 2) traverse(row + dy[i], col + dx[i], i, num_moves + 1, true);
						else if (grid[row + dy[i]][col + dx[i]] == 3 && smell) traverse(row + dy[i], col + dx[i], i, num_moves + 1, true);
						else if (grid[row + dy[i]][col + dx[i]] == 4) traverse(row + dy[i], col + dx[i], i, num_moves + 1, false);
					}
				}
			}
		}
	}
	
	public static int floodfillBFS(int row, int col, int direction_came_from, int num_moves, boolean smell) {
		Queue<Integer> row_q = new LinkedList<Integer>();
		Queue<Integer> col_q = new LinkedList<Integer>();
		Queue<Integer> direction_q = new LinkedList<Integer>();
		Queue<Integer> moves_q = new LinkedList<Integer>();
		Queue<Boolean> smell_q = new LinkedList<Boolean>();
		do {
			dir[row][col] = direction_came_from;
			if (row == num_rows - 1 && col == num_cols - 1) {
				min = Math.min(min, num_moves);
			} else {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (row + dy[i] >= 0 && row + dy[i] < num_rows && col + dx[i] >= 0 && col + dx[i] < num_cols && dir[row + dy[i]][col + dx[i]] != i) {
							if (grid[row + dy[i]][col + dx[i]] == 1) {
								row_q.add(row+dy[i]);
								col_q.add(col + dx[i]);
								moves_q.add(num_moves + 1);
								smell_q.add(false);
								direction_q.add(i);
							}
							else if (grid[row + dy[i]][col + dx[i]] == 2) {
								row_q.add(row+dy[i]);
								col_q.add(col + dx[i]);
								moves_q.add(num_moves + 1);
								smell_q.add(true);
								direction_q.add(i);
							}
							else if (grid[row + dy[i]][col + dx[i]] == 3 && smell) {
								row_q.add(row+dy[i]);
								col_q.add(col + dx[i]);
								moves_q.add(num_moves + 1);
								smell_q.add(true);
								direction_q.add(i);
							}
							else if (grid[row + dy[i]][col + dx[i]] == 4) {
								row_q.add(row+dy[i]);
								col_q.add(col + dx[i]);
								moves_q.add(num_moves + 1);
								smell_q.add(false);
								direction_q.add(i);
							}
						}
					}
				}
			}
			row = row_q.peek();
			row_q.remove();
			col = col_q.peek();
			col_q.remove();
			smell = smell_q.peek();
			smell_q.remove();
			num_moves = moves_q.peek();
			moves_q.remove();
			direction_came_from = direction_q.peek();
			direction_q.remove();
			
		} while (!row_q.isEmpty());
		return 0;
	}

}

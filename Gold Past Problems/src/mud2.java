import java.io.*;
import java.util.*;

public class mud2 {

	static int finish_x, finish_y;
	static int[][] field;
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("mud.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("mud.out.txt"));
		finish_x = fileReader.nextInt() + 510;
		finish_y = fileReader.nextInt() + 510;
		int numPuddles = fileReader.nextInt();
		field = new int[1020][1020];
		for (int i = 0; i < numPuddles; i++) {
			field[fileReader.nextInt() + 510][fileReader.nextInt() + 510] = -1;
		}
		fileWriter.println(floodfillBFS(510, 510, 0));
	}

	public static int floodfillBFS(int current_x, int current_y, int index) {
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		Queue<Integer> indexes = new LinkedList<Integer>();
		do {
			for (int i = 0; i < 4; i++) {
				if (current_x + dx[i] >= 0 && current_x + dx[i] < 1020 && current_y + dy[i] >= 0
						&& current_y + dy[i] < 1020) {
					if (field[current_x + dx[i]][current_y + dy[i]] == 0) {
						field[current_x + dx[i]][current_y + dy[i]] = index + 1;
						x.add(current_x + dx[i]);
						y.add(current_y + dy[i]);
						indexes.add(index + 1);
					}
				}
			}
			current_y = y.peek();
			y.remove();
			current_x = x.peek();
			x.remove();
			index = indexes.peek();
			indexes.remove();
			if (current_y == finish_y && current_x == finish_x)
				return index;
		} while (!y.isEmpty());
		return 0;
	}
}

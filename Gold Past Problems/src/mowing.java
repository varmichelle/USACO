import java.io.*;
import java.util.*;

public class mowing {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("mowing.in"));
		PrintStream out = new PrintStream(new File("mowing.out"));

		int N = scan.nextInt();
		int[][] commands = new int[N][2];
		for (int i = 0; i < N; i++) {
			String temp = scan.next();
			if (temp.equals("N")) commands[i][0] = 1;
			else if (temp.equals("S")) commands[i][0] = 2;
			else if (temp.equals("E")) commands[i][0] = 3;
			else if (temp.equals("W")) commands[i][0] = 4;
			commands[i][1] = scan.nextInt();
		}
		int[][] times = new int[2000][2000];
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				times[i][j] = -1;
			}
		}
		int x = 1000000000;
		int time = 0;
		int current_x = 1000;
		int current_y = 1000;
		times[1000][1000] = time;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= commands[i][1]; j++) {
				time++;
				if (commands[i][0] == 1) current_y--;
				else if (commands[i][0] == 2) current_y++;
				else if (commands[i][0] == 3) current_x--;
				else if (commands[i][0] == 4) current_x++;
				if (times[current_x][current_y] != -1) x = Math.min(x, time - times[current_x][current_y]);
				times[current_x][current_y] = time;
			}
		}
		if (x != 1000000000) out.println(x);
		else out.println(-1);
	}
}

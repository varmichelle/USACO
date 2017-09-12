import java.io.*;
import java.util.*;

public class lightson {
	
	static int num_light_switches, n, num_on = 0;
	static int[][] light_switches;
	static boolean[][] lights_on, visited;
	static boolean light_switch = false;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("lightson.in"));
		PrintStream out = new PrintStream(new File("lightson.out"));
		
		n = scan.nextInt();
		num_light_switches = scan.nextInt();
		light_switches = new int[num_light_switches][4];
		for (int i = 0; i < num_light_switches; i++) {
			// x-coordinate of switch location
			light_switches[i][0] = scan.nextInt();
			// y-coordinate of switch location
			light_switches[i][1] = scan.nextInt();
			// x-coordinate of light location
			light_switches[i][2] = scan.nextInt();
			// y-coordinate of light location
			light_switches[i][3] = scan.nextInt();
		}
		lights_on = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		lights_on[1][1] = true;
		do {
			light_switch = false;
			turn_on(1, 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i+1][j+1] = false;
				}
			}
		} while (light_switch);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (lights_on[i+1][j+1]) num_on++;
			}
		}

		out.println(num_on);
		
	}
	
	public static void turn_on(int x, int y) {
		visited[x][y] = true;
		// turn on all light switches in current room
		for (int i = 0; i < num_light_switches; i++) {
			if (light_switches[i][0] == x && light_switches[i][1] == y) {
				lights_on[light_switches[i][2]][light_switches[i][3]] = true;
				light_switches[i][0] = 0;
				light_switch = true;
			}
		}
		// move to unvisited lit neighbors
		// up
		if (y > 1 && lights_on[x][y-1] && !visited[x][y-1]) turn_on(x, y-1);
		// left
		if (x > 1 && lights_on[x - 1][y] && !visited[x-1][y]) turn_on(x - 1, y);
		// down
		if (y < n && lights_on[x][y+1] && !visited[x][y+1]) turn_on(x, y+1);
		// right
		if (x < n && lights_on[x + 1][y] && !visited[x+1][y]) turn_on(x + 1, y);
	}

}


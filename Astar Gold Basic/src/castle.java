import java.io.*;
import java.util.*;

public class castle {
	
	static int W, H, largestRoomSize = 0;
	static int[][] castle, floodfill;
	static int[] roomSizes;

	public static void main(String[] args) throws FileNotFoundException {
		
		/**
		 * General solution: Floodfill each room with a different number
		 * To find size of largest room by removing a way, loop through each wall
		 * and "look over it" to check if the two cells are different rooms 
		 * if so, add them and find the max at the end
		 */
		
		// read input
		Scanner in = new Scanner(new File("castle.in.txt"));
		PrintStream out = new PrintStream(new File("castle.out.txt"));
		W = in.nextInt();
		H = in.nextInt();
		castle = new int[W][H];
		floodfill = new int[W][H];
		roomSizes = new int[100000];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				castle[j][i] = in.nextInt();
			}
		}
		
		// floodfill
		int nRooms = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (floodfill[j][i] == 0) {
					floodfill(j, i, nRooms + 1);
					nRooms++;
				}
			}
		}
		
		System.out.println(nRooms);
		System.out.println(largestRoomSize);
		int bestSum = 0;
		// check all vertical walls
		for (int x = 0; x < W; x++) {
			for (int y = 0; y < H - 1; y++) {
				int wall = castle[x][y];
				if (wall >= 8) {
					if (floodfill[x][y] != floodfill[x][y+1]) {
					int currentSum = roomSizes[floodfill[x][y]-1] + roomSizes[floodfill[x][y+1]-1];
						bestSum = Math.max(bestSum, currentSum);
					}
				}
			}
		}
		// check all horizontal walls
		for (int x = 0; x < W - 1; x++) {
			for (int y = 0; y < H; y++) {
				int wall = castle[x][y];
				if (wall >= 8) wall -= 8;
				if (wall >= 4) {
					if (floodfill[x][y] != floodfill[x + 1][y]) {
						int currentSum = roomSizes[floodfill[x][y]-1] + roomSizes[floodfill[x+1][y]-1];
						bestSum = Math.max(bestSum, currentSum);
					}
				}
			}
		}
		System.out.println(bestSum);

	}

	public static void floodfill(int x, int y, int roomNumber) {
		int currentRoomSize = 0;
		Queue<point> q = new LinkedList<point>();
		q.add(new point(x,y));
		while (!q.isEmpty()) {
			point current = q.remove();
			if (floodfill[current.x][current.y] == 0) currentRoomSize++;
			floodfill[current.x][current.y] = roomNumber;
			String wall = "0000" + Integer.toBinaryString(castle[current.x][current.y]);
			wall = wall.substring(wall.length() - 4, wall.length());
			// check left
			if (current.x > 0 && wall.charAt(3) == '0' && floodfill[current.x-1][current.y] == 0) {
				q.add(new point(current.x - 1, current.y));
			}
			// check up
			if (current.y > 0 && wall.charAt(2) == '0' && floodfill[current.x][current.y-1] == 0) {
				q.add(new point(current.x, current.y - 1));
			}
			// check right
			if (current.x < W - 1 && wall.charAt(1) == '0' && floodfill[current.x+1][current.y] == 0) {
				q.add(new point(current.x + 1, current.y));
			}
			// check down
			if (current.y < H - 1 && wall.charAt(0) == '0' && floodfill[current.x][current.y+1] == 0) {
				q.add(new point(current.x, current.y + 1));
			}
			
		}
		largestRoomSize = Math.max(largestRoomSize, currentRoomSize);
		roomSizes[roomNumber - 1] = currentRoomSize;
	}

}

class point {
	int x, y;
	point(int a, int b) {
		x = a;
		y = b;
	}
}

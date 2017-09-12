/*
ID: michell26
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.Scanner;

public class castle2 {

	static int numRooms = 0, largestRoomSize = 0, m, n, charIndex, current;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] floodfill;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("castle.in"));
		PrintStream fileWriter = new PrintStream(new File("castle.out"));
		m = fileReader.nextInt();
		n = fileReader.nextInt();
		int[][] castle = new int[m][n];
		String[][] binary = new String[m][n];
		boolean[][] visited = new boolean[m][n];
		floodfill = new int[m][n];
		int[] numModules = new int[1000];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				castle[j][i] = fileReader.nextInt();
				binary[j][i] = String.format("%4s", Integer.toBinaryString(castle[j][i])).replace(" ", "0");
				visited[j][i] = false;
			}
		}
		for (int a = 0; a < m; a++) {
			for (int b = 0; b < n; b++) {
				if (!visited[a][b]) {
					numRooms++;
					recurse(binary, a, b, visited);
					numModules[numRooms] = current + 1;
					if (current > largestRoomSize) largestRoomSize = current;
					current = 0;
				}
			}
		}
		fileWriter.println(numRooms);
		fileWriter.println(largestRoomSize + 1);
		int removeWallSum = 0;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				for (int k = 0; k < 4; k++) {
					if ((x + dx[k] > -1) && (x + dx[k] < m) && (y + dy[k] > -1) && (y + dy[k] < n)) {
						if (floodfill[x + dx[k]][y + dy[k]] != floodfill[x][y]) {
							if (numModules[floodfill[x + dx[k]][y + dy[k]]] + numModules[floodfill[x][y]] > removeWallSum) {
								removeWallSum = numModules[floodfill[x + dx[k]][y + dy[k]]] + numModules[floodfill[x][y]];
							}
						}
					}
				}
			}
		}
		fileWriter.println(removeWallSum);
	}

	public static void recurse(String[][] binary, int i, int j, boolean[][] visited) {
		if (!visited[i][j]) {
			floodfill[i][j] = numRooms;
			visited[i][j] = true;
			// Loop through all 4 directions
			for (int k = 0; k < 4; k++) {
				if ((i + dx[k] > -1) && (i + dx[k] < m) && (j + dy[k] > -1) && (j + dy[k] < n)) {
					if (k == 0) charIndex = 2;
					else if (k == 1) charIndex = 0;
					else if (k == 2) charIndex = 3;
					else if (k == 3) charIndex = 1;
					if (binary[i][j].charAt(charIndex) == '0' && !visited[i + dx[k]][j + dy[k]]) {
						current++;
						recurse(binary, i + dx[k], j + dy[k], visited);
					}
				}
			}
		}
	}
}

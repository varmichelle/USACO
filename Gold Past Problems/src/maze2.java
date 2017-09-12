import java.io.*;
import java.util.*;

public class maze2 {

	static int width, height;
	static int[][] mazeFill;
	static char[][] maze;
	static Queue<Integer> xPos, yPos, distances;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("maze1.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("maze1.out.txt"));

		width = fileReader.nextInt();
		height = fileReader.nextInt();
		maze = new char[width * 2 + 1][height * 2 + 1];
		mazeFill = new int[width][height];
		// Calibrate input
		fileReader.nextLine();
		for (int y = 0; y < 2 * height + 1; y++) {
			String temp = fileReader.nextLine();
			// Add 38 spaces as padding
			temp += "                                      ";
			for (int x = 0; x < 2 * width + 1; x++) {
				maze[x][y] = temp.charAt(x);
			}
		}

		// Set up queues for BFS
		xPos = new LinkedList<Integer>();
		yPos = new LinkedList<Integer>();
		distances = new LinkedList<Integer>();

		// Find the exits
		for (int i = 1; i < width * 2 + 1; i += 2) {
			if (maze[i][0] == ' ') {
				xPos.add((i - 1) / 2);
				yPos.add(0);
				distances.add(1);
			}
			if (maze[i][height * 2] == ' ') {
				xPos.add((i - 1) / 2);
				yPos.add(height - 1);
				distances.add(1);
			}
		}
		for (int i = 1; i < height * 2; i += 2) {
			if (maze[0][i] == ' ') {
				xPos.add(0);
				yPos.add((i - 1) / 2);
				distances.add(1);
			}
			if (maze[width * 2][i] == ' ') {
				xPos.add(width - 1);
				yPos.add((i - 1) / 2);
				distances.add(1);
			}
		}

		fileWriter.println(floodfill());

	}

	public static int floodfill() {

		int numFilled = 0;

		while (!xPos.isEmpty()) {
			// Mark the current module in the maze with its distance from the
			// nearest exit
			if (mazeFill[xPos.peek()][yPos.peek()] == 0) {
				mazeFill[xPos.peek()][yPos.peek()] = distances.peek();
				numFilled++;
				//System.out.println(numFilled + " " + distances.peek());
				if (numFilled == width * height) {
					return distances.peek();
				}

				// Check left:
				// If the module to the left of the current square is in bounds
				if (xPos.peek() > 0) {
					// If there is no wall, add x, y, distance to respective
					// queues
					if (maze[xPos.peek() * 2][yPos.peek() * 2 + 1] == ' ') {
						xPos.add(xPos.peek() - 1);
						yPos.add(yPos.peek());
						distances.add(distances.peek() + 1);
					}
				}
				// Check right
				if (xPos.peek() < width - 1) {
					if (maze[xPos.peek() * 2 + 2][yPos.peek() * 2 + 1] == ' ') {
						xPos.add(xPos.peek() + 1);
						yPos.add(yPos.peek());
						distances.add(distances.peek() + 1);
					}
				}
				// Check up
				if (yPos.peek() > 0) {
					if (maze[xPos.peek() * 2 + 1][yPos.peek() * 2] == ' ') {
						xPos.add(xPos.peek());
						yPos.add(yPos.peek() - 1);
						distances.add(distances.peek() + 1);
					}
				}
				// Check down
				if (yPos.peek() < height - 1) {
					if (maze[xPos.peek() * 2 + 1][yPos.peek() * 2 + 2] == ' ') {
						xPos.add(xPos.peek());
						yPos.add(yPos.peek() + 1);
						distances.add(distances.peek() + 1);
					}
				}

			}
			xPos.remove();
			yPos.remove();
			distances.remove();
		}
		return 0;

	}
}

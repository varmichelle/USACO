import java.io.*;
import java.util.Scanner;

public class racing {

	public static void main(String[] args) throws FileNotFoundException {

		// Setting up file IO:
		Scanner fileReader = new Scanner(new File("racing.in"));
		PrintStream fileWriter = new PrintStream(new File("racing.out"));

		int m = fileReader.nextInt();
		int t = fileReader.nextInt();
		int u = fileReader.nextInt();
		int f = fileReader.nextInt();
		int d = fileReader.nextInt();
		char[] terrain = new char[t];
		for (int i = 0; i < t; i++) {
			terrain[i] = fileReader.next().charAt(0);
		}
		int time = 0;
		int bestTime = 0;
		int bestDistance = 0;

		// For each possible terrain distance: 
		for (int i = 0; i < t; i++) {
		// For each segment of the terrain
			time += addTime(i, terrain, f, u, d);
			if (time > bestTime && time <= m) {
				bestTime = time;
				bestDistance = i;
			}
			if (time > m) {
				break;
			}
		}
		fileWriter.println(bestDistance + 1); 
	} 
	
	public static int addTime(int j, char[] terrain, int f, int u, int d) {
		// Calculates the sum of going forward and backward through that segment
		if (terrain[j] == 'u' || terrain[j] == 'd') {
			return u+d;
		} else if (terrain[j] == 'f') {
			return 2*f;
		}
		return 0;
	} 

}

import java.io.*;
import java.util.*;

public class cruise2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// This solution passes 5/6 test cases, times out on the last one

		Scanner fileReader = new Scanner(new File("cruise.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("cruise.out.txt"));
		
		int numPorts = fileReader.nextInt();
		int numDirections = fileReader.nextInt();
		int numRepetitions = fileReader.nextInt();
		int[][] neighbors = new int[numPorts][numPorts];
		for (int i = 0; i < numPorts; i++) {
			neighbors[i][0] = fileReader.nextInt() - 1;
			neighbors[i][1] = fileReader.nextInt() - 1;
		}
		String[] commands = new String[numDirections];
		for (int i = 0; i < numDirections; i++) {
			commands[i] = fileReader.next();
		}
		int current = 0;
		for (int i = 0; i < numRepetitions; i++) {
			for (int j = 0; j < numDirections; j++) {
				if (commands[j].equals("L")) current = neighbors[current][0];
				else current = neighbors[current][1];
			}
		}
		fileWriter.println(current + 1);
		
	}
}

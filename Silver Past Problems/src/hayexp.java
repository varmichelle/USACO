import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class hayexp {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("hayexp.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("hayexp.out.txt"));
		
		// Read in the input
		int numDays = fileReader.nextInt();
		int numQueries = fileReader.nextInt();
		int[] hay = new int[numDays];
		for (int i = 0; i < numDays; i++) {
			hay[i] = fileReader.nextInt();
		}

		int tempSum = 0;
		int[] queriesStart = new int[numQueries];
		int[] queriesEnd = new int[numQueries];
		for (int i = 0; i < numQueries; i++) {
			queriesStart[i] = fileReader.nextInt();
			queriesEnd[i] = fileReader.nextInt();
			for (int j = queriesStart[i] - 1; j < queriesEnd[i]; j++) {
				tempSum += hay[j];
			}
			fileWriter.println(tempSum);
			tempSum = 0;
		}

	}
}

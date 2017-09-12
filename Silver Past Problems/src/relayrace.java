import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class relayrace {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("relayrace.in"));
		PrintStream fileWriter = new PrintStream(new File("relayrace.out"));

		int n = fileReader.nextInt();
		int[] lapTimes = new int[n];
		int[] numSignals = new int[n];
		int[][] signaledCows = new int[n][n];
		int[] finishTimes = new int[n];
		for (int i = 0; i < n; i++) {
			lapTimes[i] = fileReader.nextInt();
			numSignals[i] = fileReader.nextInt();
			for (int k = 0; k < numSignals[i]; k++) {
				signaledCows[i][k] = fileReader.nextInt();
			}
		}
		boolean finished = false;
		int time = 0;
		finishTimes[0] = lapTimes[0];
		while (!finished) {
			int numCowsFinished = 0;
			int nextTime = 1000000;
			for (int i = 0; i < n; i++) {
				if (finishTimes[i] > time && finishTimes[i] < nextTime) {
					nextTime = finishTimes[i];
				}
			}
			time=nextTime;
			for (int i = 0; i < n; i++) {
				if (finishTimes[i] == time) {
					if (numSignals[i] != 0) {
						for (int j = 0; j < numSignals[i]; j++) {
							if (finishTimes[signaledCows[i][j] - 1] == 0) {
								finishTimes[signaledCows[i][j] - 1] = time + lapTimes[signaledCows[i][j] - 1];
							}
						}
					}
				}
				if (finishTimes[i] != 0) {
					numCowsFinished++;
				}
			}
			if (numCowsFinished == n) {
				finished = true;
			}
		}
		int longestTime = 0;
		for (int i = 0; i < n; i++) {
			if (finishTimes[i] > longestTime) {
				longestTime = finishTimes[i];
			}
		}
		fileWriter.println(longestTime);

	}

}

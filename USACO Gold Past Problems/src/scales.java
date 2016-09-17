import java.io.*;
import java.util.*;

public class scales {

	static int numWeights, maxWeight, max = 0;
	static int[] weights;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("scales.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("scales.out.txt"));

		numWeights = fileReader.nextInt();
		maxWeight = fileReader.nextInt();
		weights = new int[numWeights];
		for (int i = 0; i < numWeights; i++) {
			weights[i] = fileReader.nextInt();
		}

		recurse(0, numWeights - 1);
		fileWriter.println(max);

	}

	public static void recurse(int currentMax, int index) {
		if (index > 0 && weights[index] + weights[index - 1] + currentMax <= maxWeight) {
			recurse(currentMax + weights[index], index - 1);
		} else if (index > 0 && weights[index] + currentMax <= maxWeight && maxWeight < weights[index - 1] + weights[index] + currentMax) {
			if (index > 1) {
				recurse(currentMax + weights[index], index - 2);
				recurse(currentMax + weights[index - 1], index - 2);
			}
		} else if (index > 0 && weights[index] + currentMax > maxWeight) {
			recurse(currentMax, index - 1);
		}
		if (index == 0 && currentMax + weights[0] <= maxWeight) {
			currentMax += weights[0];
		}
		if (index == 0 && currentMax > max) {
			max = currentMax;
		}
	}
}

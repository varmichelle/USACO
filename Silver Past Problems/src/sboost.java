import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class sboost {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("sboost.in"));
		PrintStream fileWriter = new PrintStream(new File("sboost.out"));

		int f = fileReader.nextInt();
		int m = fileReader.nextInt();
		double a = f / (double) m;
		int n = fileReader.nextInt();

		int[] partsForce = new int[n];
		int[] partsMass = new int[n];
		double[] partsAcceleration = new double[n];

		for (int i = 0; i < n; i++) {
			partsForce[i] = fileReader.nextInt();
			partsMass[i] = fileReader.nextInt();
			partsAcceleration[i] = partsForce[i] / (double) partsMass[i];
		}
		
		int currentForce = f;
		int currentMass = m;
		double currentAccel = a;
		double bestAccel = a;
		int currentPart;
		int bestPart;
		double bestPartAcceleration = 0;
		int index = 0;
		int[] partsToInclude = new int[n];
		for (int i = 0; i < n; i++) {
			partsToInclude[i] = -1;
		}
		int k = 0;
		while (true) {
			for (int i = 0; i < n; i++) {
				if (partsAcceleration[i] > bestPartAcceleration) {
					bestPartAcceleration = partsAcceleration[i];
					index = i;
				}
			}
			if (bestPartAcceleration > currentAccel) {
				currentForce += partsForce[index];
				currentMass += partsMass[index];
				currentAccel = currentForce / (double) currentMass;
				partsAcceleration[index] = -1;
				partsToInclude[k] = index;
				k++;
			} else {
				break;
			}
			bestPartAcceleration = 0;
		}
		Arrays.sort(partsToInclude);
		for (int i = 0; i < n; i++) {
			if (partsToInclude[i] != -1) {
				fileWriter.println(partsToInclude[i]+1);
			}
		}
		if (partsToInclude[0] == partsToInclude[n-1]) {
			fileWriter.println("NONE");
		}
		
	}

}

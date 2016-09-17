import java.io.*;
import java.util.*;

public class scales {
	
	static int numWeights, max, best;
	static int[] weights;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("scales.in.txt"));
		PrintStream out = new PrintStream(new File("scales.out.txt"));
		
		numWeights = in.nextInt();
		max = in.nextInt();
		weights = new int[numWeights];
		for (int i = 0; i < numWeights; i++) {
			weights[i] = in.nextInt();
		}
		recurse(0, numWeights - 1);
		System.out.println(best);

	}
	
	public static void recurse(int current, int index) {
		if (index > 0 && weights[index] + weights[index - 1] + current <= max) {
			recurse(current + weights[index], index - 1);
		} else if (index > 0 && weights[index] + current <= max) {
			recurse(current + weights[index], index - 2);
			if (index > 1) recurse(current + weights[index - 1], index - 2);
		} else if (index > 0 && weights[index] + current > max) {
			recurse(current, index - 1);
		}
		if (index == 0 && current + weights[0] <= max) current += weights[0];
		best = Math.max(best, current);
	}

}

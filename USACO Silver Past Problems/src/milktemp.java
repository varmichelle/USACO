import java.util.Scanner;
import java.io.*;

public class milktemp {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("milktemp.in"));
		PrintStream fileWriter = new PrintStream(new File("milktemp.out"));
		
		int n = fileReader.nextInt();
		int x = fileReader.nextInt();
		int y = fileReader.nextInt();
		int z = fileReader.nextInt();
		int[][] tempRanges = new int[n][2];
		
		int lowestTemp = 1000000000;
		int highestTemp = 0;
		for (int i = 0; i < n; i++) {
			tempRanges[i][0] = fileReader.nextInt();
			if (tempRanges[i][0] > highestTemp) {
				highestTemp = tempRanges[i][0];
			}
			if (tempRanges[i][0] < lowestTemp) {
				lowestTemp = tempRanges[i][0];
			}
			tempRanges[i][1] = fileReader.nextInt();
			if (tempRanges[i][1] > highestTemp) {
				highestTemp = tempRanges[i][1];
			}
			if (tempRanges[i][1] < lowestTemp) {
				lowestTemp = tempRanges[i][1];
			}
		}
		int temp = lowestTemp - 1;
		int mostMilk = 0;
		while (temp < highestTemp + 2) {
			int currentMilk = 0;
			for (int i = 0; i < n; i++) {
				if (temp < tempRanges[i][0]) {
					currentMilk += x;
				} else if (temp <= tempRanges[i][1]) {
					currentMilk += y;
				} else {
					currentMilk += z;
				}
			}
			int tempLeap = 100000000;
			for (int i = 0; i < n; i++) {
				if (tempRanges[i][0] - 1 > temp && tempRanges[i][0] - 1 < tempLeap) {
					tempLeap = tempRanges[i][0] - 1;
				}
				if (tempRanges[i][1] - 1 > temp && tempRanges[i][1] - 1 < tempLeap) {
					tempLeap = tempRanges[i][1] - 1;
				}
			}
			if (currentMilk > mostMilk) {
				mostMilk = currentMilk;
			}
			temp = tempLeap;
		}
		fileWriter.println(mostMilk);
	}
}
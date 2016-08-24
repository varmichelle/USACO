import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class gifts {

	public static void main(String[] args) throws FileNotFoundException {

		// Set up file I/O
		Scanner fileReader = new Scanner(new File("gifts.in"));
		PrintStream fileWriter = new PrintStream(new File("gifts.out"));
		
		int numCows = fileReader.nextInt();
		int budget = fileReader.nextInt();
		int[][] prices = new int[numCows][4];
		for (int i = 0; i < numCows; i++) {
			prices[i][0] = fileReader.nextInt();         // Gift price
			prices[i][1] = fileReader.nextInt();         // Gift shipping cost
			prices[i][2] = prices[i][0] + prices[i][1];  // Gift total cost
			prices[i][3] = i;                            // Gift index (0...numCows-1)
		}
		
		// Copy the total cost of each gift (price + shipping) into an array called totalCost to be sorted
		int[][] totalCost = new int[numCows][2];
		int[] totalCostCost = new int[numCows];
		int[] totalCostTag = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			totalCost[i][0] = prices[i][2]; 
			totalCostCost[i] = prices[i][2];
			totalCost[i][1] = i;
			totalCostTag[i] = i;
		}
		
		int switch1;
		int switch2;
		int switch1tag;
		int switch2tag;
		for (int j = 0; j < numCows; j++) {
			int index = smallestNum(totalCostCost, numCows, j);
			switch1 = totalCostCost[index];
			switch2 = totalCostCost[j];
			totalCostCost[j] = switch1;
			totalCostCost[index] = switch2;
			switch1tag = totalCostTag[index];
			switch2tag = totalCostTag[j];
			totalCostTag[j] = switch1tag;
			totalCostTag[index] = switch2tag;
			totalCost[j][0] = totalCostCost[j];
			totalCost[j][1] = totalCostTag[j];
		}
				
		// Define some variables to be used later.
		double sum = 0;
		int currentIndex = 0;
		int numGifts = 0;
		
		// While the sum doesn't exceed the budget, add the next cheapest gift
		while (sum <= budget) {
			sum += totalCost[currentIndex][0];
			currentIndex++;
			numGifts++;
			if (numGifts == numCows && sum <= budget) {
				fileWriter.println(numGifts);
				break;
			}
		}
		
		// Define some more variables.
		int index = 0;
		int bestIndex = 0;
		int bestValue = 0;
		
		if (sum > budget) {
			for (int i = 0; i < currentIndex; i++) {
				if (prices[totalCost[i][1]][0] > bestValue) {
					bestValue = prices[totalCost[i][1]][0];
				}
				// If the sum no longer exceeds the budget after the coupon has been applied, 
				// print out the number of gifts and break out of the loop
			}
			sum -= (double) bestValue/2;
			if (sum <= budget) {
				fileWriter.println(numGifts);
			// Otherwise, add the 1/2 price back to the sum
			} else {
				sum += (double) bestValue/2;
			}
		}
		
		// If, after applying the coupon, the sum is still over the budget...
		if (sum > budget) {
			// Remove the most expensive gift that had been added...  
			sum -= totalCost[currentIndex - 1][0];
			// ...and loop through every non-added gift to replace the removed gift
			for (int i = currentIndex; i < numCows; i++) {
				// Add the total cost of the gift to the sum
				sum += totalCost[i][0];
				sum -= (double) prices[totalCost[i][1]][0]/2;
				// If the sum no longer exceeds the budget, print out the number of gifts and break out of the loop
				if (sum <= budget) {
					fileWriter.println(numGifts);
					break;
					// Otherwise, add the price back in
				} else {
					sum += (double) prices[totalCost[i][1]][0]/2;
					sum -= totalCost[i][0];
				}
			}
			sum += totalCost[currentIndex - 1][0];
		}
		
		if (sum > budget) {
			fileWriter.println(numGifts-1);
		}
		if (sum == 0) {
			fileWriter.println(0);
		}
		
	}
	
	public static int smallestNum(int[] numbers, int numNum, int currentIndex) {
		int smallest = numbers[currentIndex];
		int indexOfSmallest = currentIndex;
		for (int k = 1 + currentIndex; k < numNum; k++) {
			if (numbers[k] < smallest) {
				smallest = numbers[k];
				indexOfSmallest = k;
			}
		}
		return indexOfSmallest;
	}
}
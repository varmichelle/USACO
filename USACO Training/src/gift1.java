
/* ID: michell26
 LANG: JAVA
 PROG: gift1
 */
import java.io.*;
import java.util.Scanner;
public class gift1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("gift1.in"));
		PrintStream fileWriter = new PrintStream(new File("gift1.out"));
		int numPeople = fileReader.nextInt();
		String[] names = new String[numPeople];
		int[] money = new int[numPeople];
		for (int i = 0; i < numPeople; i++) {
			names[i] = fileReader.next();
			money[i] = 0;
		}
		String gifter = "";
		String amountMoney = "";
		int moneyAmount = 0;
		int gifterIndex = 0;
		int numReceivers = 0;
		for (int i = 0; i < numPeople; i++) {
			gifter = fileReader.next();
			// Search through the array and find the index of the person gifting
			// from the array of names
			for (int j = 0; j < numPeople; j++) {
				// If a match between names is found:
				if (names[j].equals(gifter)) {
					// Save the index (j) and read the next line of input
					// (amount of gift and to how many people)
					gifterIndex = j;
					String banana = fileReader.nextLine();
					String moneyInfo = fileReader.nextLine();
					char[] moneyInfoArray = moneyInfo.toCharArray();
					// Search for the space that separates the amount of money
					// and # of people
					numReceivers = moneyInfoArray[moneyInfoArray.length - 1] - 48;
					for (int k = 0; k < moneyInfoArray.length; k++) {
						if (moneyInfoArray[k] == ' ') {
							for (int l = 0; l < k; l++) {
								// Determine the amount of money given
								// (characters before the space)
								amountMoney += moneyInfoArray[l];
							}
							moneyAmount = Integer.parseInt(amountMoney);
							// Determine the number of people that the money is
							// given to
						}
					}
					int amountPerPerson;
					if (numReceivers == 0) {
						amountPerPerson = 0;
					} else {
						amountPerPerson = moneyAmount / numReceivers;
					}
					int remainder;
					if (numReceivers == 0) {
						remainder = 0;
					} else {
						remainder = moneyAmount % numReceivers;
					}
					// Subtract money amount from gifter's total
					money[j] -= moneyAmount;
					// Add money to gift receivers
					for (int m = 0; m < numReceivers; m++) {
						String giftReceiver = fileReader.nextLine();
						for (int n = 0; n < numPeople; n++) {
							if (giftReceiver.equals(names[n])) {
								money[n] += amountPerPerson;
							}
						}
					}
					// Add remainder to gifter's total
					money[j] += remainder;
					gifter = "";
					amountMoney = "";
					moneyAmount = 0;
					gifterIndex = 0;
					numReceivers = 0;
				}
			}

		}
		for (int i = 0; i < numPeople; i++) {
			fileWriter.println(names[i] + " " + money[i]);
		}
	}
}
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class binarySearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File("numbers.txt"));
		
		int n = fileReader.nextInt();
		String check = fileReader.next();
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = fileReader.next();
		}
		Arrays.sort(strings);
		boolean found = false;
		for (int i = 0; i < strings.length; i++) {
			if (check.equals(strings[i])) {
				System.out.println("yes");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("no");
		}
		
		
	}

}

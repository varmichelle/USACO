import java.util.Scanner;
import java.io.*;

public class fact {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("fact.in"));
		PrintStream fileWriter = new PrintStream(new File("fact.out"));
		int n = fileReader.nextInt();
		fileWriter.println(factorial(n));
	}

	public static int factorial(int n) {
		if (n==1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
}

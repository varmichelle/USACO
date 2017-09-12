import java.util.Scanner;
import java.io.*;

public class fib {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("fib.in"));
		PrintStream fileWriter = new PrintStream(new File("fib.out"));
		int n = fileReader.nextInt();
		fileWriter.println(fibNum(n));

	}
	
	public static int fibNum(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibNum(n-1) + fibNum(n-2);
		}
	}

}

import java.util.Scanner;
import java.io.*;

public class ruler {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("ruler.in"));
		PrintStream fileWriter = new PrintStream(new File("ruler.out"));
		int length = fileReader.nextInt();
		int current = length;
		for (int i = 0; i < length; i++) {
			fileWriter.print("*");
		}
		fileWriter.println();
		printRuler(length, current - 1, fileWriter);
		for (int i = 0; i < length; i++) {
			fileWriter.print("*");
		}
		fileWriter.println();
	}

	public static void printRuler(int length, int current, PrintStream fileWriter) {
		if (current == 1) {
			fileWriter.println("*");
		} else {
			printRuler(length, current - 1, fileWriter);
			for (int i = 0; i < current; i++) {
				fileWriter.print("*");
			}
			fileWriter.println();
			printRuler(length, current - 1, fileWriter);
		}
	}
}
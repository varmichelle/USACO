import java.io.*;
import java.util.Scanner;

public class censoring {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("censor.in"));
		PrintStream fileWriter = new PrintStream(new File("censor.out"));
		String text = fileReader.nextLine();
		String censoredText = fileReader.nextLine();
		while (text.contains(censoredText)) {
			text = text.replace(censoredText, "");
		}
		fileWriter.println(text);
	}
}
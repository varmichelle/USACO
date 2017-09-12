import java.io.*;
import java.util.*;

public class robo {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Set up file I/O
		Scanner fileReader = new Scanner(new File("robo.in"));
		PrintStream fileWriter = new PrintStream(new File("robo.out"));
		int n = fileReader.nextInt();
		Stack bayhales = new Stack();
		int index = 1;
		int numBayhales = 0;
		for (int i = 0; i < n; i++) {
			if (fileReader.next().equals("ADD")) {
				bayhales.push(index);
				numBayhales++;
				index++;
			} else {
				bayhales.pop();
				numBayhales--;
			}
		}
		fileWriter.println(numBayhales);
		Object[] bayhales2 = new Object[bayhales.size()];
		int i = bayhales2.length - 1;
		while (! bayhales.empty()) {
			bayhales2[i] = bayhales.peek();
			i--;
			bayhales.pop();
		}
		for (int curIndex = 0; curIndex < bayhales2.length; curIndex++) {
			fileWriter.println(bayhales2[curIndex]);
		}
		
	}
}

import java.util.*;
import java.io.*;

public class stack {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File ("stack.in"));
		PrintStream fileWriter = new PrintStream(new File("stack.out"));
		int n = fileReader.nextInt();
		Stack nums = new Stack();
		for (int i = 0; i < n; i++) {
			if (fileReader.next().equals("push")) {
				nums.push(fileReader.nextInt());
			} else {
				nums.pop();
			}
		}
		boolean firstTime = true;
		while (! nums.empty()) {
			if (!firstTime) {
				fileWriter.print(" ");
			}
			firstTime = false;
			fileWriter.print(nums.peek());
			nums.pop();
		}
		fileWriter.println();
			
	}

}

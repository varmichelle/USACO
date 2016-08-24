import java.util.*;
import java.io.*;

public class queue {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File ("queue.in"));
		PrintStream fileWriter = new PrintStream(new File("queue.out"));
		Queue<Integer> nums = new LinkedList<Integer>();		
		int n = fileReader.nextInt();
		for (int i = 0; i < n; i++) {
			if (fileReader.next().equals("add")) {
				nums.add(fileReader.nextInt());
			} else {
				nums.remove();
			}
		}
		boolean firstTime = true;
		while (! nums.isEmpty()) {
			if (!firstTime) {
				fileWriter.print(" ");
			}
			firstTime = false;
			fileWriter.print(nums.peek());
			nums.remove();
		}
		fileWriter.println();

	}

}

import java.io.*;
import java.util.*;

public class catchcow {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * General solution idea:
		 * Use BFS to traverse all possible paths (+1, -1, *2)
		 * Optimize with limits on position (don't go farther than 2*cow + 1)
		 */
		
		Scanner fileReader = new Scanner(new File("catchcow.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("catchcow.out.txt"));
		// grab inputs
		int farmer = fileReader.nextInt();
		int cow = fileReader.nextInt();
		int[] field = new int[cow*2 + 1];
		if (farmer >= cow) {
			// if the farmer is in front of the cow, he can only move back 1 unit at a time
			System.out.println(farmer - cow);
			System.exit(0);
		}
		// q stores position of farmer and number of moves needed to get there
		Queue<Pair> q = new LinkedList<Pair>();
		// push the starting node into the queue
		q.add(new Pair(farmer, 0));
		while (!q.isEmpty()) {
			Pair current = q.remove();
			// check if we're at the cow's position (termination node)
			if (current.pos == cow) {
				System.out.println(current.index);
				System.exit(0);
			} else {
				// if we're not finished, push all three move scenarios into the queue
				q.add(new Pair(current.pos - 1, current.index + 1));
				q.add(new Pair(current.pos + 1, current.index + 1));
				q.add(new Pair(current.pos * 2, current.index + 1));
			}
		}
		
	}
	
}

class Pair {
	int pos, index;
	Pair(int x, int i) {
		pos = x;
		index = i;
	}
}
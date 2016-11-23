import java.util.*;
import java.io.*;

public class hideseek {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hideseek.in.txt"));
		PrintStream out = new PrintStream(new File("hideseek.out.txt"));
		
		int N = in.nextInt(); // number of barns
		int M = in.nextInt(); // number of paths
		
		List<Map<Integer, Integer>> graph = new ArrayList<Map<Integer, Integer>>();
		// bfs with the adjacency list until you visit all of them
		// print the index of the smallest indexed barn with largest distance
		
		
	}

}

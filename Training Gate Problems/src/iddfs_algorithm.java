
import java.util.*;
import java.io.*;

public class iddfs_algorithm {

	static boolean[][] adj_matrix;
	static int nodes, max_depth = 1;
	static boolean[] visited;
	static boolean found = false;
	// set this to the goal
	static int goal = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("iddfs_algorithm.in.txt"));
		PrintStream out = new PrintStream(new File("iddfs_algorithm.out.txt"));
		
		// number of nodes in the graph
		nodes = in.nextInt();
		
		// store false if the two nodes are not connected, true if connected
		adj_matrix = new boolean[nodes][nodes];
		
		// number of node connections in the graph
		int connect = in.nextInt();
		
		// fill in adj_matrix
		for (int i = 0; i < connect; i++) {
			int vertex_1 = in.nextInt() - 1;
			int vertex_2 = in.nextInt() - 1;
			adj_matrix[vertex_1][vertex_2] = true;
			adj_matrix[vertex_2][vertex_1] = true;
		}
		
		// keep track of which nodes have been visited to avoid revisiting
		visited = new boolean[nodes];
		
		while (!found) {
			iddfs_recurse(0, 1);
			max_depth++;
		}
		
		// reset visited array
		for (int i = 0; i < nodes; i++) visited[i] = false;
		// reset max depth
		max_depth = 1;
		// reset found
		found = false; 
		
	}
	
	public static void iddfs_recurse(int current, int depth) {
		if (depth > max_depth) return;
		visited[current] = true;
		do_something(current);
		if (current == goal) found = true;
		for (int i = 0; i < nodes; i++) {
			if (adj_matrix[current][i] == true && visited[i] == false) {
				iddfs_recurse(i, depth + 1);
			}
		}
	}
	
	public static void do_something(int current) {
		// do something with the current node if needed
	}

	public static void dfs_stack(int source) {
		Stack stack = new Stack();
		stack.push(source);
		while (!stack.empty()) {
			int current = (int) stack.peek();
			System.out.println(current + 1);
			visited[current] = true;
			stack.pop();
			do_something(current);
			for (int i = 0; i < nodes; i++) {
				if (adj_matrix[i][current] == true && !visited[i]) stack.push(i);
			}
		}
	}
	
}

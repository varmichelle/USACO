import java.io.*;
import java.util.*;

public class mst3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("mst.in.txt"));
		PrintStream out = new PrintStream(new File("mst.out.txt"));
		
		int vertices = scan.nextInt();
		int edge = scan.nextInt();
		int[][] adjacency_matrix = new int[vertices][vertices];
		for (int i = 0; i < edge; i++) {
			for (int j = 0; j < vertices; j++) {
				adjacency_matrix[i][j] = 999999999;
			}
		}
		
		for (int i = 0; i < edge; i++) {
			int vertex_1 = scan.nextInt() - 1;
			int vertex_2 = scan.nextInt() - 1;
			int cost = scan.nextInt();
			adjacency_matrix[vertex_1][vertex_2] = cost;
			adjacency_matrix[vertex_2][vertex_1] = cost;
		}
		int[] visited = new int[vertices];
		int total_cost = 0;
		
		
	}

}

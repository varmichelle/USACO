import java.util.*;
import java.io.*;

public class hideseek {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hideseek.in.txt"));
		PrintStream out = new PrintStream(new File("hideseek.out.txt"));
		
		int N = in.nextInt(); // number of barns
		int M = in.nextInt(); // number of paths
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			int node1 = in.nextInt() - 1;
			int node2 = in.nextInt() - 1;
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		Queue<Barns> q = new LinkedList<Barns>();
		int[] distances = new int[N];
		boolean[] visited = new boolean[N];
		int bestDistance = -1, bestIndex = 0, number =0;
		q.add(new Barns(0,0));
		while (!q.isEmpty()) {
			Barns current = q.remove();
			int index = current.index;
			int distance = current.distance;
			visited[index] = true;
			distances[index] = distance;
			if (distance > bestDistance) {
				bestDistance = distance;
				bestIndex = index;
				number = 1;
			} else if (distance == bestDistance) {
				number++;
				bestIndex = Math.min(bestIndex, index);
			}
			for (int i : graph.get(index)) {
				if (!visited[i]) {
					Barns barn = new Barns(i, distance + 1);
					visited[i] = true;
					q.add(barn);
				}
			}
		}
		
		System.out.println((bestIndex+1) + " " + bestDistance + " " + number);
		
	}

}

class Barns {
	int index, distance;
	public Barns(int i, int d) {
		index = i;
		distance = d;
	}
}

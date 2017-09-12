import java.io.*;
import java.util.*;

public class sgraze {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("sgraze.in.txt"));
		PrintStream out = new PrintStream(new File("sgraze.out.txt"));
		
		int N = in.nextInt();
		Graze[] pos = new Graze[N];
		for (int i = 0; i < N; i++) {
			pos[i] = new Graze(in.nextInt(), in.nextInt());
		}
		
		// DP[k] = max number of first k cows that can graze
		int[] DP = new int[N+1];
		
		// sort by end position 
		Arrays.sort(pos);
		for (int i = 1; i <= N; i++) {
			// Recurrence: DP[i] = max(DP[j]+1, DP[i-1]) 
			// where j = largest index of cow satisfying pos[j].end <= pos[i].start
			// Binary search for j
			int low = -1;
			int high = N-1;
			int mid = (low + high + 1)/2;
			while (low < high) {
				if (pos[mid].end <= pos[i-1].start) low = mid;
				else high = mid-1;
				mid = (low + high + 1)/2;
			}
			mid = low + 1;
			// max of including and not including cow i
			DP[i] = Math.max(DP[mid]+1, DP[i-1]);
		}
		System.out.println(DP[N]);
		
	}

}

class Graze implements Comparable<Graze> {
	int start, end;
	public Graze(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int compareTo(Graze other) {
		return this.end - other.end;
	}
	public int compare(Graze other) {
		return other.start - this.start;
	}
}

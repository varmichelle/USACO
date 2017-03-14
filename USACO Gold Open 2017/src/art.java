import java.util.*;
import java.io.*;

public class art {
	
	static int[][] grid, corners;
	static List<Integer>[] overlap;
	static int[] dp;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("art.in"));
		PrintStream out = new PrintStream(new File("art.out"));
		
		int N = in.nextInt();
		grid = new int[N][N];
		dp = new int[N*N+1];
		corners = new int[N*N+1][4];
		for (int i = 1; i <= N*N; i++) {
			for (int j = 0; j < 4; j++) {
				corners[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = in.nextInt();
				if (corners[grid[i][j]][0] == -1) corners[grid[i][j]][0] = i;
				else corners[grid[i][j]][0] = Math.min(corners[grid[i][j]][0], i);
				if (corners[grid[i][j]][1] == -1) corners[grid[i][j]][1] = j;
				else corners[grid[i][j]][1] = Math.min(corners[grid[i][j]][1], j);
				if (corners[grid[i][j]][2] == -1) corners[grid[i][j]][2] = i;
				else corners[grid[i][j]][2] = Math.max(corners[grid[i][j]][2], i);
				if (corners[grid[i][j]][0] == -1) corners[grid[i][j]][0] = i;
				else corners[grid[i][j]][3] = Math.max(corners[grid[i][j]][3], j);
			}
		}
	
		overlap = new ArrayList[N*N+1];
		for (int i = 1; i <= N*N; i++) {
			for (int j = 1; j <= N*N; j++) {
				overlap[j] = new ArrayList<Integer>();
			}
		}
		for (int i = 2; i <= N*N; i++) {
			for (int j = 1; j < i; j++) {
				if (corners[i][0] == -1 || corners[j][0] == -1) continue;
				int answer = findOverlap(i, j);
				if (answer == 1) overlap[i].add(j); // i overlaps j
				else if (answer == 2) overlap[j].add(i); // j overlaps i
			}
		}
		int max = 0;
		for (int i = 1; i <= N*N; i++) {
			max = Math.max(max, traceOverlap(i));
		}
		out.println(max);
	}
	
	public static int traceOverlap(int i) {
		if (overlap[i].size() == 0) return 1;
		else {
			if (dp[i] != 0) return dp[i];
			int ans = 0;
			for (int j = 0; j < overlap[i].size(); j++) {
				ans = Math.max(ans, 1 + traceOverlap(overlap[i].get(j)));
			}
			dp[i] = ans;
			return ans;
		}
	}

	public static int findOverlap(int i, int j) {
		// split overlap
		if (corners[i][0] <= corners[j][0] && corners[i][2] >= corners[j][2]) {
			if (corners[i][1] >= corners[j][1] && corners[i][3] <= corners[j][3]) {
				if (grid[corners[j][0]][corners[i][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		} else if (corners[j][0] <= corners[i][0] && corners[j][2] >= corners[i][2]) {
			if (corners[j][1] >= corners[i][1] && corners[j][3] <= corners[i][3]) {
				if (grid[corners[i][0]][corners[j][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		// L shape overlap
		if (corners[j][2] >= corners[i][0] && corners[j][2] <= corners[i][2]) {
			if (corners[j][3] >= corners[i][1] && corners[j][3] <= corners[i][3]) {
				if (grid[corners[j][2]][corners[j][3]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		else if (corners[j][2] >= corners[i][0] && corners[j][2] <= corners[i][2]) {
			if (corners[j][1] >= corners[i][1] && corners[j][1] <= corners[i][3]) {
				if (grid[corners[j][2]][corners[j][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		else if (corners[j][0] >= corners[i][0] && corners[j][0] <= corners[i][2]) {
			if (corners[j][3] >= corners[i][1] && corners[j][3] <= corners[i][3]) {
				if (grid[corners[j][0]][corners[j][3]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		else if (corners[j][0] >= corners[i][0] && corners[j][0] <= corners[i][2]) {
			if (corners[j][1] >= corners[i][1] && corners[j][1] <= corners[i][3]) {
				if (grid[corners[j][0]][corners[j][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		
		
		if (corners[i][2] >= corners[j][0] && corners[i][2] <= corners[j][2]) {
			if (corners[i][3] >= corners[j][1] && corners[i][3] <= corners[j][3]) {
				if (grid[corners[i][2]][corners[i][3]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		else if (corners[i][2] >= corners[j][0] && corners[i][2] <= corners[j][2]) {
			if (corners[i][1] >= corners[j][1] && corners[i][1] <= corners[j][3]) {
				if (grid[corners[i][2]][corners[i][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		else if (corners[i][0] >= corners[j][0] && corners[i][0] <= corners[j][2]) {
			if (corners[i][3] >= corners[j][1] && corners[i][3] <= corners[j][3]) {
				if (grid[corners[i][0]][corners[i][3]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		
		else if (corners[i][0] >= corners[j][0] && corners[i][0] <= corners[j][2]) {
			if (corners[i][1] >= corners[j][1] && corners[i][1] <= corners[j][3]) {
				if (grid[corners[i][0]][corners[i][1]] == i) return 1; // i overlaps j
				else return 2; // j overlaps i
			}
		}
		return 0; // no overlap
	}

}

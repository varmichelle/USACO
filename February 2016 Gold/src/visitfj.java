import java.util.*;
import java.io.*;

public class visitfj {

	static final int INF = 100001;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("visitfj.in.txt"));
		PrintStream out = new PrintStream(new File("visitfj.out.txt"));
		
		int N = in.nextInt();
		int T = in.nextInt();
		
		int[][] grass = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grass[j][i] = in.nextInt();
			}
		}
		int[][][] dp = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j][0] = INF;
				dp[i][j][1] = INF;
				dp[i][j][2] = INF;
			}
		}
		dp[0][0][0] = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for (int i = 0; i < N-1; i++) {
			// bottom horizontal 
			for (int x = i+1; x >= 0; x--) {
				int y = i+1;
				for (int j = 0; j <= 2; j++) {
					for (int k = 0; k < 4; k++) {
						if (x+dx[k] >= 0 && x+dx[k]<N && y+dy[k]>=0 && y+dy[k]<N) dp[x][y][j] = Math.min(dp[x][y][j], dp[x+dx[k]][y+dy[k]][(j+2)%3]+T);
					}
					if (j == 0 && dp[x][y][j] != INF) dp[x][y][j] += grass[x][y];
					if (dp[x][y][j] != INF) System.out.println(x+ " " + y + " " + j + " " + dp[x][y][j]);
				}
			}
			// right vertical
			for (int y = i; y >= 0; y--) {
				int x = i+1;
				for (int j = 0; j <= 2; j++) {
					for (int k = 0; k < 4; k++) {
						if (x+dx[k] >= 0 && x+dx[k]<N && y+dy[k]>=0 && y+dy[k]<N) dp[x][y][j] = Math.min(dp[x][y][j], dp[x+dx[k]][y+dy[k]][(j+2)%3]+T);
					}
					if (j == 0 && dp[x][y][j] != INF) dp[x][y][j] += grass[x][y];
					if (dp[x][y][j] != INF) System.out.println(x+ " " + y + " " + j + " " + dp[x][y][j]);
				}
			}
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][N-1][0], dp[N-1][N-1][1]), dp[N-1][N-1][2]));
	}

}

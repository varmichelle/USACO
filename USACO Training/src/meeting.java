
import java.util.*;
import java.io.*;

public class meeting {
	
	static int num_fields, least_time = 999999999;
	static Set<Integer> times = new HashSet<Integer>();
	static int[][] bessie_time, elsie_time;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("meeting.in.txt"));
		PrintStream out = new PrintStream(new File("meeting.out.txt"));
		
		num_fields = in.nextInt();
		int num_paths = in.nextInt();
		bessie_time = new int[num_fields + 1][num_fields + 1];
		elsie_time = new int[num_fields + 1][num_fields + 1];
		for (int i = 0; i < num_paths; i++) {
			int field_a = in.nextInt();
			int field_b = in.nextInt();
			bessie_time[field_a][field_b] = in.nextInt();
			elsie_time[field_a][field_b] = in.nextInt();
		}
		
		dfs_bessie(1, 0);
		dfs_elsie(1, 0);
		if (least_time != 999999999) out.println(least_time);
		else out.println("IMPOSSIBLE");

	}

	public static void dfs_bessie(int field, int time) {
		if (field == num_fields) times.add(time);
		else {
			for (int i = field + 1; i <= num_fields; i++) {
				if (bessie_time[field][i] != 0) dfs_bessie(i, time + bessie_time[field][i]);
			}
		}
	}

	public static void dfs_elsie(int field, int time) {
		if (field == num_fields) {
			int size = times.size();
			times.add(time);
			if (times.size() == size) least_time = Math.min(least_time, time);
		} else {
			for (int i = field + 1; i <= num_fields; i++) {
				if (elsie_time[field][i] != 0) dfs_elsie(i, time + elsie_time[field][i]);
			}
		}
	}

}

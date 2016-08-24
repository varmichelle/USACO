
/*
ID: michell26
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class milk2 {

	public static void main(String[] args) throws FileNotFoundException {
 
		Scanner scan = new Scanner(new File("milk2.in"));
		PrintStream out = new PrintStream(new File("milk2.out"));
				
		int N = scan.nextInt();
		point[] times = new point[N*2];
		for (int i = 0; i < N*2 - 1; i+=2) {
			times[i] = new point();
			times[i+1] = new point();
			times[i].time = scan.nextInt();
			times[i].type = 1;
			times[i+1].time = scan.nextInt();
			times[i+1].type = -1; 
		}
		Arrays.sort(times);
		int[] num_milking = new int[2*N];
		num_milking[0] = 1;
		int max_none = 0, max_some = 0, none_start_time = -1, some_start_time = times[0].time;
		for (int i = 1; i < 2*N; i++) {
			num_milking[i] = num_milking[i-1] + times[i].type;
			while (i < 2*N-1 && times[i].time == times[i+1].time) {
				i++;
				num_milking[i] = num_milking[i-1] + times[i].type;
			}
			if (some_start_time != -1 && num_milking[i] == 0) max_some = Math.max(max_some, times[i].time - some_start_time);
			else if (none_start_time != -1 && num_milking[i] > 0) max_none = Math.max(max_none, times[i].time - none_start_time);
			if (some_start_time == -1 && num_milking[i] > 0) some_start_time = times[i].time;
			else if (none_start_time == -1 && num_milking[i] == 0) none_start_time = times[i].time;
			if (num_milking[i] == 0) some_start_time = -1;
			else if (num_milking[i] > 0) none_start_time = -1;
		}
		out.println(max_some + " " + max_none);
	}

}

class point implements Comparable<point>{
	int time = 0, type = 0;
	public int compareTo(point x) {
		return this.time - x.time;
	}
	public int compare(point x, point y) {
		return x.type - y.type;
	}
}

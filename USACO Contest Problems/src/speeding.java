import java.io.*;
import java.util.*;

public class speeding {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("speeding.in"));
		PrintStream out = new PrintStream(new File("speeding.out"));
		
		int road_segments = scan.nextInt();
		int drive_segments = scan.nextInt();
		int[] road = new int[101];
		int prev = 0;
		for (int i = 0; i < road_segments; i++) {
			 int next = scan.nextInt();
			 int value = scan.nextInt();
			 for (int j = prev + 1; j < prev + 1 + next; j++) {
				 road[j] = value;
			 }
			 prev = prev + next;
		}
		int[] drive = new int[101];
		prev = 0;
		for (int i = 0; i < drive_segments; i++) {
			 int next = scan.nextInt();
			 int value = scan.nextInt();
			 for (int j = prev + 1; j < prev + 1 + next; j++) {
				 drive[j] = value;
			 }
			 prev = prev + next;
		}
		int max_diff = 0;
		for (int i = 1; i < 101; i++) {
			if (drive[i] - road[i] > 0) {
				max_diff = Math.max(drive[i] - road[i], max_diff);
			}
		}
		System.out.println(max_diff);

	}

}

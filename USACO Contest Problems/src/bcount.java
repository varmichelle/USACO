import java.io.*;
import java.util.*;

public class bcount {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("bcount.in"));
		PrintStream out = new PrintStream(new File("bcount.out"));
		
		int num_cows = scan.nextInt();
		int num_queries = scan.nextInt();
		int current_cow_breed;
		int[] num_breed_1 = new int[num_cows + 1];
		int[] num_breed_2 = new int[num_cows + 1];
		int[] num_breed_3 = new int[num_cows + 1];
		for (int i = 1; i <= num_cows; i++) {
			current_cow_breed = scan.nextInt();
			if (current_cow_breed == 1) num_breed_1[i] = num_breed_1[i-1] + 1;
			else num_breed_1[i] = num_breed_1[i-1];
			if (current_cow_breed == 2) num_breed_2[i] = num_breed_2[i-1] + 1;
			else num_breed_2[i] = num_breed_2[i-1];
			if (current_cow_breed == 3) num_breed_3[i] = num_breed_3[i-1] + 1;
			else num_breed_3[i] = num_breed_3[i-1];
		}
		for (int i = 0; i < num_queries; i++) {
			int query_start = scan.nextInt();
			int query_end = scan.nextInt();
			out.print(num_breed_1[query_end] - num_breed_1[query_start - 1] + " ");
			out.print(num_breed_2[query_end] - num_breed_2[query_start - 1] + " ");
			out.println(num_breed_3[query_end] - num_breed_3[query_start - 1]);
		}
	}
}

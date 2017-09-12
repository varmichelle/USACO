import java.io.*;
import java.util.*;

public class highcard {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("highcard.in"));
		PrintStream out = new PrintStream(new File("highcard.out"));
		
		int num_cards = scan.nextInt();
		int[] opponent_cards = new int[num_cards];
		int[] own_cards = new int[num_cards*2];
		for (int i = 0; i < num_cards*2; i++) {
			own_cards[i] = i + 1;
		}
		for (int i = 0; i < num_cards; i++) {
			opponent_cards[i] = scan.nextInt();
			own_cards[opponent_cards[i]-1] = 999999999;
		}
		Arrays.sort(opponent_cards);
		Arrays.sort(own_cards);
		int current_total_wins = 0;
		int opp_index = 0;
		for (int i = 0; i < num_cards; i++) {
			if (own_cards[i] > opponent_cards[opp_index]) {
				current_total_wins++;
				opp_index++;
			}
		}
		out.println(current_total_wins);
	}
}

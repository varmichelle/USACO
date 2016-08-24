import java.io.*;
import java.util.*;

public class cardgame {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("cardgame.in"));
		PrintStream out = new PrintStream(new File("cardgame.out"));

		int num_cards = scan.nextInt();
		int[] opponent_cards_round1 = new int[num_cards / 2 + 1];
		int[] own_cards = new int[num_cards * 2];
		for (int i = 0; i < num_cards * 2; i++) {
			own_cards[i] = i + 1;
		}
		for (int i = 0; i < num_cards / 2; i++) {
			opponent_cards_round1[i] = scan.nextInt();
			own_cards[opponent_cards_round1[i] - 1] = 999999999;
		}
		opponent_cards_round1[num_cards / 2] = 999999999;
		int[] opponent_cards_round2 = new int[num_cards / 2];
		for (int i = 0; i < num_cards / 2; i++) {
			opponent_cards_round2[i] = scan.nextInt();
			own_cards[opponent_cards_round2[i] - 1] = 999999999;
		}
		Arrays.sort(opponent_cards_round1);
		Arrays.sort(own_cards);

		// round 1
		int hold = 1;
		int num_cards_in_range = 0;
		int current_index = 0;
		int current_win_total = 0;
		for (int i = 0; i < num_cards / 2; i++) {
			int lo = opponent_cards_round1[i], hi = opponent_cards_round1[i + 1];
			while (own_cards[current_index] < lo && current_index < num_cards)
				current_index++;
			if (current_index == num_cards)
				break;
			while (own_cards[current_index] > lo && own_cards[current_index] < hi && current_index < num_cards) {
				num_cards_in_range++;
				current_index++;
			}
			if (num_cards_in_range >= hold) {
				for (int j = 0; j < hold; j++) {
					current_win_total++;
					own_cards[current_index - j - 1] = 999999999;
				}
				hold = 1;
			} else {
				if (num_cards_in_range == 0) hold++;
				else {
					for (int j = 0; j < num_cards_in_range; j++) {
						current_win_total++;
						own_cards[current_index - j - 1] = 999999999;
					}	
					hold -= num_cards_in_range - 1;
				}
			}
			num_cards_in_range = 0;
		}

		// round 2
		Arrays.sort(opponent_cards_round2);
		Arrays.sort(own_cards);
		int opp_index = num_cards / 2 - 1;
		for (int i = num_cards / 2 - 1; i >= 0; i--) {
			if (own_cards[i] < opponent_cards_round2[opp_index]) {
				current_win_total++;
				opp_index--;
			}
		}

		out.println(current_win_total);

	}

}

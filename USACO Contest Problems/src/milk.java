import java.io.*;
import java.util.*;

public class milk {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("milk.in.txt"));
		PrintStream out = new PrintStream(new File("milk.out.txt"));
		
		Set<Integer> sick_people = new HashSet<Integer>();
		int num_friends = scan.nextInt();
		int num_milk_types = scan.nextInt();
		int num_tastings = scan.nextInt();
		int num_sick = scan.nextInt();
		int tastings[][] = new int[num_tastings][3];
		for (int i = 0; i < num_tastings; i++) {
			// person
			tastings[i][0] = scan.nextInt();
			// milk
			tastings[i][1] = scan.nextInt();
			// time
			tastings[i][2] = scan.nextInt();
		}
		int sick[][] = new int[num_sick][2];
		for (int i = 0; i < num_sick; i++) {
			// person
			sick[i][0] = scan.nextInt();
			// time
			sick[i][1] = scan.nextInt();
		}
		
		int max = 0;
		// loop through all milk types, checking if they could possibly be the bad milk
		// a milk type is potentially bad if everyone who became sick drank that milk type before becoming sick
		for (int i = 0; i < num_milk_types; i++) {
			boolean is_bad = true;
			for (int j = 0; j < num_sick; j++) {
				int person = sick[j][0];
				int time = sick[j][1];
				boolean satisfied = false;
				for (int k = 0; k < num_tastings; k++) {
					if (tastings[k][0] == person && tastings[k][2] < time && tastings[k][1] == i) satisfied = true;
				}
				if (!satisfied) {
					is_bad = false;
					break;
				}
			}
			// if the potentially bad milk has been identified, find the # of medicine doses
			for (int k = 0; k < num_tastings; k++) {
				if (tastings[k][1] == i) {
					sick_people.add(tastings[k][0]);
				}
			}
			max = Math.max(max, sick_people.size());
			sick_people.clear();
		}

		System.out.println(max);
	}

}


import java.io.*;
import java.util.*;

public class milk_training {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("milk_training.in.txt"));
		PrintStream out = new PrintStream(new File("milk_training.out.txt"));
		
		int milk = scan.nextInt();
		int num_farmers = scan.nextInt();
		Structure[] farmers = new Structure[num_farmers];
		for (int i = 0; i < num_farmers; i++) {
			Structure point = new Structure();
			point.price = scan.nextInt();
			point.supply = scan.nextInt();
			farmers[i] = point;
		}
		Arrays.sort(farmers);
		int current_price = 0, current_milk = 0, amount_needed = milk;
		for (int i = 0; i < num_farmers; i++){
			amount_needed = milk - current_milk;
			if (amount_needed == 0) break;
			current_price += farmers[i].price * Math.min(amount_needed, farmers[i].supply); 
			current_milk += Math.min(amount_needed, farmers[i].supply);
		}
		out.println(current_price);
	}
}

class Structure implements Comparable<Structure>{
	int price = 0, supply = 0;
	public int compareTo(Structure x) {
		return this.price - x.price;
	}
	public int compare(Structure x, Structure y) {
		return x.supply - y.supply;
	}
}
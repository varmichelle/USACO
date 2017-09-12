

import java.io.*;
import java.util.*;

public class palsquare {
	
	public static void main(String[] args) throws FileNotFoundException {
 
		Scanner scan = new Scanner(new File("palsquare.in"));
		PrintStream out = new PrintStream(new File("palsquare.out"));
		
		int base = scan.nextInt();
		
		for (int i = 1; i <= 300; i++) {
			String num = Long.toString(i*i, base);
			String reverse = new StringBuilder(num).reverse().toString();
			if (num.equals(reverse)) out.println(Long.toString(i, base).toUpperCase() + " " + Long.toString(i*i, base).toUpperCase());
		}

	}

}

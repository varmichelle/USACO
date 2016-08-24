/*
ID: michell26
LANG: JAVA
TASK: money
*/

import java.io.*;
import java.util.*;

public class money {
			
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(new File("money.in.txt"));
		PrintStream out = new PrintStream(new File("money.out.txt"));
		
		int numCoins = in.nextInt();
		int moneyValue = in.nextInt();
		
		int[] coins = new int[numCoins];
		for (int i = 0; i < numCoins; i++) coins[i] = in.nextInt();
		
		
	}

}

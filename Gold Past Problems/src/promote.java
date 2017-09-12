import java.io.*;
import java.util.*;

public class promote {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("promote.in"));
		PrintStream out = new PrintStream(new File("promote.out"));
		
		int bronzeBefore = scan.nextInt();
		int bronzeAfter = scan.nextInt();
		int silverBefore = scan.nextInt();
		int silverAfter = scan.nextInt();
		int goldBefore = scan.nextInt();
		int goldAfter = scan.nextInt();
		int platinumBefore = scan.nextInt();
		int platinumAfter = scan.nextInt();

		
		int goldToPlatinum = platinumAfter - platinumBefore;
		int silverToGold = platinumAfter - platinumBefore + goldAfter - goldBefore;
		int bronzeToSilver = platinumAfter - platinumBefore + goldAfter - goldBefore + silverAfter - silverBefore;

		out.println(bronzeToSilver);
		out.println(silverToGold);
		out.println(goldToPlatinum);
		
	}

}

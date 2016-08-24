
/* ID: michell26
 LANG: JAVA
 PROG: ride
 */
import java.io.*;
import java.util.Scanner;
public class ride {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner fileReader = new Scanner(new File("ride.in"));
		PrintStream fileWriter = new PrintStream(new File("ride.out"));
		String comet = fileReader.nextLine();
		char[] c = comet.toCharArray();
		long cproduct = 1;
		for (int i = 0; i < comet.length(); i++) {
			cproduct *= c[i] - 64;
		}
		String group = fileReader.nextLine();
		char[] g = group.toCharArray();
		long gproduct = 1;
		for (int i = 0; i < group.length(); i++) {
			gproduct *= g[i] - 64;
		}		
		if (cproduct % 47 == gproduct % 47)	fileWriter.println("GO");
		else fileWriter.println("STAY");
	}
}
import java.util.*;
import java.io.*;
	
public class auto {

	public static void main(String[] args) throws FileNotFoundException {
		
		// set up file readers and writers
		Scanner in = new Scanner(new File("auto.in.txt"));
		PrintStream out = new PrintStream(new File("auto.out.txt"));
		
		// read in input
		int W = in.nextInt();
		int N = in.nextInt();
		Prefix[] dictionary = new Prefix[W];
		for (int i = 0; i < W; i++) dictionary[i] = new Prefix(i, in.next());
		Arrays.sort(dictionary);
		for (int i = 0; i < W; i++) System.out.println(dictionary[i].prefix);
		
	}

}

class Prefix implements Comparable<Prefix> {
	int index;
	String prefix;
	public Prefix(int i, String p) {
		index = i;
		prefix = p;
	}
	public int compareTo(Prefix x) {
		return this.prefix.compareTo(x.prefix);
	}
}

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
		int[] nth = new int[N];
		String[] word = new String[N];
		for (int i = 0; i < N; i++) {
			nth[i] = in.nextInt();
			word[i] = in.next();
		}
		
		Arrays.sort(dictionary);
		
	}

}

class Prefix implements Comparable<Prefix> {
	int index;
	String prefix;
	public Prefix(int i, String p) {
		index = i;
		prefix = p;
	}
	
	// lets us sort the dictionary array by prefix
	public int compareTo(Prefix x) {
		return this.prefix.compareTo(x.prefix);
	}
}

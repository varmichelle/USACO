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
		for (int i = 0; i < N; i++) {
			int nth = in.nextInt();
			String word = in.next();
			// binary search to find occurrence of prefix in dictionary
			int low = 0, high = W - 1, middle = (low + high) / 2;
			while (low <= high) {
				// if the current is too low, increase the lower bound and update middle
				if (dictionary[middle].prefix.compareTo(word) < 0) {
					low = middle + 1;
					middle = (low + high) / 2;
				}
				// if the current contains the prefix of the current query
		    	else if (dictionary[middle].prefix.length() >= word.length() && dictionary[middle].prefix.substring(0, word.length()).equals(word)) {
		    		// find the first instance of that prefix
		    		int index = middle;
		    		while (index >= 0 && dictionary[index].prefix.length() >= word.length() && dictionary[index].prefix.substring(0, word.length()).equals(word)) {
		    			index--;
		    		}
		    		index++;
		    		// find the nth instance of that prefix 
		    		if ((index + nth - 1 < W) && dictionary[index].prefix.length() >= word.length() && dictionary[index + nth - 1].prefix.substring(0, word.length()).equals(word)) {
		    			System.out.println(dictionary[index + nth - 1].index + 1);
		    		} else System.out.println(-1);
		    		break;
		    	// otherwise, the current must be too low, so decrease the upperbound and update middle
		    	} else {
		    		high = middle - 1;
				    middle = (low + high)/2;
		    	}
			}
		}
		
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

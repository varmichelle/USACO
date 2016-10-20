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
		int[] nth = new int[N];
		String[] word = new String[N];
		for (int i = 0; i < N; i++) {
			nth[i] = in.nextInt();
			word[i] = in.next();
			// binary search to find occurrence of prefix in dictionary
			int low = 0, high = W - 1, middle = (low + high) / 2;
			while (low < high) {
				if (dictionary[middle].prefix.compareTo(word[i]) < 0) {
					low = middle + 1;
					middle = (low + high) / 2;
				}
		    	else if (dictionary[middle].prefix.length() >= word[i].length() && dictionary[middle].prefix.substring(0, word[i].length()).equals(word[i])) {
		    		int index = middle;
		    		while (index >= 0 && dictionary[index].prefix.length() >= word[i].length() && dictionary[index].prefix.substring(0, word[i].length()).equals(word[i])) {
		    			index--;
		    		}
		    		index++;
		    		if ((index + nth[i] - 1 < W) && dictionary[index].prefix.length() >= word[i].length() && dictionary[index + nth[i] - 1].prefix.substring(0, word[i].length()).equals(word[i])) {
		    			System.out.println(dictionary[index + nth[i] - 1].index + 1);
		    		} else System.out.println(-1);
		    		break;
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

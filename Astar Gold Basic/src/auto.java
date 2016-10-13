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
		String[] dictionary = new String[W];
		for (int i = 0; i < W; i++) dictionary[i] = in.next();
		Arrays.sort(dictionary);
		int[] indeces = new int[N];
		String[] prefixes = new String[N];
		for (int i = 0 ; i < N; i++) {
			indeces[i] = in.nextInt();
			prefixes[i] = in.next();
		}
		
		// loop through each query 
		for (int i = 0; i < N; i++) {
			int first = 0, last = N - 1, middle = (first + last)/2;
		    while(first <= last) {
		    	if (dictionary[middle].compareTo(prefixes[i]) < 0) first = middle + 1;    
		    	else if (dictionary[middle].substring(0, prefixes[i].length()).equals(prefixes[i])) {
		    		int index = i;
		    		while (dictionary[index].substring(0, prefixes[i].length()).equals(prefixes[i])) {
		    			index--;
		    			if (index < 0) {
		    				index = 0;
		    				break;
		    			}
		    		}
		    		if (index != 0) index++;
		    		
		    	}
		    	else {
		    		last = middle - 1;
				    middle = (first + last)/2;
		    	}
		   }
		   
		}
		
	}

}

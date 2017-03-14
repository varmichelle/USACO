import java.util.*;
import java.io.*;

public class cownomics {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("cownomics.in"));
		PrintStream out = new PrintStream(new File("cownomics.out"));
		
		int N = in.nextInt();
		int M = in.nextInt();
		String[] genomes = new String[2*N];
		for (int i = 0; i < 2*N; i++) genomes[i] = in.next();
		
		for (int length = 1; length <= M; length++) {
			for (int start = 0; start < M - length; start++) {
				boolean works = true;
				for (int spotty = 0; spotty < N && works; spotty++) {
					for (int plain = N; plain < 2*N && works; plain++) {
						if (genomes[spotty].substring(start, start + length).equals(genomes[plain].substring(start, start + length))) {
							works = false;
						}
					}
				}
				if (works) {
					out.println(length);
					System.exit(0);
				}
			}
		}
		
	}

}

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class moosick {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File("moosick.in"));
		PrintStream fileWriter = new PrintStream(new File("moosick.out"));
		int n = fileReader.nextInt();
		int[] notes = new int[n];
		for (int i = 0; i < n; i++) {
			notes[i] = fileReader.nextInt();
		}
		int c = fileReader.nextInt();
		int[] chord = new int[c];
		for (int i = 0; i < c; i++) {
			chord[i] = fileReader.nextInt();
		}
		Arrays.sort(chord);
		// fileWriter.println("Chord length is " + chord.length);
		int[] difference = new int[c];
		int[] temp = new int[c];
		int[] startPos = new int[n];
		for (int i = 0; i < n; i++) {
			startPos[i] = -10010001;
		}
		int count = 0;
		for (int i = 0; i <= notes.length - chord.length; i++) {
			for (int j = 0; j < c; j++) {
				temp[j] = notes[i+j];
			}
			Arrays.sort(temp);
			for (int j = 0; j < c; j++) {
				difference[j] = chord[j]-temp[j];
			}
			Arrays.sort(difference);
			if (difference[0] == difference[c-1]) {
				startPos[i] = i;
				count++;
			}
		}
		fileWriter.println(count);
		for (int i = 0; i < n; i++) {
			if (startPos[i] != -10010001) {
				fileWriter.println(startPos[i]+1);
			}
		}
	}

}

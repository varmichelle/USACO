import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class catchcow2 {
	
	static Scanner fileReader;
	static PrintStream fileWriter;
	static int cow, farmer;
	static int[] field;

	public static void main(String[] args) throws FileNotFoundException {
		
		fileReader = new Scanner(new File("catchcow.in.txt"));
		fileWriter = new PrintStream(new File("catchcow.out.txt"));
		farmer = fileReader.nextInt();
		cow = fileReader.nextInt();
		field = new int[cow*2 + 1];
		if (farmer >= cow) {
			fileWriter.println(farmer - cow);
			System.exit(0);
		}
		floodfillBFS(farmer, 1);
	}
	
	public static void floodfillBFS(int pos_x, int index) {
		Queue<Integer> pos = new LinkedList<Integer>();	
		Queue<Character> indexes = new LinkedList<Character>();	
		pos.add(farmer);
		indexes.add((char) 0);
		while (!pos.isEmpty()) {
		    pos_x = pos.peek();
			pos.remove();
			index = indexes.peek() + 1;
			indexes.remove();
			if (pos_x == cow) {
				System.out.println(field[cow]);
				return;
			}
			if (pos_x > 0 && field[pos_x-1] == 0) {
				field[pos_x-1] = index;
				pos.add(pos_x - 1);
				indexes.add((char) index);
			}
			if (pos_x < cow && field[pos_x+1] == 0) {
				field[pos_x+1] = index;
				pos.add(pos_x + 1);
				indexes.add((char) index);
			}
			if (pos_x < cow && field[pos_x * 2] == 0) {
				field[pos_x * 2] = index;
				pos.add(pos_x * 2);
				indexes.add((char) index);
			}
		}
	}

}

import java.util.*;
import java.io.*;

public class shoppay {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		BufferedReader fileReader = new BufferedReader(new FileReader("shoppay.in"));
		PrintStream fileWriter = new PrintStream(new File("shoppay.out"));
		
		int numRegisters = fileReader.read() - 48;
		// System.out.println(numRegisters);
		Queue<Integer> customersInLine = new LinkedList<Integer>();	
		// registers is an array of queues which stores the customers at each register
		Queue<Integer>[] registers = new Queue[numRegisters];
		for (int i = 0; i < numRegisters; i++) {
			registers[i] = new LinkedList<Integer>();
		}
		String calibrate = fileReader.readLine();
		String holder = fileReader.readLine();
		while (holder != null) {
			// System.out.println(holder);
			if (holder.charAt(0) == 'C') {
				customersInLine.add(Integer.parseInt(holder.substring(2)));
			} else {
				registers[Integer.parseInt(holder.substring(2)) - 1].add(customersInLine.peek());
				customersInLine.remove();
			}
			holder = fileReader.readLine();
		}
		for (int i = 0; i < numRegisters; i++) {
			fileWriter.print(registers[i].size() + " ");
			int temp = registers[i].size();
			for (int j = 0; j < temp; j++) {
				fileWriter.print((registers[i].peek()) + " ");
				registers[i].remove();
			}
			fileWriter.println();
		}
	}
}

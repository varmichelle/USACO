import java.util.*;
public class test {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("hi");
		a.add("bye");
		for (String i : a) {
			System.out.println(i);
			a.add("chicken");
		}

	}

}


public class printNrecurse {

	public static void main(String[] args) {
		p(4, 9);
	}

	public static void p(int n, int m) {
		for (int i = m; i >= m - n + 1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		if (n > 1) {
			p(n - 1, m);
		}
	}

}

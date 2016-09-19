public class subsetBits {

	public static void main(String[] args) {
		
		// This program prints all subsets of the set "numbers"
		int[] numbers = {1,3,5,7};
		for (int n = 0; n < (1 << numbers.length); n++) {
			for (int m = 0; m < numbers.length; m++) {
				if ((n & (1 << m)) >= 1) System.out.print(numbers[m] + " ");
			}
			System.out.println();
		}

	}

}

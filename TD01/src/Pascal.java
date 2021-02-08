public class Pascal {

	public static int pascal(int nBut, int pBut) {
		int tab[] = new int[nBut + 1];
		int n, i;

		tab[0] = 1;

		for (n = 1; n <= nBut; n++) {
			tab[n] = 1;

			for (i = n - 1; i > 0; i--)
				tab[i] = tab[i - 1] + tab[i];
		}

		return tab[pBut];
	}

	public static void main(String[] args) {
		System.out.printf("Cn, p = %d\n", pascal(30000, 250));
	}

}

// time : 0,31s user 0,04s system 102% CPU 0,344 total
// (almost 3 times faster than the c program)


public class Test {

	public static void main(String[] args) {
		if (args.length > 0) {
			var first = args[0];
			var second = args[1];
			var last = args[2];
			System.out.println(first + ' ' + second + ' ' + last);
		}

		// The use of '' instead of "" allows us to use a single character instead of a
		// string.

		// After running javap -c Test from the terminal, it shows that Java itself uses
		// a StringBuilder.
	}

}

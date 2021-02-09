
public class Morse {

	public static void main(String[] args) {
		// Q.01

		if (args.length > 0) {
			String s = "";

			for (String arg : args) {
				s += arg + " Stop. ";
			}

			System.out.println(s);
		}

		// Q.02

		// The java.lang.StringBuilder class allows you to concatenate
		// strings in an optimized way. We allocate a large block of memory from the
		// start
		// and add characters to this block as we go. Additions are done via append
		// methods: there
		// are several (one per standard data type).

		// Q.03

		if (args.length > 0) {
			StringBuilder builder = new StringBuilder("");

			for (String arg : args) {
				builder.append(arg).append(" Stop. ");
			}

			System.out.println(builder);
		}

		// Q.04

		// See the Test class

		// Q.05

		// It is better to use a StringBuilder when you want to concatenate
		// several times a string.
		// However, when we use a loop and the "+" concatenation, even if Java will
		// implicitly create
		// a StringBuilder, he will create a StringBuilder for each iteration.
		// Moreover, if we write a "+" in a call to the append method, it will also
		// create another StringBuilder object. Instead, We would prefer chain calls
		// the "append" method.

	}

}

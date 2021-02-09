import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegEx {

	public static boolean isNumber(String s) {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(s);
		
		return m.matches();
	}

	public static void main(String[] args) {
		// Q.01

		// java.util.regex.Pattern defines the pattern of a regular expression (to be
		// used in a search)
		// The pattern is created using the Pattern.compile() method. The first
		// parameter indicates which pattern is being searched for and the second
		// parameter has a flag to indicates that the search should be case-insensitive.
		// The second parameter is optional.
		// The matcher() method is used to search for the pattern in a string. It
		// returns a Matcher object which contains information about the search that was
		// performed.

		// Q.02

		// Arguments: Test 1234 6ix9ine 10
		// Expected outputs:
		// 1234
		// 10

		if (args.length > 0) {
			for (String arg : args) {
				if (isNumber(arg)) {
					System.out.println(arg);
				}
			}
		}

		// Q.03

		// Arguments: abc ab3 4de f6h 789
		// Expected outputs:
		// 3
		// 789

	}

}

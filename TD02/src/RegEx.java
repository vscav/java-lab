import java.util.regex.Pattern;
import java.util.Arrays;
// import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class RegEx {

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

		System.out.println("\nQ.02\n");

		if (args.length > 0) {
			String regex = "[0-9]+";
			Pattern p = Pattern.compile(regex);
			Matcher m;
			for (String arg : args) {
				m = p.matcher(arg);
				// MatchResult result = m.toMatchResult();
				// System.out.println("Current Matcher: " + result);
				if (m.matches()) { // tries to match the whole string against the pattern
					System.out.println(arg);
				}
			}
		}

		// Q.03

		// Arguments: abc ab3 4de f6h 789
		// Expected outputs:
		// 3
		// 789

		System.out.println("\nQ.03\n");

		if (args.length > 0) {
			String regex = "^\\D*(\\d+)$";
			Pattern p = Pattern.compile(regex);
			Matcher m;
			for (String arg : args) {
				m = p.matcher(arg);
				// MatchResult result = m.toMatchResult();
				// System.out.println("Current Matcher: " + result);
				while (m.find()) { // jump to the next occurrence
					System.out.println(m.group(1));
				}
			}
		}

		// Q.04

		// Arguments: 127.0.0.1 108.9.98.3 234.0.32.11.34 112.28.255
		// Expected outputs: 
		// [127, 0, 0, 1]
		// [108, 9, 98, 3]

		System.out.println("\nQ.04\n");

		for (String arg : args) {
			try {
				int[] ip = parseIpv4(arg);
				if (ip != null) {
					System.out.println(Arrays.toString(ip));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}

	}

	public static int[] parseIpv4(final String string) throws Exception {
		String regex = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);

		int[] ipAddress = null;
		if (m.find()) {
			ipAddress = new int[4];
			
			ipAddress[0] = Integer.parseInt(m.group(1));
			ipAddress[1] = Integer.parseInt(m.group(2));
			ipAddress[2] = Integer.parseInt(m.group(3));
			ipAddress[3] = Integer.parseInt(m.group(4));
		}

		return ipAddress;
	}

}

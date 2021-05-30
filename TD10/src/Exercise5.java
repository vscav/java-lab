import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise5 {
	public static List<String> integersListToStringsList(List<Integer> list) {
		return list.stream().map(i -> i.toString()).collect(Collectors.toList());
	}

	public static String integersListToString(List<Integer> list) {
		return list.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
	}

	public static int sumLengthOfStringsList(List<String> list) {
		return list.stream().mapToInt(s -> s.length()).sum();
	}

	public static long countNonEmptyStringsInList(List<String> list) {
		return list.stream().filter(s -> s.length() > 0).count();
	}

	public static long sumOfIntegersInList(List<Integer> list) {
		return list.stream().reduce(0, (acc, i) -> acc + i);
	}

	public static long sumOfIntegersInArr(int[] arr) {
		return Arrays.stream(arr).reduce(0, (acc, i) -> acc + i);
	}

	public static List<String> capitalizeStringList(List<String> list) {
		return list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
	}

	public static <T> List<T> withoutNFirstElements(List<T> list, int n) {
		if (n > list.size()) {
			throw new IllegalArgumentException("List can\'t delete " + n + " element" + (n > 1 ? "s" : "")
					+ " because it currently contains " + list.size() + " entr" + (list.size() > 1 ? "ies" : "y"));
		}
		if (n < 0) {
			throw new IllegalArgumentException("Number of items to remove must be >= 0 (was: " + n +")");
		}
		return list.stream().skip(n).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		var s = integersListToStringsList(List.of(5, 6, 7, 9)).get(0);
		System.out.println("Integer list [5, 6, 7, 9] becomes the following string list: "
				+ integersListToStringsList(List.of(5, 6, 7, 9)));
		System.out
				.println("Variable s in the previous result " + (s instanceof String ? "is" : "is not") + " a string");

		System.out.println(
				"Integer list [5, 6, 7, 9] becomes the following string: " + integersListToString(List.of(5, 6, 7, 9)));

		System.out.println("String list [\"ABC\",\"DE\",\"\",\"F\"] contains "
				+ sumLengthOfStringsList(List.of("ABC", "DE", "", "F")) + " characters");

		System.out.println("String list [\"ABC\",\"DE\",\"\",\"F\"] contains "
				+ countNonEmptyStringsInList(List.of("ABC", "DE", "", "F")) + " non empty strings");

		System.out.println("Integer list [2, 4, 8, 6] has a total sum of " + sumOfIntegersInList(List.of(2, 4, 8, 6)));

		System.out.println(
				"Integer array {2, 4, 8, 6} has a total sum of " + sumOfIntegersInArr(new int[] { 2, 4, 8, 6 }));

		System.out.println("When capitalized, string list [\"foo\", \"bar\", \"baz\", \"qux\"] becomes "
				+ capitalizeStringList(List.of("foo", "bar", "baz", "qux")));

		int n = 3;
		System.out.println("After removing " + n + " element" + (n > 1 ? "s" : "") + ", string list [\"foo\", \"bar\", \"baz\", \"qux\"] becomes "
				+ withoutNFirstElements(List.of("foo", "bar", "baz", "qux"), n));
	}
}

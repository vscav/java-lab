import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {
	public static void main(final String[] args) {
		var list = List.of("hello", "world", "hello", "lambda");
		System.out.println(count2(list, "hello")); // 2
	}

	// Ex1 - Q.01
	public static long count(List<String> list, String el) {
		long count = 0;
		for (String current : list) {
			if (current.equals(el)) {
				count += 1;
			}
		}
		return count;
	}

	// Ex1 - Q.02
	// To get get a stream from a String object, we need to call the .stream()
	// method.
	// To filter a stream we need to use the method .filter() with a predicate or a
	// lambda function.
	// To count the number of elements inside a stream we can use the .count()
	// method.

	public static long count2(List<String> list, String el) {
		return list.stream().filter(isValue(el)).count();
	}

	public static Predicate<String> isValue(String s) {
		return v -> v.equals(s);
	}
}

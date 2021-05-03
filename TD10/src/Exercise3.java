import java.util.List;

public class Exercise3 {

	public static void main(String[] args) {
		var list = List.of("hello", "world", "hello", "lambda");
		System.out.println(count3(list, "hello")); // 2
	}

	// Ex3 - Q.01
	// we use the mapToInt method instead of the map method because it explicitly
	// returns an IntStream instead of a generic Stream <T>
	
	public static long count3(List<String> list, String el) {
		return list.stream().filter(e -> e.equals(el)).mapToInt(e -> 1).reduce(0, Integer::sum);
	}
}

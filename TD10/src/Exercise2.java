import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

	public static void main(String[] args) {
		var list = List.of("hello", "world", "hello", "lambda");
		System.out.println(upperCase4(list)); // [HELLO, WORLD, HELLO, LAMBDA]
	}

	// Ex2 - Q.01
	public static List<String> upperCase(List<String> list) {
		List<String> upperCaseList = new ArrayList<String>();

		for (String current : list) {
			upperCaseList.add(current.toUpperCase());
		}

		return upperCaseList;
	}

	// Ex2 - Q.02
	// The Stream.map method allows a function to be applied to each element of the
	// stream to transform them into other elements and return the new stream
	// We then use the forEach method of the Stream object to perform an operation
	// for each element
	
	public static List<String> upperCase2(List<String> list) {
		List<String> uppercases = new ArrayList<String>();
		list.stream().map(str -> str.toUpperCase()).forEach(str -> uppercases.add(str));
		return uppercases;
	}

	// Ex2 - Q.03
	public static List<String> upperCase3(List<String> list) {
		List<String> uppercases = new ArrayList<String>();
		list.stream().map(String::toUpperCase).forEach(str -> uppercases.add(str));
		return uppercases;
	}

	// Ex2 - Q.04
	public static List<String> upperCase4(List<String> list) {
		return list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
	}
}

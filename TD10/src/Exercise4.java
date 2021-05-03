import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Exercise4 {

	// Ex4 - Q.01
	// The list2 contains a list of 1000000 random integers between 0 and 100 as a
	// String

	public static void main(String[] args) {
		var list2 = new Random(0).ints(1_000_000, 0, 100).mapToObj(Integer::toString).collect(Collectors.toList());
		// System.out.println(list2);

		final int interNb = 1000;
		System.out.println("Elapsed time for count: " + printAndTime(() -> Exercise1.count(list2, "33"), interNb));
		System.out.println("Elapsed time for count2: " + printAndTime(() -> Exercise1.count2(list2, "33"), interNb));
		System.out.println("Elapsed time for count3: " + printAndTime(() -> Exercise3.count3(list2, "33"), interNb));
	}

	// Ex4 - Q.04
	// In order not to duplicate the code, we use the Supplier <T> functional
	// interface.
	// Supplier <T> represents an operation which does not take an argument and
	// which returns a result (of type T) with the .get() method
	
	public static <T> Long printAndTime(final Supplier<T> function, final int iterations) {
		Long start = System.nanoTime();

		for (int i = 0; i < iterations; i++) {
			function.get();
		}

		Long end = System.nanoTime();

		return (end - start) / iterations;
	}

}

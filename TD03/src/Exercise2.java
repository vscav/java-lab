import java.util.ArrayList;

public class Exercise2 {

	public static void main(String[] args) {
		// Ex2 - Q.01

		// b1 is a Book object with a certain reference. b2 is also a Book object
		// with the same reference than b1.
		// But, when b3 is build (Book object) a new reference is created (even if it
		// has
		// the same value as b1).
		// We should write a specific method to compare them more efficiently.

		var b1 = new Book("Da Java Code", "Duke Brown");
		var b2 = b1;
		var b3 = new Book("Da Java Code", "Duke Brown");

		System.out.println(b1 == b2);
		System.out.println(b1 == b3);

		System.out.println("b1 = b3: " + b1.equals(b3));

		// Ex2 - Q.03
		// The indexOf() method of ArrayList returns the index of
		// the first occurrence of the specified
		// element in this list, or -1 if this list does not contain the element.

		// Ex2 - Q.04
		var list = new ArrayList<Book>();
		list.add(b1);
		System.out.println(list.indexOf(b2));
		System.out.println(list.indexOf(b3));

		// Ex2 - Q.05
		// The method indexOf of ArrayList class uses the well known method equals.
		// If it is not redefined, it will only compare by reference.

		// Ex2 - Q.09
		// Throw an exception: Exception in thread "main" java.lang.NullPointerException
		// We should implement verification in order to check if books are null or not
		// in
		// the override method equals.
		// var aBook = new Book(null, null);
		// var anotherBook = new Book(null, null);
		// var l = new ArrayList();
		// l.add(aBook);
		// System.out.println(l.indexOf(anotherBook));

		// Ex2 - Q.10
		// We should never use the keyword null.

		// Ex2 - Q.11
		// java.util.Objects.requireNonNull checks that the specified object reference
		// is not null. This method is designed primarily
		// for doing parameter validation in methods and constructors.

	}

}

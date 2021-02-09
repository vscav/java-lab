public class Assignation {

	public static void main(String[] args) {

		// Q.01

		// variable s of type string
		var s = "toto";

		// length() method is a final variable which is applicable for string objects.
		System.out.println(s.length());

		// Q.02

		// s1 is a String with a certain reference. s2 is also a String
		// with the same reference than s1.
		// But, when s3 is build (Sting object) a new reference is created (even if it
		// has
		// the same value as s1).

		var s1 = "toto";
		var s2 = s1;
		var s3 = new String(s1);

		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3); // false

		// Q.03

		var s4 = "toto";
		var s5 = new String(s4);

		System.out.println(s4.equals(s5)); // true

		// Q.04

		// In Java, objects of String are immutable which means
		// they are constant and cannot be changed once created.
		// So here, only one String object is created and is assigned by reference
		// to s6 and s7.

		var s6 = "toto";
		var s7 = "toto";

		System.out.println(s6 == s7); // true

		// Q.05

		// String objects are always cached in the String pool. So if one reference
		// variable
		// changes the value of the object, it will be affected to all
		// the reference variables.

		// Q.06

		var s8 = "hello";
		var s9 = s8.toUpperCase(); // We need to stock the value returned
		System.out.println(s8); // "hello"
		System.out.println(s9); // "HELLO"
	}

}


public class Main {

	public static void main(String[] args) {
		// Ex1 - Q.03

		var book = new Book("coucou");
		// System.out.println(book.title + ' ' + book.author);

		// Attributes title and author are declared private in the Book class.
		// So they can be accessed here.
		// One solution is to create getters.

		// There 4 distinct accessibilities available in Java:
		// - private : accessible only in this class
		// - default (no modifier): accessible from this package’s classes
		// - protected : default + inherited classes in other packages
		// - public : accessible from anywhere the class is accessible

		// We will always declare all the fields with the keyword private
		// to prohibits their access outside the class.
		
		System.out.println(book.title() + ' ' + book.author());
	}

}

import java.util.Objects;

public class Book {
	
	// Ex3 - Q.03
	// We create a new String object inherent to the class. If by any chance 
	// the author of a book is "<no author>", it will be interpret as a different String
	// than the one used to create a book that has no author because they are not
	// in the same memory location.
	final static private String noAuthor = new String("<no author>");

	// Ex1 - Q.06
	// We can use the keyword "final" to indicate
	// That the values will not change after initialization.

	// Ex1 - Q.01
	final private String title;
	final private String author;

	public static void main(String[] args) {
		// Ex1 - Q.02
		// It displays "null null" because attributes author and title have not
		// been initialized.

		var book = new Book("Contes de la folie ordinaire", "Charles Bukowski");
		System.out.println(book.title + ' ' + book.author);
	}

	// The Java compiler differentiates between the overloaded constructors by the
	// total number of parameters in the list and their types.

	// Ex1 - Q.07 & Q.08
	// We can use the keyword this to differentiate the object attribute
	// and the constructor parameters.
	public Book(final String title, final String author) {
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
	}

	// Ex1 - Q.09
	public Book(final String t) {
		this(t, noAuthor); // Will call the default constructor
	}

	// Ex1 - Q.10
	public Book() {
		this("", noAuthor); // Will call the default constructor
	}

	// Ex1 - Q.05
	// An Accessor method is commonly known as
	// a get method or simply a getter. A property of the object
	// is returned by the accessor method. They are declared as public.
	// Here, only getters can be implemented.

	public String title() {
		return title;
	}

	public String author() {
		return author;
	}

	// Ex2 - Q.02, Q.06, Q.07 & Q.08
	// @override: Overriding is a feature that allows a subclass
	// or child class to provide a specific implementation of a
	// method that is already provided by one of its
	// super-classes or parent classes. When a method in a subclass
	// has the same name, same parameters or signature, and same
	// return type(or sub-type) as a method in its super-class, then the
	// method in the subclass is said to override the method in the super-class.
	@Override
	public boolean equals(Object other) {
		if(other == null)
			return false;
		if(other.getClass() != getClass())
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Book))
			return false;
		Book book = (Book) other;

		return (this.title).equals(book.title) && (this.author).equals(book.author);
	}

	// Ex3 - Q.01
	// public String toString() {
	// 		return title + " by " + author;
	// }

	// Ex3 - Q.02
	// We can use the keyword @override because we redefine the inherited
	// method from java.lang.Object.
	@Override
	public String toString() {
		if(title.isEmpty()) { return noAuthor + "!"; }
		if(!title.isEmpty() && author == (noAuthor)) {
			return title;
		}
		
		return title + " by " + author;
	}

}

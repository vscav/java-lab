import java.util.Optional;

public class ArrayShoppingCart {

	// Ex2 - Q.01
	// If the maximum number of books that can be stored in the shopping cart
	// is the same for every instance of shopping cart, then we can decide
	// to store this number in a static field.
	// But in this case we want to be able to define a maximum number of books
	// to store in a shopping cart.
	final static private int maxBook = 20;

	final private Book[] books;
	private int numberOfBooks;
	private int maximumNumberOfBooks;

	public ArrayShoppingCart(final int maximumOfBooks) {
		if (maximumOfBooks < 0) {
			throw new IllegalArgumentException("Argument (maximumBooks) must be a positive (or null) integer.");
		}
		this.books = new Book[maximumOfBooks];
		this.numberOfBooks = 0;
		this.maximumNumberOfBooks = maximumOfBooks;
	}

	public ArrayShoppingCart() {
		this(maxBook);
	}

	public int numberOfBooks() {
		return numberOfBooks;
	}

	// Ex2 - Q.02
	// We have to add exception management
	// to control if the car has reached its maximum size or if it was indeed book
	// that was passed as an argument.
	Book[] add(Book book) {
		if (book == null) {
			throw new NullPointerException("Null was passed as argument in add method.");
		}
		if (this.numberOfBooks >= this.maximumNumberOfBooks) {
			throw new IllegalStateException(
					"Cannot add book (" + book.toString() + "): maximum cart capacity reached.");
		}
		books[this.numberOfBooks] = book;
		this.numberOfBooks += 1;
		return books;
	}

	// Ex2 - Q.03
	@Override
	public String toString() {
		StringBuilder builder;
		if (this.numberOfBooks() == 0) {
			builder = new StringBuilder("The cart is empty. \n");
		} else {
			String booksCount = this.numberOfBooks() > 1 ? " books): \n" : " book): \n";
			builder = new StringBuilder("Array shopping cart (");
			builder.append(this.numberOfBooks).append(booksCount);
			for (int i = 0; i < this.numberOfBooks; i++) {
				builder.append("- ").append(this.books[i]).append("\n");
			}
		}

		return builder.toString();
	}

	// Ex2 - Q.04
	public Optional<Book> longestTitle() {
		if (this.numberOfBooks == 0) {
			return Optional.empty();
		}
		
		Book longestTitleBook = this.books[0];
		
		for (int i = 1; i < this.numberOfBooks; i++) {
			int longestTitleBookLength = longestTitleBook.title().length();
			int currentBookLength = this.books[i].title().length();
			if (longestTitleBookLength <= currentBookLength) {
				if (longestTitleBookLength == currentBookLength) {
					continue;
				} else {
					longestTitleBook = this.books[i];
				}
			}
		}
		
		return Optional.ofNullable(longestTitleBook);
	}

}

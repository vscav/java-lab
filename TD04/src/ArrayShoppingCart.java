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
		if (maximumOfBooks < 1) {
			throw new IllegalArgumentException("Argument (maximumBooks) must be a non null positive integer.");
		}
		this.books = new Book[maximumOfBooks];
		this.numberOfBooks = 0;
		this.maximumNumberOfBooks = maximumOfBooks;
	}

	public ArrayShoppingCart() {
		this(maxBook);
	}

	public Book[] books() {
		return books;
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
			throw new IllegalStateException("Cannot add new book (maximum capacity reached) :" + book.toString());
		}
		books[this.numberOfBooks] = book;
		this.numberOfBooks += 1;
		return books;
	}

	// Ex2 - Q.03
	@Override
	public String toString() {
		String booksCount = this.numberOfBooks() > 1 ? " books): \n" : " book): \n";
		StringBuilder builder = new StringBuilder("Array shopping cart (");
		builder.append(this.numberOfBooks).append(booksCount);
		for (int i = 0; i < this.numberOfBooks; i++) {
			builder.append("- ").append(this.books[i]).append("\n");
		}

		return builder.toString();
	}

	// Ex2 - Q.04
	public Book longestTitle() {
		Book longestTitleBook = this.books[0];
		boolean sameLength = false;
		for (int i = 1; i < this.numberOfBooks; i++) {
			if (longestTitleBook.title().length() <= this.books[i].title().length()) {
				if (longestTitleBook.title().length() == this.books[i].title().length()) {
					sameLength = true;
				} else {
					sameLength = false;
					longestTitleBook = this.books[i];
				}
			}
		}

		if (sameLength)
			return null;

		return longestTitleBook;
	}

}

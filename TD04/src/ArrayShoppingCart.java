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

	public ArrayShoppingCart(final int maximumOfBooks) {
		this.books = new Book[maximumOfBooks];
		this.numberOfBooks = 0;
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

	Book[] add(Book book) {
		if (this.numberOfBooks < maxBook) {
			books[this.numberOfBooks] = book;
			this.numberOfBooks += 1;
		}

		return books;
	}

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
		
		if(sameLength) return null;

		return longestTitleBook;
	}

}

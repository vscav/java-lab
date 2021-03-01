import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class FreeShoppingCart {

	// Ex3 - Q.01
	// Elements in an ArrayList are actually objects. And we have to specify
	// the type of objects contained in our ArrayList.
	final private ArrayList<Book> books;

	public FreeShoppingCart() {
		this.books = new ArrayList<Book>();
	}

	public boolean add(Book book) {
		if (book == null) {
			throw new NullPointerException("Null was passed as argument in add method.");
		}
		return this.books.add(book);
	}

	public int numberOfBooks() {
		return this.books.size();
	}

	@Override
	public String toString() {
		StringBuilder builder;
		if (this.numberOfBooks() == 0) {
			builder = new StringBuilder("The cart is empty. \n");
		} else {
			String booksCount = this.numberOfBooks() > 1 ? " books): \n" : " book): \n";
			builder = new StringBuilder("Free shopping cart (");
			builder.append(this.numberOfBooks()).append(booksCount);
			for (Book book : this.books) {
				builder.append("- ").append(book).append("\n");
			}
		}
		return builder.toString();
	}

	/*
	 * Ex3 - Q.02
	 * 
	 * public Optional<Book> longestTitle() { if (this.numberOfBooks() == 0) {
	 * return Optional.empty(); } Book longestTitleBook = this.books.get(0); for
	 * (int i = 1; i < this.numberOfBooks(); i++) { int longestTitleBookLength =
	 * longestTitleBook.title().length(); int currentBookLength =
	 * this.books.get(i).title().length(); if (longestTitleBookLength <=
	 * currentBookLength) { if (longestTitleBookLength == currentBookLength) {
	 * continue; } else { longestTitleBook = this.books.get(i); } } }
	 * 
	 * return Optional.ofNullable(longestTitleBook); }
	 * 
	 */

	/*
	 * Ex3 - Q.03
	 * 
	 * public Optional<Book> longestTitle() { if (this.numberOfBooks() == 0) {
	 * return Optional.empty(); }
	 * 
	 * Book longestTitleBook = this.books.get(0); Iterator<Book> iterator =
	 * this.books.iterator();
	 * 
	 * while (iterator.hasNext()) { int longestTitleBookLength =
	 * longestTitleBook.title().length(); int currentBookLength =
	 * iterator.next().title().length(); if (longestTitleBookLength <=
	 * currentBookLength) { if (longestTitleBookLength == currentBookLength) {
	 * continue; } else { longestTitleBook = iterator.next(); } } }
	 * 
	 * return Optional.ofNullable(longestTitleBook); }
	 * 
	 */

	// Ex3 - Q.04
	// How does the compiler compile a for each loop on a collection?

	public Optional<Book> longestTitle() {
		if (this.numberOfBooks() == 0) {
			return Optional.empty();
		}

		Book longestTitleBook = this.books.get(0);

		for (Book book : this.books) {
			int longestTitleBookLength = longestTitleBook.title().length();
			int currentBookLength = book.title().length();
			if (longestTitleBookLength <= currentBookLength) {
				if (longestTitleBookLength == currentBookLength) {
					continue;
				} else {
					longestTitleBook = book;
				}
			}
		}

		return Optional.ofNullable(longestTitleBook);
	}

	// Ex3 - Q.05

	// For an Array List of length N, the complexity is O(N).

	/*
	 * 
	 * public boolean removeFirstOccurence(Book book) { return
	 * this.books.remove(book); }
	 * 
	 */

	// Ex3 - Q.06

	// For an Array List of length N, using iterator, the complexity is O(N). In the
	// best case, it is O(1).

	public void removeFirstOccurence(Book book) {
		Iterator<Book> iterator = this.books.iterator();
		while (iterator.hasNext()) {
			Book b = iterator.next();
			if (b.equals(book))
				iterator.remove();
		}
	}

	// Ex3 - Q.07

	// We should use iterators if we need to modify collection or delete items in
	// our loop because it would be way more efficient in terms of time complexity.

}

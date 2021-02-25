import java.util.ArrayList;
import java.util.Iterator;

public class FreeShoppingCart {

	final private ArrayList<Book> books;

	public FreeShoppingCart() {
		this.books = new ArrayList<Book>();
	}

	public boolean add(Book book) {
		return this.books.add(book);
	}

	public int numberOfBooks() {
		return this.books.size();
	}

	@Override
	public String toString() {
		String booksCount = this.numberOfBooks() > 1 ? " books): \n" : " book): \n";
		StringBuilder builder = new StringBuilder("Free shopping cart (");
		builder.append(this.numberOfBooks()).append(booksCount);
		for (Book book : this.books) {
			builder.append("- ").append(book).append("\n");
		}

		return builder.toString();
	}

	/*
	 * Ex3 - Q.02
	 * 
	 * public Book longestTitle() { Book longestTitleBook = this.books.get(0);
	 * boolean sameLength = false; for (int i = 1; i < this.numberOfBooks(); i++) {
	 * if (longestTitleBook.title().length() <= this.books.get(i).title().length())
	 * { if (longestTitleBook.title().length() ==
	 * this.books.get(i).title().length()) { sameLength = true; } else { sameLength
	 * = false; longestTitleBook = this.books.get(i); } } }
	 * 
	 * if(sameLength) return null;
	 * 
	 * return longestTitleBook; }
	 * 
	 */

	/*
	 * 
	 * ·Ex3 - Q.03
	 * 
	 * public Book longestTitle() { Book longestTitleBook = this.books.get(0);
	 * boolean sameLength = false;
	 * 
	 * Iterator<Book> iterator = this.books.iterator();
	 * 
	 * while(iterator.hasNext()) { if (longestTitleBook.title().length() <=
	 * iterator.next().title().length()) { if (longestTitleBook.title().length() ==
	 * iterator.next().title().length()) { sameLength = true; } else { sameLength =
	 * false; longestTitleBook = iterator.next(); } } }
	 * 
	 * if (sameLength) return null;
	 * 
	 * return longestTitleBook; }
	 * 
	 */

	// Ex3 - Q.04

	// How does the compiler compile a for each loop on a collection?

	public Book longestTitle() {
		Book longestTitleBook = this.books.get(0);
		boolean sameLength = false;

		for (Book book : this.books) {
			if (longestTitleBook.title().length() <= book.title().length()) {
				if (longestTitleBook.title().length() == book.title().length()) {
					sameLength = true;
				} else {
					sameLength = false;
					longestTitleBook = book;
				}
			}
		}

		if (sameLength)
			return null;

		return longestTitleBook;
	}

	// Ex3 - Q.05

	// For an Array List of length N, the complexity is O(N) for the average and
	// worst cases.
	// In the best case, the complexity is actually O(1).

	/*
	 * 
	 * public boolean removeFirstOccurence(Book book) { return
	 * this.books.remove(book); }
	 * 
	 */

	// Ex3 - Q.06

	// Time complexity:

	public void removeFirstOccurence(Book book) {
		Iterator<Book> iterator = this.books.iterator();
		while (iterator.hasNext()) {
			Book b = iterator.next();
			if (b.equals(book))
				iterator.remove();
		}
	}
	
	// Ex3 - Q.07
	
	// 

}

import java.util.Objects;

public class Book {

	final static private String noAuthor = new String("<no author>");
	
	final private String title;
	final private String author;

	public Book(final String title, final String author) {
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
	}

	public Book(final String t) {
		this(t, noAuthor);
	}

	public Book() {
		this("", noAuthor);
	}

	public String title() {
		return title;
	}

	public String author() {
		return author;
	}

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

	@Override
	public String toString() {
		if(title.isEmpty()) { return noAuthor + "!"; }
		if(!title.isEmpty() && author == (noAuthor)) {
			return title;
		}
		
		return title + " by " + author;
	}

}

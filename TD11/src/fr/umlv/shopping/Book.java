package fr.umlv.shopping;

import java.util.Objects;

public class Book extends Item {
	private final String author;
	private final String title;
	private final int price;

	public Book(String author, String title, int price) {
		if (price < 0) {
			throw new IllegalArgumentException("no negative price!");
		}
		this.price = price;
		this.author = Objects.requireNonNull(author);
		this.title = Objects.requireNonNull(title);
	}

	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	protected String getType() {
		return "B";
	}
	
	@Override
	protected String getProps() {
		return this.price + SaverLoader.SEPARATOR + this.title + SaverLoader.SEPARATOR + this.author;
	}

	@Override
	public String toString() {
		return title + ", from " + author;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Book)) {
			return false;
		}
		var b = (Book) o;
		return price == b.price && title.equals(b.title) && author.equals(b.author);
	}

	@Override
	public int hashCode() {
		return price ^ author.hashCode() ^ title.hashCode();
	}
}
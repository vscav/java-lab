package fr.umlv.shopping;

import java.util.Objects;

public class Book extends DigitalItem {
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
		return this.price;
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
		return this.title + ", from " + this.author;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Book)) {
			return false;
		}
		var b = (Book) o;
		return this.price == b.price && this.title.equals(b.title) && this.author.equals(b.author);
	}

	@Override
	public int hashCode() {
		return this.price ^ this.author.hashCode() ^ this.title.hashCode();
	}
}
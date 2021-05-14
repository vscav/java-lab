package fr.umlv.shopping;

import java.util.Objects;

public class VideoGame extends DigitalItem {
	public enum Console { // enum are static
		PS3, PS4, XBOX, WII, DS
	};

	private final String title;
	private final Console console;
	private final int price;

	public VideoGame(String title, Console console, int price) {
		if (price < 0) {
			throw new IllegalArgumentException("no negative price!");
		}
		this.price = price;
		this.title = Objects.requireNonNull(title);
		this.console = Objects.requireNonNull(console);
	}

	@Override
	public int getPrice() {
		return this.price;
	}
	
	@Override
	protected String getType() {
		return "G";
	}
	
	@Override
	protected String getProps() {
		return this.price + SaverLoader.SEPARATOR + this.title + SaverLoader.SEPARATOR + this.console;
	}

	@Override
	public String toString() {
		return this.title + ", for " + this.console.name();
	}
}
package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		if (year < 1900) {
			throw new IllegalArgumentException("Year must be after 1900");
		}
		this.year = year;
	}

	String type() {
		return "almanac of " + this.year;
	}
	
	@Override
	boolean isTimeless() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Magazine))
			return false;
		var other = (Almanac) obj;
		return super.equals(other) && this.year == other.year;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ this.year;
	}
}

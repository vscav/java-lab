import java.util.Objects;

class Pear implements Priceable {
	private final int juiceFactor;
	
	Pear(int juiceFactor) {
		if(juiceFactor > 9 || juiceFactor < 0) {
			throw new IllegalArgumentException("Juice factor must be in range [0, 9] (inclusive).");
		}
		this.juiceFactor = juiceFactor;
	}
	
	public int price() {
		return 3 * this.juiceFactor;
	}
	
	@Override
	public String toString() {
		return "Pear with juice factor of " + this.juiceFactor;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		if (!(other instanceof Pear)) {
			return false;
		}
		Pear pear = (Pear) other;

		return pear.juiceFactor == this.juiceFactor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.juiceFactor);
	}
}
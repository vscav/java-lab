import java.util.Objects;

class Apple implements Priceable {
	private final int weight;
	private final AppleKind type;

	Apple(int weight, AppleKind type) {
		if (weight <= 0) {
			throw new IllegalArgumentException("Weight must be strictly positive.");
		}
		this.weight = weight;
		this.type = Objects.requireNonNull(type, "The apple must have a named type.");
	}

	public int price() {
		return this.weight / 2;
	}

	@Override
	public String toString() {
		return this.type + " " + this.weight + " g";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		if (!(other instanceof Apple)) {
			return false;
		}
		Apple apple = (Apple) other;

		// Use of '==' on type because it's an enum, so null safe
		return apple.type == this.type && apple.weight == this.weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.type, this.weight);
	}
}

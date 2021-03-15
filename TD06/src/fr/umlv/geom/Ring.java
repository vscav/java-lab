package fr.umlv.geom;

// Ex2 - Q.01
// TODO

// Ex2 - Q.02
public class Ring extends Circle {

	private final int internalRadius;
	
	public int internalRadius() {
		return this.internalRadius;
	}

	// Ex2 - Q.03
	// Throw an ilegal argument exception in case the radius is smaller than the
	// internal radius.
	Ring(final Point point, final int radius, final int internalRadius) {
		super(point, radius);

		if (radius < internalRadius) {
			throw new IllegalArgumentException("Internal radius is greater than the radius.");
		}

		this.internalRadius = internalRadius;
	}
	
	@Override
	public String toString() {
		return super.toString() + " with internal radius of " + this.internalRadius;
	}
	
	public boolean contains(final Point p) {
		Circle internalCircle = new Circle(center(), internalRadius);
		return super.contains(p) && !internalCircle.contains(p);
	}
	
	public boolean contains(final Point p, final Ring... rings) {
		// TODO
		return true;
	}
}

package fr.umlv.geom;

// Ex2 - Q.01
// The idea behind inheritance in Java is that you can create new classes
// that are built upon existing classes.
// When you inherit from an existing class, you can reuse methods and fields of the parent class.
// Moreover, you can add new methods and fields in your current class also.
// It can be useful to avoid coding redundant code.

// Ex2 - Q.02
// Class Ring that extends the class Circle.
public class Ring extends Circle {

	private final int internalRadius;

	// Ex2 - Q.03
	// Throw an ilegal argument exception in case the radius is smaller than the
	// internal radius.
	public Ring(final Point point, final int radius, final int internalRadius) {
		super(point, radius);

		if (radius < internalRadius) {
			throw new IllegalArgumentException("Internal radius is greater than the radius.");
		}

		this.internalRadius = internalRadius;
	}

	// Ex2 - Q.04
	// Using "super" keyword, we call the toString method which was overriden in the
	// Circle class and add the specific behaviour (internal radius).
	@Override
	public String toString() {
		return super.toString() + " with internal radius of " + this.internalRadius;
	}

	@Override
	public boolean contains(final Point p) {
		Circle internalCircle = new Circle(getCenter(), internalRadius);
		return super.contains(p) && !internalCircle.contains(p);
	}

	public static boolean contains(final Point p, final Ring... rings) {
		return Circle.contains(p, rings);
	}
}

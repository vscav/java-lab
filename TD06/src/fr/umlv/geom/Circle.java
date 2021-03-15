package fr.umlv.geom;

public class Circle {
	private final static int DEFAULT_X = 0;
	private final static int DEFAULT_Y = 0;
	private final static int DEFAULT_RADIUS = 10;

	// Ex1 - Q.02
	// We should use private final to declare our fields.
	private final Point center;
	private final int radius;

	Circle(final Point point, final int radius) {
		// Ex1 - Q.06
		// To avoid this behaviour, we have to copy the point and not only its
		// reference.

		// Avoid doing the following: this.center = point;
		this.center = new Point(point.getX(), point.getY());

		this.radius = radius;
	}

	Circle(final int x, final int y, final int r) {
		this.center = new Point(x, y);
		this.radius = r;
	}

	Circle() {
		this(DEFAULT_X, DEFAULT_Y, DEFAULT_RADIUS);
	}

	@Override
	public String toString() {
		return "(" + center + ',' + radius + ',' + this.area() + ')';
	}

	public void translate(final int dx, final int dy) {
		this.center.translate(dx, dy);
	}

	public Point center() {
		// Ex1 - Q.07
		// Return a reference but can be modify outside the class (dangerous behaviour)
		// return this.center;
		return new Point(this.center.getX(), this.center.getY());
	}

	// Ex1 - Q.08
	public double area() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	// Ex1 - Q.09
	public boolean contains(final Point p) {
		if ((this.center.getX() - p.getX()) * (this.center.getX() - p.getX())
				+ (this.center.getY() - p.getY()) * (this.center.getY() - p.getY()) <= Math.pow(this.radius, 2))
			return true;
		else
			return false;
	}

	// Ex1 - Q.10
	// "..." is the spread operator. It is a short-hand for methods that support an
	// arbitrary number of parameters of one type (here we can have different number
	// of circles to test).
	public boolean contains(final Point p, final Circle... circles) {
		boolean result = false;

		for (final Circle c : circles) {
			result = result || c.contains(p);
			if (result) {
				break;
			}
		}

		return result;
	}
}

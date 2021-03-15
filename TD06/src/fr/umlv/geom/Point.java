package fr.umlv.geom;

// Ex1 - Q.01
// The fields of the class are declared private.
// So when the method translate method can not asks to modify these fields.
// Point are indeed immutable.
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ',' + y + ')';
	}

	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
}

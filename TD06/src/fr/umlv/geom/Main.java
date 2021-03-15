package fr.umlv.geom;

public class Main {

	public static void main(String[] args) {
		var point = new Point(1, 2);

		var circle = new Circle(point, 1);
		var circle2 = new Circle(point, 2);

		circle2.translate(1, 1);

		System.out.println(circle + " " + circle2);

		var p = new Point(1, 2);
		var c = new Circle(p, 1);
		var p2 = c.getCenter();
		p2.translate(1, 1);
		System.out.println(c);

		var point2 = new Point(1, 2);

		var circle3 = new Circle(point2, 2);
		System.out.println(circle3);

		try {
			var ring = new Ring(point2, 2, 1);
			System.out.println(ring);
			var point3 = new Point(-2, 2);
			var ring2 = new Ring(point2, 3, 1);
			var ring3 = new Ring(point2, 2, 1);
			System.out.println(Ring.contains(point3, ring2, ring3) ? "Point 4 is contained in ring 2 or ring 3"
					: "Point 4 is NOT contained in ring 2 and ring 3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

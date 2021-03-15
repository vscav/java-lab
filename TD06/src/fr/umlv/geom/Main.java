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
		var p2 = c.center();
		p2.translate(1, 1);
		System.out.println(c);
		
		var point2 = new Point(1, 2);
	    var circle3 = new Circle(point2, 2);
	    System.out.println(circle3);
	    var point3 = new Point(1, 1);
	    try {
		    var ring = new Ring(point2, 2, 1);
		    System.out.println(ring);
		    var ring2 = new Ring(point2, 2, 0);
		    System.out.println(ring2.contains(point3));
	    } catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

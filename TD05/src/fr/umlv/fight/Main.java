package fr.umlv.fight;

public class Main {

	public static void main(String[] args) {
		// Exercise 1: tests

		// Fight between two robots
		var d2r2 = new Robot("D2R2");
		var data = new Robot("Data");
		try {
			System.out.println(Arena.fight(d2r2, data) + " is the winner");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Exercise 2: tests

		// Fight between a robot and a human fighter
		Robot c3po = new Robot("C3PO");
		Fighter blake = new Fighter("Blake");
		try {
			System.out.println(Arena.fight(c3po, blake) + " wins");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Fight between two human fighters
		Fighter john = new Fighter("John", 1);
		Fighter jane = new Fighter("Jane", 2);
		try {
			System.out.println(Arena.fight(john, jane) + " wins");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

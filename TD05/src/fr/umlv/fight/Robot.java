package fr.umlv.fight;

public class Robot {

	// Ex2 - Q.03

	// All the fields should always be declared as private to avoid random access
	// and mutability.

	private final String name;
	private int lifePoints;
	private boolean isDead;

	public Robot(final String name) {
		this.name = name;
		this.lifePoints = 20;
		this.isDead = false;
	}

	// Ex2 - Q.06
	
	// It should have a protected visibility because it will be overridden in the Fighter class.
	
	protected boolean rollDice() {
		return true;
	}
	
	protected String getType() {
		return "Robot";
	}
	
	public boolean isDead() {
		return this.isDead;
	}

	@Override
	public String toString() {
		return getType() + " " + this.name;
	}

	// Ex2 - Q.04 and Q.05

	// Use of IllegalStateException to handle the already dead issue. No duplicate
	// of error handling due to copy/pasting cause the fire method is implemented only once.

	protected void fire(Robot other) {
		if (rollDice()) {
			if (other.isDead) {
				throw new IllegalStateException("Shooting an already dead player is forbidden.");
			}
			other.lifePoints -= 2;
			if (other.lifePoints <= 0)
				other.isDead = true;
			System.out.println(other + " was hit by " + this);
		} else {
			System.out.println(this + " missed his shot");
		}
	}

	// Exercise 1: tests
	public static void main(String[] args) {
		var d2r2 = new Robot("D2R2");
		var data = new Robot("Data");
		try {
			System.out.println(Arena.fight(d2r2, data) + " is the winner");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

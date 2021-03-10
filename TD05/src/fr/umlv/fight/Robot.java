package fr.umlv.fight;

import java.util.Objects;

public class Robot {

	// Ex2 - Q.03

	// All the fields should always be declared as private to avoid random access
	// and mutability.
	// We should not declare field as protected because sub-classes could use it and
	// then avoid any (intern) modifications of your class.

	private final String name;
	private int lifePoints;
	private boolean isDead;

	public Robot(final String name) {
		this.name = Objects.requireNonNull(name);
		this.lifePoints = 20;
		this.isDead = false;
	}

	// Ex2 - Q.06

	// It should have a default visibility (not private) because it will be
	// overridden in the Fighter class. In this case, it is better than using a
	// protected visibility.

	boolean rollDice() {
		return true;
	}

	String getType() {
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
	// of error handling due to copy/pasting because the fire method is implemented
	// only once.

	public void fire(Robot other) {
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

}

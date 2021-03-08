package fr.umlv.fight;

import java.util.Random;

public class Fighter extends Robot {

	// Ex2 - Q.01

	// A pseudo random generator is an algorithm that uses mathematical formulas to
	// produce sequences of random
	// numbers. It generates a sequence of numbers approximating the properties of
	// random numbers.
	// It starts from an arbitrary starting state using what we called a seed state.

	private final Random randomGenerator;

	public Fighter(final String name) {
		this(name, System.currentTimeMillis());
	}

	public Fighter(final String name, final long seed) {
		super(name);
		this.randomGenerator = new Random(seed);
	}

	@Override
	protected boolean rollDice() {
		return this.randomGenerator.nextBoolean();
	}

	@Override
	protected String getType() {
		return "Fighter";
	}
	
	// Ex2 - Q.09
	
	// 

	// Exercise 2: tests
	public static void main(String[] args) {
		// Fight between a robot and a human fighter
		Robot d2r2 = new Robot("D2R2");
		Fighter nils = new Fighter("Nils");
		try {
			System.out.println(Arena.fight(d2r2, nils) + " wins");
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

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
	boolean rollDice() {
		return this.randomGenerator.nextBoolean();
	}

	@Override
	String getType() {
		return "Fighter";
	}

	// Ex2 - Q.09

	// Subtyping:
	//
	// Let’s take a type A and a type B. Type B is called a
	// subtype of type A if an instance of B can be used in every situation where an
	// instance of A is required. In a way, the subtype does everything the
	// supertype does and then some more, so it can be used as substitute for the
	// “parent” or “supertype”.
	//
	// Example:
	// static Robot fight(Robot first, Robot second)
	//
	// The previous line indicates that a fight always take place
	// between two Robots. But as Fighter extends Robot, a fight can also take place
	// between a Robot and a Fighter. When a Fighter is passed to the fight method,
	// it is subtyping.
	//
	// Polymorphism:
	//
	// Polymorphism means "many forms", and it occurs when we have classes that
	// are related to each other by inheritance.
	// Inheritance lets us inherit
	// attributes and methods from another class. Polymorphism uses those methods to
	// perform different tasks. This allows us to perform a single action in
	// different ways.
	//
	// Example:
	// rollDice()
	//
	// Depending of the object that calls the fire method, the implementation of the
	// rollDice method (and so its behaviour) will not be the same.

}

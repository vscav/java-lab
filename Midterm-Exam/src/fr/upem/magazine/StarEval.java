package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int stars;
	private final String comment;

	public StarEval(int stars, String comment) {
		this.comment = Objects.requireNonNull(comment);
		if (stars < 0 || stars > 5) {
			throw new IllegalArgumentException("");
		}
		this.stars = stars;
	}

	@Override
	public int score() {
		return (20 * this.stars) - 50;
	}

	@Override
	public String toString() {
		return "*".repeat(this.stars) + " " + this.comment;
	}
}

package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private final ArrayList<Eval> evals = new ArrayList<Eval>();

	public Magazine(String name, int price) {
		this.name = Objects.requireNonNull(name);
		if (price < 0) {
			throw new IllegalArgumentException("Price needs to be positive.");
		}
		this.price = price;
	}

	public int price() {
		return this.price;
	}

	public void price(int newValue) {
		if (price < 0) {
			throw new IllegalArgumentException("Price needs to be positive.");
		}
		this.price = newValue;
	}

	String type() {
		return "magazine";
	}

	@Override
	public String toString() {
		return this.name + " " + this.type() + " at " + this.price + "€";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Magazine))
			return false;
		var other = (Magazine) obj;
		return this.name.equals(other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}

	public void addEval(Eval eval) {
		this.evals.add(Objects.requireNonNull(eval));
	}

	public double averageScore() {
		return this.evals.stream().mapToDouble(e -> e.score()).reduce(0.0, Double::sum) / this.evals.size();
	}

	public List<Eval> lastFiveEvals() {
		var last = new ArrayList<Eval>();
		for (int i = Math.max(0, this.evals.size() - 5); i < this.evals.size(); i++) {
			last.add(this.evals.get(i));
		}
		return last;
	}

	public Eval worstEval() {
		Eval worst = null;
		var worstScore = 51;
		for (var eval : this.evals) {
			var s = eval.score();
			if (s < worstScore) {
				worst = eval;
			}
		}
		return worst;
	}

	boolean isTimeless() {
		return false;
	}

	public boolean isMoreTrendy(Magazine other) {
		Objects.requireNonNull(other);
		var thisIsTimeless = this.isTimeless();
		var otherIsTimeless = other.isTimeless();

		if (thisIsTimeless == otherIsTimeless) {
			return this.averageScore() >= other.averageScore();
		}
		if (thisIsTimeless)
			return true;

		return false;
	}
}

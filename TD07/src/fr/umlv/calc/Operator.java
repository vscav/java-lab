package fr.umlv.calc;

// Ex2 - Q.05
// We can create an Operator class which will implement Expr class and which we will
// used to extend our existing Add and Sub classes.
// We create two getters with a protected visibility in a way that Add and Sub objects can use it as well.
// In order to verify our tests in the main class, we need to override the toString method.
// It makes mandatory the creation of a getter to get the correct sign of the expression as a String.
// To do that, we create an abstract method that has to be defined in the Add and Sub classes.
public abstract class Operator implements Expr {
	private final Expr right;
	private final Expr left;

	public Operator(Expr left, Expr right) {
		this.right = right;
		this.left = left;
	}

	protected Expr right() {
		return this.right;
	}

	protected Expr left() {
		return this.left;
	}

	public abstract String getOperatorAsString();

	@Override
	public String toString() {
		return "(" + this.left + getOperatorAsString() + this.right + ")";
	}
}

package fr.umlv.calc;

public class Add extends Operator {
	
	public Add(Expr left, Expr right) {
		super(left, right);
	}

	// Ex2 - Q.03 and Q.05
	@Override
	public int eval() {
		return left().eval() + right().eval();
	}

	@Override
	public String getOperatorAsString() {
		return " + ";
	}
}

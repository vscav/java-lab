package fr.umlv.calc;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
// import java.util.Scanner;

public class OpOrValue {
	public static final int OP_NONE = 0;
	public static final int OP_ADD = 1;
	public static final int OP_SUB = 2;

	private final int operator;
	private final int value;
	private final OpOrValue left;
	private final OpOrValue right;

	// Ex1 - Q.01
	// It is declared private as it will be called only by the class itself.
	// We don't want the user to define a value AND an operator.
	private OpOrValue(int operator, int value, OpOrValue left, OpOrValue right) {
		this.operator = operator;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public OpOrValue(int value) {
		this(OP_NONE, value, null, null);
	}

	// Ex1 - Q.02
	// We have to handle the operator argument by using an exception in case it is
	// not a valid operator.
	public OpOrValue(int operator, OpOrValue left, OpOrValue right) {
		this(operator, 0, Objects.requireNonNull(left), Objects.requireNonNull(right));
		if (operator != OP_ADD && operator != OP_SUB) {
			throw new IllegalArgumentException("Operator " + operator + " not valid.");
		}
	}

	public int eval() {
		switch (operator) {
		case OP_ADD:
			return left.eval() + right.eval();
		case OP_SUB:
			return left.eval() - right.eval();
		default: // case OP_NONE:
			return value;
		}
	}

	// Ex1 - Q.03
	/*
	 * public static OpOrValue parse(Scanner scanner) { var result =
	 * parseRec(scanner); if (scanner.hasNext()) { throw new
	 * IllegalStateException("Ill-formed expression."); } return result; }
	 */

	// Ex1 - Q.03
	/*
	 * public static OpOrValue parseRec(Scanner scanner) { if (!scanner.hasNext()) {
	 * throw new IllegalArgumentException("Ill formed expression."); }
	 * 
	 * String token = scanner.next();
	 * 
	 * try { int value = Integer.parseInt(token); return new OpOrValue(value); }
	 * catch (NumberFormatException e) { OpOrValue left = parseRec(scanner);
	 * OpOrValue right = parseRec(scanner);
	 * 
	 * int operator;
	 * 
	 * switch (token) { case "+": operator = OP_ADD; break; case "-": operator =
	 * OP_SUB; break; default: throw new
	 * IllegalArgumentException("Unvalid operator."); }
	 * 
	 * return new OpOrValue(operator, left, right); } }
	 */
	
	// Ex1 - Q.06
	public static OpOrValue parse(Iterator<String> iterator) {
		var result = parseRec(iterator);
		if (iterator.hasNext()) {
			throw new IllegalStateException("Ill-formed expression.");
		}
		return result;
	}
	
	// Ex1 - Q.06
	public static OpOrValue parseRec(Iterator<String> iterator) {
		if (!iterator.hasNext()) {
			throw new IllegalArgumentException("Ill formed expression.");
		}

		String token = iterator.next();

		try {
			int value = Integer.parseInt(token);
			return new OpOrValue(value);
		} catch (NumberFormatException e) {
			OpOrValue left = parseRec(iterator);
			OpOrValue right = parseRec(iterator);

			int operator;

			switch (token) {
			case "+":
				operator = OP_ADD;
				break;
			case "-":
				operator = OP_SUB;
				break;
			default:
				throw new IllegalArgumentException("Unvalid operator.");
			}

			return new OpOrValue(operator, left, right);
		}
	}

	// Ex1 - Q.06
	static public OpOrValue parse(Collection<String> collection) {
		return parse(collection.iterator());
	}

	// Ex1 - Q.05
	private String getOperator() {
		switch (this.operator) {
		case OP_ADD:
			return " + ";
		case OP_SUB:
			return " - ";
		default:
			return " null ";
		}
	}

	@Override
	public String toString() {
		if (this.operator == OP_NONE) {
			return Integer.toString(this.value);
		} else {
			return "(" + this.left + getOperator() + this.right + ")";
		}
	}

}
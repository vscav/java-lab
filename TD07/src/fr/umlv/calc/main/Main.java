package fr.umlv.calc.main;

import java.util.Scanner;
import java.util.Vector;

import fr.umlv.calc.Add;
import fr.umlv.calc.Expr;
import fr.umlv.calc.OpOrValue;
import fr.umlv.calc.Value;

public class Main {

	public static void main(String[] args) {
		// Initial test
		OpOrValue expression1 = new OpOrValue(1, new OpOrValue(2), new OpOrValue(3));
		System.out.println(expression1); // (2 + 3)
		System.out.println(expression1.eval()); // 5

		// Ex1
		Scanner scanner1 = new Scanner("- + 3 2 4");
		OpOrValue expression2 = OpOrValue.parse(scanner1);
		System.out.println(expression2); // ((3 + 2) - 4)
		System.out.println(expression2.eval()); // 1

		// Ex2
		Vector<String> vector = new Vector<String>();
		vector.add("-");
		vector.add("+");
		vector.add("3");
		vector.add("2");
		vector.add("4");
		Expr expression3 = Expr.parse(vector);
		System.out.println(expression3); // ((3 + 2) - 4)
		System.out.println(expression3.eval()); // 1

		Expr expression4 = new Add(new Value(2), new Value(3));
		System.out.println(expression4); // (2 + 3)
		System.out.println(expression4.eval()); // 5

		Expr expression5 = Expr.parse(new Scanner("- + 3 2 4"));
		System.out.println(expression5); // ((3 + 2) - 4)
		System.out.println(expression5.eval()); // 1

		Expr expression6 = Expr.parse(new Scanner("- + 3 2 4"));
		System.out.println(expression6); // ((3 + 2) - 4)
		System.out.println(expression6.eval()); // 1

		Expr expression7 = Expr.parse(new Scanner("- 3 + 2 8"));
		System.out.println(expression7); // (3 - (2 + 8))
		System.out.println(expression7.eval()); // -7
	}

}

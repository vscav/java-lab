
// Import(s) of package(s)
import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int sum;
		int diff;
		int prod;
		float quot;
		int rest;

		// nexInt() is not a function but a method of the class Scanner (see below).

		System.out.print("Enter first integer: ");
		int a = scanner.nextInt();

		System.out.print("Enter second integer: ");
		int b = scanner.nextInt();

		sum = a + b;
		System.out.printf("Sum = %d\n", sum);

		diff = a - b;
		System.out.printf("Difference = %d\n", diff);

		prod = a * b;
		System.out.printf("Product = %d\n", prod);

		try {
			quot = (float) a / b;
			System.out.printf("Quotient = %f\n", quot);
			rest = a % b;
			System.out.printf("Rest = %d\n", rest);
		} catch (ArithmeticException e) {
			System.out.println("Quotient: you should not divide a number by zero");
		}

		scanner.close();
	}

}

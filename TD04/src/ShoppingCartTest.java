import java.util.Optional;

public class ShoppingCartTest {

	public static void main(String[] args) {
		// Ex2 (ArrayShoppingCart) - Tests

		ArrayShoppingCart shoppingCart = new ArrayShoppingCart(5);

		shoppingCart.add((new Book("Ulysses", "James Joyce")));
		shoppingCart.add((new Book("Post Office", "Charles Bukowski")));
		shoppingCart.add((new Book("Wuthering Heights", "Emily Brontë")));

		System.out.println(shoppingCart);

		Optional<Book> opt = shoppingCart.longestTitle();
		if (opt.isPresent()) {
			System.out.println(
					opt.get() + " is the book with the longest title currently in the Array shopping cart. \n");
		} else {
			System.out.println("Sorry, no longest title book because the array shopping cart is currently empty. \n");
		}

		// Ex3 (FreeShoppingCart) - Tests

		FreeShoppingCart freeShoppingCart = new FreeShoppingCart();

		Book bookToRemoved = new Book("The Black Dahlia", "James Ellroy");

		freeShoppingCart.add(new Book("Don Quixote", "Miguel de Cervantes"));
		freeShoppingCart.add(bookToRemoved);
		freeShoppingCart.add(new Book("War and Peace", "Leo Tolstoy"));

		System.out.println(freeShoppingCart);

		opt = freeShoppingCart.longestTitle();
		if (opt.isPresent()) {
			System.out
					.println(opt.get() + " is the book with the longest title currently in the Free shopping cart. \n");
		} else {
			System.out.println("Sorry, no longest title book because the free shopping cart is currently empty. \n");
		}

		// Ex3 - Q.05
		// boolean removeStatus = freeShoppingCart.removeFirstOccurence(bookToRemoved);
		// if(removeStatus) System.out.println(bookToRemoved + " has been successfully
		// removed from the Free shopping cart. \n");

		freeShoppingCart.removeFirstOccurence(bookToRemoved);
		System.out.println(bookToRemoved + " has been successfully removed from the Free shopping cart. \n");

		System.out.println(freeShoppingCart);
	}

}

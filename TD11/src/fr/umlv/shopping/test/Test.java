package fr.umlv.shopping.test;

import fr.umlv.shopping.Book;
import fr.umlv.shopping.PrePaid;
import fr.umlv.shopping.ShoppingCart;
import fr.umlv.shopping.VideoGame;

public class Test {

	public static void main(String[] args) {
		var cart = new ShoppingCart();

		cart.add(new Book("J. Kessel", "L'ArmÃ©e des ombres", 850));
		cart.add(new Book("S. Zweig", "Le joueur d'Ã©checs", 700));
		cart.add(new Book("Lorie", "Mes Secrets", 1020));
		System.out.println(cart);
		System.out.println(cart.price() + " euros cents\n");
		cart.remove(new Book("Lorie", "Mes Secrets", 1020));
		cart.add(new Book("S. de Beauvoir", "MÃ©moires d'une jeune fille rangÃ©e", 990));
		System.out.println(cart);
		System.out.println(cart.price() + " euros cents");

		var zelda = new VideoGame("The legend of Zelda", VideoGame.Console.WII, 4950);
		System.out.println(zelda + ", " + zelda.getPrice() + " euros cents");
		var pp50 = new PrePaid(5000, 2);
		System.out.println(pp50 + ", " + pp50.getPrice() + " euros cents");
		var pp100 = new PrePaid(10000, 10);
		System.out.println(pp100 + ", " + pp100.getPrice() + " euros cents");
	}
}
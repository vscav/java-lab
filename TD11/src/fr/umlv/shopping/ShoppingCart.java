package fr.umlv.shopping;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {
	private final ArrayList<DigitalItem> cart;

	public ShoppingCart() {
		this.cart = new ArrayList<>();
	}

	public void add(DigitalItem item) {
		Objects.requireNonNull(item);
		this.cart.add(item);
	}

	public void remove(DigitalItem item) {
		this.cart.remove(item);
	}

	// Ex3 - Q.01, Q.02 and Q.03
	// We can use a filter on the cart to count all items with a specific type (all
	// digital items have a getType method by contract)
	public int count(String type) {
		return this.cart.stream().filter(e -> e.getType().equals(type)).mapToInt(e -> 1).reduce(0, Integer::sum);
	}

	public int price() {
		var sum = 0;
		for (var item : this.cart) {
			if (count(item.getType()) > 1)
				sum += item.getPrice() * 0.95;
			else
				sum += item.getPrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- Shopping cart ---\n");
		for (var item : this.cart) {
			sb.append(item).append("\n");
		}
		sb.append("---------------------");
		return sb.toString();
	}
}
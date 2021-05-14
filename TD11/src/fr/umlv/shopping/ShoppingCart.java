package fr.umlv.shopping;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {
	private final ArrayList<DigitalItem> cart;

	public ShoppingCart() {
		cart = new ArrayList<>();
	}

	public void add(DigitalItem item) {
		Objects.requireNonNull(item);
		cart.add(item);
	}

	public void remove(DigitalItem item) {
		cart.remove(item);
	}

	public int price() {
		var sum = 0;
		for (var b : cart) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- Shopping cart ---\n");
		for (var item : cart) {
			sb.append(item).append("\n");
		}
		sb.append("---------------------");
		return sb.toString();
	}
}
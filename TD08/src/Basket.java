import java.util.Hashtable;
import java.util.Set;

class Basket {
	private final Hashtable<Priceable, Integer> basketItems;
	
	Basket() {
		this.basketItems = new Hashtable<Priceable, Integer>();
	}
	
	void add(Priceable fruit) {
		this.add(fruit, 1);
	}
	
	void add(Priceable fruit, int quantity) {
		this.basketItems.put(fruit, quantity);
	}
	
	@Override
	public String toString() {
        Set<Priceable> setOfBasketItems = this.basketItems.keySet();
		String res = "";
		int price = 0;
		for(Priceable key : setOfBasketItems) {
			res += key.toString() + " x " + this.basketItems.get(key) + "\n";
			price += key.price();
		}
		
		res += "price: " + price;
		
		return res;
	}
}

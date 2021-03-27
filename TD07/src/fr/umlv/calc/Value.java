package fr.umlv.calc;

public class Value implements Expr {
	private final int value;

	public Value(int value) {
		this.value = value;
	}
	
	// Ex2 - Q.03
	@Override
	public int eval() {
		return this.value;
	}
	
	@Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

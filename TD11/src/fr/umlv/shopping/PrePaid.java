package fr.umlv.shopping;

import java.util.Objects;

public class PrePaid extends DigitalItem {
	private final int value;
	private final int validTime;

	public PrePaid(int value, int validTime) {
		this.value = value;
		this.validTime = Objects.checkIndex(validTime, 52); // maximal validity: 1 year
	}

	@Override
	public int getPrice() {
		if (this.validTime <= 2) { // if validity less than 2 weeks,
			return this.value - this.value * 20 / 100; // 20% discount
		}
		return this.value;
	}
	
	@Override
	protected String getType() {
		return "P";
	}
	
	@Override
	protected String getProps() {
		return this.value + SaverLoader.SEPARATOR + this.validTime;
	}

	@Override
	public String toString() {
		return String.format("Pre-paid card (%d,%02dâ‚¬), validity: %s weeks)", this.value / 100, this.value % 100, this.validTime);
	}
}
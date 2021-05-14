package fr.umlv.shopping;

public abstract class DigitalItem implements Item {
	public String toTextFormat() {
		return getType() + SaverLoader.SEPARATOR + getProps();
	}
	
	abstract protected String getType();
	
	abstract protected String getProps();
}

package fr.umlv.shopping;

public abstract class Item implements DigitalItem {
	public String toTextFormat() {
		return getType() + SaverLoader.SEPARATOR + getProps();
	}
	
	abstract protected String getType();
	
	abstract protected String getProps();
}

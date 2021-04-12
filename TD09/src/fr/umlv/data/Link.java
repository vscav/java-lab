package fr.umlv.data;

import java.util.Objects;

// Ex1 - Q.01
// Visibility: package
// Indeed, it will be used by another 'LinkedLink' class which will handle the links but it won't be accessible otherwise
class Link<T> {
	final T value;
	final Link<T> next;

	// Ex1 - Q.01 - Tests
	// public static void main(String[] args) {
	// var link1 = new Link<Integer>(13);
	// var link2 = new Link<Integer>(144);
	// }

	Link(T value) {
		this(value, null);
	}

	Link(T value, Link<T> next) {
		this.value = Objects.requireNonNull(value);
		this.next = next;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}

package fr.umlv.data;

//Ex1 - Q.02
public class LinkedList<T> {
	private Link<T> link;
	private int size;

	public LinkedList() {
		this.link = null;
		this.size = 0;
	}

	// Ex1 - Q.02
	// add method: will add a new link at the begining of the linked list
	public void add(T value) {
		this.link = new Link<T>(value, this.link);
		this.size++;
	}

	// Ex2 - Q.01
	public T get(int index) {
		// If the list is empty
		if (this.size == 0) {
			throw new IllegalStateException("Linked list is empty.");
		}
		// If the index is invalid
		if (index < 0 || index > this.size - 1) {
			throw new IllegalArgumentException("index must be in range [0, size - 1].");
		}

		int count = 0;
		var tmp = this.link;
		while (count < this.size && count < index) {
			count++;
			tmp = tmp.next;
		}

		return tmp.value;
	}

	// Ex1 - Q.02
	// toString override
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		if (this.size > 0) {
			int i = 0;
			for (var tmp = this.link; tmp != null; tmp = tmp.next) {
				builder.append(tmp.value);
				if(i != this.size - 1) {
					builder.append(" - ");
				}
				i++;
			}
		} else {
			builder.append("empty");
		}
		
		builder.append("]");

		return builder.toString();
	}
	
	// Ex3 - Q.04
	// contains method
	// contains uses the function equals(Object o).
	// Then, the signature of equals will not work with the generic type T
	public boolean contains(Object o) {
		if(o == null) return false;
		
		Boolean res = o.equals(this.link.value);

		for (var link = this.link; link != null; link = link.next) {
            if (o.equals(link.value)) {
                res = true;
                break;
            }
        }
        
        return res;
	}
}

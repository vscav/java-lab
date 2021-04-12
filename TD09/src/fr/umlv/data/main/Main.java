package fr.umlv.data.main;

import fr.umlv.data.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(3);
		linkedList.add(8);
		System.out.println("Integer linked list content: " + linkedList);

		LinkedList<String> linkedList2 = new LinkedList<String>();
		linkedList2.add("foo");
		linkedList2.add("bar");
		linkedList2.add("baz");
		linkedList2.add("qux");
		System.out.println("String linked list content: " + linkedList2);

		try {
			System.out.println("The second String contains " + linkedList2.get(1).length() + " letters.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (linkedList2.contains("baz")) {
			System.out.println("The String linked list contains the word 'baz'.");
		}

		if (!linkedList2.contains("quux")) {
			System.out.println("The String linked list does not contain the word 'quux'.");
		}
	}

}

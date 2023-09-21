package org.TURNO.model;

import java.util.ArrayList;

public class Person {
	private String name;
	private int age;
	private final ArrayList<Item> ownedItems = new ArrayList<>();

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addItem(Item item) {
		if(!ownedItems.contains(item))
			ownedItems.add(item);
	}

	public void removeItem(Item item) {
		ownedItems.remove(item);
	}

	public int totalValue(){
		int res = 0;
		for(Item item : ownedItems)
			res += item.getValue();
		return res;
	}
}

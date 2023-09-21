package org.TURNO.io;

import org.TURNO.model.Person;

import java.util.ArrayList;

public class PrettyPrinter {
	public static void printPeople(ArrayList<Person> people){
		System.out.println("--------------------------------------------------------------------------------");
		for(Person p : people)
			System.out.println("Name: " + p.getName() + " | Age: " + p.getAge() + " | Owned Value: " + p.totalValue());
		System.out.println("--------------------------------------------------------------------------------");
	}
}

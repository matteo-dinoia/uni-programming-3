package org.TURNO.io;

import org.TURNO.model.Person;

import java.util.ArrayList;

public class PrettyPrinter {
	public static void printPeople(ArrayList<Person> people){
		final String sep = "--------------------------------------------------------------------------------\n";
		for(Person p : people)
			System.out.print(sep + "Name: " + p.getName() + " | Age: " + p.getAge() + " | Owned Value: " + p.totalValue() + "\n" + sep);
	}
}

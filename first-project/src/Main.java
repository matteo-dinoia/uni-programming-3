import org.TURNO.io.PrettyPrinter;
import org.TURNO.model.Item;
import org.TURNO.model.Person;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Item i1 = new Item("Pen", 2);
		Item i2 = new Item("Pencil", 1);
		Item i3 = new Item("Compass", 10);
		Person p1 = new Person("Marco", 21);
		Person p2 = new Person("Giorgio", 32);

		p1.addItem(i1);
		p1.addItem(i1);
		p1.addItem(i2);
		p1.addItem(i3);

		p2.addItem(i1);
		p2.addItem(i2);
		p2.addItem(i3);
		p2.removeItem(i1);
		p2.removeItem(new Item("Pencil", 1));

		ArrayList<Person> p = new ArrayList<>();
		p.add(p1);
		p.add(p2);
		PrettyPrinter.printPeople(p);
	}
}

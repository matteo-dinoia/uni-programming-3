import model.calculation.Calculator;
import model.list.Queue;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void testQueue(){
		Queue<Integer> q = new Queue<>(new ArrayList<>());
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(21);
		System.out.println(q.dequeue());
		q.enqueue(30);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		Queue<Double> q2 = new Queue<>(new ArrayList<>());
		q2.enqueue(10.0);
		q2.enqueue(20.0);
		q2.enqueue(21.1);
		System.out.println(q2.dequeue());
		q2.enqueue(30.2);
		System.out.println(q2.dequeue());
		System.out.println(q2.dequeue());
		System.out.println(q2.dequeue());
		System.out.println(q2.dequeue());
	}

	private static void testCalculator() {
		List<Integer> list = new ArrayList<>();
		Calculator<Integer> c = new Calculator<>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		c.print(list);
		System.out.println("MAX: " + c.max(list));
		System.out.println(c.sum(list));

		System.out.println("----------------");
		List<Double> list2 = new ArrayList<>();
		Calculator<Double> c2 = new Calculator<>();
		list2.add(2.40324);
		list2.add(3.0432);
		list2.add(5.032);
		list2.add(7.1);
		c2.print(list2);
		System.out.println("MAX: " + c2.max(list2));
		System.out.println(c2.sum(list2));
	}

	public static void main(String[] args) {
		testQueue();
		testCalculator();

	}


}
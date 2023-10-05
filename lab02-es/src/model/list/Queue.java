package model.list;

import java.util.List;

public class Queue<T> {
	private List<T> list;

	public Queue(List<T> list){
		this.list = list;
	}

	public void enqueue(T toAdd){
		list.add(toAdd);
	}

	public T dequeue(){
		if(empty())
			throw new RuntimeException("Trying to dequeue an empty queue");

		T removed = list.get(0);
		list.remove(0);
		return removed;
	}

	public boolean empty(){
		return list.isEmpty();
	}
}

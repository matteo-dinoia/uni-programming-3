package model.geom;

import model.geom.figures.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Geometries<T extends Polygon> {
	private List<T> list;

	public Geometries(){
		list = new ArrayList<>();
	}

	public boolean add(T toAdd){
		//TODO must be single
		return this.add(toAdd);
	}

	public boolean remove(T toRemove){
		return this.remove(toRemove);
	}

	public int size(){
		return list.size();
	}

	public boolean empty(){
		return list.isEmpty();
	}

	public void printAreas(){
		if(empty()){
			System.out.println("Array is empty (no area found)");
			return;
		}

		for(int i = 0; i < size(); i++){
			System.out.println("Elemet " + i + " " + list.get(i).getArea());
		}
	}
}

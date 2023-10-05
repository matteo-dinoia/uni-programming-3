package model.calculation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Calculator<T extends Number & Comparable<T>> {
	public void print(List<T> list){
		if(list == null || list.isEmpty()){
			System.out.println("The list is empty");
			return;
		}

		for(int i = 1; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	public T sum(List<T> list){
		if(list == null || list.isEmpty())
			return null;

		T ret = list.get(0);
		Class c = ret.getClass();
		for(int i = 1; i < list.size(); i++){
			try {
				ret = (T) c.getMethod("sum", (Class<?>) c.getField("TYPE").get(c), (Class<?>) c.getField("TYPE").get(c))
					.invoke(ret, ret, list.get(i));
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
				 NoSuchFieldException e) {
				throw new RuntimeException("Cannot sum this numbers: " + e.getMessage() + "  <- " + e.getClass());
			}
		}
		return ret;
	}

	public T max(List<T> list){
		if(list == null || list.isEmpty())
			return null;

		T ret = list.get(0);
		for(int i = 1; i < list.size(); i++){
			if(ret.compareTo(list.get(i)) < 0)
				ret = list.get(i);
		}
		return ret;
	}

}

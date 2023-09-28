package figures;

import java.lang.reflect.Field;

public abstract class Polygon {
	private int numVertex;

	public Polygon(int numVertex){
		this.numVertex = numVertex;
	}

	public int getNumVertex(){
		return numVertex;
	}

	public abstract float getArea();

	@Override public boolean equals(Object obj){
		if(obj == null || this.getClass() != obj.getClass())
			return false;

		Field[] fields = this.getClass().getDeclaredFields();

		try {
			for(int i = 0; i < fields.length; i++){
				if(!((Float)fields[i].get(this) - (Float)fields[i].get(obj) < 0.01))
					return false;
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

		return true;
	}

	@Override public String toString(){
		String res = this.getClass().getName() + "\n";
		Field[] fields = this.getClass().getDeclaredFields();

		try {
			for(int i = 0; i < fields.length; i++){
				res += fields[i].getName() + " := "
						+ fields[i].get(this) + "\n";
			}
		} catch (IllegalAccessException e) {
			return "ERROR";
		}

		return res;
	}



	public String[] describeAttributes(){
		Field[] fields = this.getClass().getDeclaredFields();
		String[] res = new String[fields.length];

		for(int i = 0; i < fields.length; i++){
			res[i] = fields[i].getName();
		}

		return res;
	}
	//restituisce un array di stringhe contenente la descrizione di quali attributi sono necessari per descrivere il modello (es., [ ["base"],["height"] ])

	public boolean setAttributes(float[] attrs){
		Field[] fields = this.getClass().getDeclaredFields();

		if(attrs == null || fields.length != attrs.length)
			return false;
		else if(fields.length == 0)
			return true;


		for(int i = 0; i < fields.length; i++){
			try {
				fields[i].set(this, attrs[i]);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}

		return true;
	}
	//prende in input un array di Float che descrive i valori degli attributi nell'ordine indicato da describeAttributes e li assegna agli attributi corrispondenti.



}

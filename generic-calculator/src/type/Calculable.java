package type;

import model.Calculator;

public abstract class Calculable<T extends Comparable<T>> implements Comparable<Calculable<T>> {
    protected T value;
    public abstract void print();
    public abstract Calculable<T> add(Calculable<T> c);

    @Override
    public int compareTo(Calculable<T> el){
        if(this.value == null)
            return el == null || el.value == null ? 0 : -1;

        return this.value.compareTo(el.value);
    }

    @Override
    public String toString(){
        return value.toString();
    }
}

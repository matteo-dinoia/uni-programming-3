package type;

public class CalcInt extends Calculable<Integer> {

    public CalcInt(Integer val){
        this.value = val;
    }

    @Override
    public void print() {
        System.out.print(value);
    }

    @Override
    public Calculable<Integer> add(Calculable<Integer> c) {
        if(c == null || c.value == null)
            return null;

        return new CalcInt(this.value + c.value);
    }

}

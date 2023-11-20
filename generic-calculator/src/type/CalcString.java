package type;

public class CalcString extends Calculable<String> {

    public CalcString(String val){
        this.value = val;
    }

    @Override
    public void print() {
        System.out.println(value);
    }

    @Override
    public Calculable<String> add(Calculable<String> c) {
        if(c == null || c.value == null)
            return null;

        return new CalcString(this.value + c.value);
    }
}
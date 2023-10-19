package module;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Filter extends Observable implements Observer {
    private ArrayList<Integer> list = new ArrayList<Integer>();


    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof Counter){
            int value = ((Counter) observable).getValue();
            list.add(value);
            if(list.size() % 2 == 0){
                setChanged();
                notifyObservers(this);
            }
        }
    }

    public List<Integer> getList(){
        return new ArrayList<>(list);
    }
}

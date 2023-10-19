package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements Observer{
    private final ArrayList<String> proverb = new ArrayList<>();
    private int selected;

    public Model(){
        proverb.add("Carpe diem");
        proverb.add("Do tomorrow what you can do today");
        proverb.add("Always be late");
        proverb.add("Never sleep");
        proverb.add("Give up");
        proverb.add("Lol");
    }

    void selectRandom(){
        selected = (int) (Math.random() * proverb.size());
        setChanged();
        notifyObservers();
    }

    public String getSelectedString() {
        return proverb.get(selected);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Controller){
            selectRandom();
        }
    }

}

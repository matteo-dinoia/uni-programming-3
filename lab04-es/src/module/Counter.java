package module;

import java.util.Observable;

public class Counter extends Observable {
    private int value = 0;

    public void ciclo() {
        value = 0;

        for(value = 1; value <= 50; value++){
            if (value % 5 == 0){
                setChanged();
                notifyObservers();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getValue(){
        return value;
    }
}

package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Controller extends Observable implements ActionListener {
    //Could have used a final model here (is better)
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("generate")){
            setChanged();
            notifyObservers();
        }
    }
}

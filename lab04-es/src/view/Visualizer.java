package view;

import module.Filter;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Visualizer extends JFrame implements Observer {
    private JPanel p = new JPanel();
    public Visualizer(){
        this.add(p);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200, 100);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Filter){
            visualize(((Filter) observable).getList());
        }
    }

    public void visualize(List<Integer> list){
        p.removeAll();

        for(Integer i : list) {
            p.add(new JLabel("" + i));
        }

        this.setVisible(true);
    }
}

package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class PhraseFrame extends JFrame implements Observer {
    private JLabel label = new JLabel("");
    private JButton btn = new JButton("Generate");

    public PhraseFrame(){
        this.setTitle("Proverb Generator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContent();
        this.setSize(300, 100);
    }

    private void setContent(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        this.add(p);

        //BUTTON
        btn.setActionCommand("generate");
        JPanel padPanel = new JPanel();
        padPanel.add(btn);
        p.add(padPanel);

        //LABEL
        JPanel padPanel2 = new JPanel();
        padPanel2.add(label);
        p.add(padPanel2);
    }

    public void addActionListener(ActionListener lst){
        btn.addActionListener(lst);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Model){
            String val = ((Model) observable).getSelectedString();
            label.setText(val);
        }
    }
}

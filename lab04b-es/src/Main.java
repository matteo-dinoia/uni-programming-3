import model.Controller;
import model.Model;
import view.PhraseFrame;

public class Main {
    public static void main(String[] args) {
        PhraseFrame frame = new PhraseFrame();
        Model data = new Model();
        Controller ctr = new Controller();

        frame.addActionListener(ctr);
        ctr.addObserver(data);
        data.addObserver(frame);

        frame.setVisible(true);
    }
}
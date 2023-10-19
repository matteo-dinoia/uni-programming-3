import module.*;
import view.Visualizer;

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        Filter f = new Filter();
        Visualizer v = new Visualizer();

        c.addObserver(f);
        f.addObserver(v);
        v.setVisible(true);

        c.ciclo();
    }
}
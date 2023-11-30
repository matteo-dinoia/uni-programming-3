import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static List<Thread> getThreads() {
        ArrayList<Thread> threadList = new ArrayList<>();
        ConditionManager manager = new ConditionManager();
        Semaphore sem = new Semaphore(1);

        final int[] noWait = {};
        final int[] constraintsFor123 = {0};
        final int[] constraintsFor4 = {1, 2, 3};

        threadList.add(new Thread(new Azione(0, 2, noWait, manager)));
        threadList.add(new Thread(new Azione(1, 8, constraintsFor123, manager)));
        threadList.add(new Thread(new Azione(2, 3, constraintsFor123, manager)));
        threadList.add(new Thread(new Azione(3, 6, constraintsFor123, manager)));
        threadList.add(new Thread(new Azione(4, 4, constraintsFor4, manager)));

        int[] constraintsFor5 = {4};
        for(int i=1; i<=5; i++) {
            threadList.add(new Thread(new Azione(5,2, constraintsFor5, manager, sem)));
            constraintsFor5[0] = 5;
        }

        return threadList;
    }

    public static void main(String[] args) throws InterruptedException {
        for(Thread thread : getThreads())
            thread.start();
    }
}
package filoClient;

public class Main {

    public static void start(Philosopher[] philosophers){
        for(Philosopher p : philosophers){
            new Thread(p).start();
        }
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    private static void stats(Chopstick[] chopsticks) {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(Chopstick c : chopsticks)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Philosopher[] phil = new Philosopher[5];
        Chopstick[] chops = new Chopstick[5];
        int c = 0;

        Chopstick left;
        Chopstick right = new Chopstick();
        Chopstick first = right;
        chops[c++] = right;

        for (int i = 0; i < phil.length - 1; i++) {
            left = right;
            right = new Chopstick();
            chops[c++] = right;
            phil[i] = new Philosopher(left, right);
        }
        phil[phil.length - 1] = new Philosopher(right, first);

        start(phil);
    }
}

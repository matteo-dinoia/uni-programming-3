package filoServer;

public class Philosopher implements Runnable {
    private static int counter = 0;
    private final int number = counter++;
    private final Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right){
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings({"InfiniteLoopStatement"})
    @Override public void run() {
        while(true){
            thinks((long) (Math.random() * 1000));
            eats((long) (Math.random()* 1000));

        }
    }

    public void thinks(long amount){
        System.out.println("T " + number + " -> " + amount / 1000.0 + "s");
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("T " + number + " -> finished");
    }

    public void eats(long amount){
        try {
            left.grab(this);
            System.out.println("E " + number + " -> left");
            right.grab(this);
            System.out.println("E " + number + " -> right");
        } catch (InterruptedException e) {
            left.release(this);
            right.release(this);
            throw new RuntimeException(e);
        }

        System.out.println("E " + number + " -> " + amount / 1000.0 + "s");
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("E " + number + " -> finished");

        left.release(this);
        right.release(this);
    }

    public int getNumber() {
        return number;
    }
}

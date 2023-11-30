package filoServer;

public class Chopstick {
    private static int counter = 0;
    private final int number = counter++;
    private Philosopher owner = null;

    public synchronized void grab(Philosopher f) throws InterruptedException {
        while(owner != null)
            wait();

        owner = f;
    }

    public synchronized void release(Philosopher f) {
        if(owner != f)
            return;

        owner = null;
        notifyAll();
    }

    @Override public String toString() {
        return "Chopstick "
                + number + " ["
                + (owner == null ? "_" : owner.getNumber())
                + "]";
    }
}

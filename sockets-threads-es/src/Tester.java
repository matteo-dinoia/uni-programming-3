import client.Client;
import server.Server;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Thread(new Server()).start();
        new Thread(new Client(1)).start();
        new Thread(new Client(2)).start();
        new Thread(new Client(3)).start();
        new Thread(new Client(4)).start();
        new Thread(new Client(5)).start();
        new Thread(new Client(6)).start();
        new Thread(new Client(7)).start();
    }
}

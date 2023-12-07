package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    public void run() {
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(6161);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("START");

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("RECEIVE REQUEST BY CLIENT");

                HandlerSocket handler = new HandlerSocket(socket);
                threadPool.submit(handler);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
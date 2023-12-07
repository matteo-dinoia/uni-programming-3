package client;

import model.Student;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client implements Runnable{

    private final int id;

    public Client(int id){
        this.id = id;
    }

    public void run() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("C"));

        Socket socket = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;


        try{
            socket = new Socket("localhost",  6161);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            output.writeObject(list);
            System.out.println("BEFORE " + id + ": " + list);
            list = null;
            list = (List<Student>) input.readObject();

            System.out.println("AFTER " + id + ": " + list);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
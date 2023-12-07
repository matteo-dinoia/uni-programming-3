package server;

import model.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HandlerSocket implements Runnable{
    public Socket socket;

    public HandlerSocket(Socket socket){
        this.socket = socket;
    }

    public void run(){
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            List<Student> list = null;
            list = (List<Student>) input.readObject();
            System.out.println("BEFORE: " + list);

            edit(list);
            output.writeObject(list);
            System.out.println("AFTER: " + list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(socket != null) {
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

    private void edit(List<Student> list) {
        if(list == null || list.isEmpty())
            return;

        for(Student s : list)
            s.descr = "edited";
    }
}

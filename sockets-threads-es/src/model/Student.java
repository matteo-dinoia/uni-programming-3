package model;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public String descr;

    public Student(String name){
        this.name = name;
        this.descr = "";
    }

    @Override public String toString() {
        return "{" + name + " " + descr + "}";
    }
}

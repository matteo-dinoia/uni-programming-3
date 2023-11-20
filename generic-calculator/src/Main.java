import model.Calculator;
import type.CalcInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CalcInt> l = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            System.out.print("Write a number to insert (int): ");
            l.add(new CalcInt(sc.nextInt()));
        }


        Calculator.print(l);
        System.out.println("Max = " + Calculator.max(l));
        System.out.println("Sum = " + Calculator.sum(l));
    }
}
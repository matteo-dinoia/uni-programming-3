package model;

import type.Calculable;

import java.util.List;

public class Calculator{
    public static <T extends Comparable<T>> void print(List<? extends Calculable<T>> list){
        if(list == null)
            return;

        for (Calculable<T> el : list){
            el.print();
            System.out.print(" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> Calculable<T> sum(List<? extends Calculable<T>> list){
        if(list == null || list.isEmpty())
            return null;

        Calculable<T> res = list.get(0);
        for(int i = 1; i < list.size(); i++)
            res = res.add(list.get(i));

        return res;
    }

    public static <T extends Comparable<T>> Calculable<T> max(List<? extends Calculable<T>> list){
        if(list == null || list.isEmpty())
            return null;

        Calculable<T> max = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(max.compareTo(list.get(i)) < 0){
                max = list.get(i);
            }
        }

        return max;
    }

}

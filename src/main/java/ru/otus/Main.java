package ru.otus;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> exm = new LinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            exm.add(i);
        }
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        arr.addAll(exm);
        System.out.println(arr);
        ComparatorInteger DescComparator = new ComparatorInteger();
        arr.sort(DescComparator);
        System.out.println(arr);
        MyArrayList<Integer> copy_arr = arr.clone();
        System.out.println("clone:"+copy_arr);
    }
}

package ru.otus;


public class ComparatorInteger implements java.util.Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return -(o1-o2);
    }
}

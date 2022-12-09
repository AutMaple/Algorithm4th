package com.autmaple.sort.priorityQueue;

@SuppressWarnings({"rawtypes"})
public class IndexMinPQ<Item extends Comparable<Item>> {
    private Comparable[] arr;
    private int[] indexes;

    public IndexMinPQ(int maxN) {
        arr = new Comparable[maxN + 1];
        indexes = new int[maxN + 1];
    }

    void insert(int k, Item item) {

    }

    boolean contains(int k) {

        return false;
    }

    void delete(int k) {

    }

    Item min() {

        return null;
    }

    int minIndex() {
        return 1;
    }

    int delMin() {
        return 1;
    }

    boolean isEmpty() {
        return false;
    }

    int size() {
        return 0;
    }

}

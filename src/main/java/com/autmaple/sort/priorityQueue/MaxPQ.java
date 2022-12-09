package com.autmaple.sort.priorityQueue;

@SuppressWarnings({"unchecked"})
public class MaxPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exchange(1, N);
        pq[N--] = null;
        sink(1);
        return max;
    }

    /**
     * 自底向上调整堆结构
     */
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 自顶向下调整堆结构
     */
    public void sink(int k) {
        while (k * 2 <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exchange(j, k);
            k = j;
        }
    }

    /**
     * 交换
     */
    public void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}

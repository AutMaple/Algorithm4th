package com.autmaple.sort;

public class Heap {
    /**
     * 注意：k 表示的数据下标从 1 开始: 1 -> 0, 2 -> 1
     */
    @SuppressWarnings({"rawtypes"})
    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
        }
    }

    /**
     * 自顶向下调整堆的结构
     * 注意：k 表示的数据下标从 1 开始: 1 -> 0, 2 -> 1
     */
    @SuppressWarnings({"rawtypes"})
    public static void sink(Comparable[] arr, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(arr[j - 1], arr[j])) j++;
            if (less(arr[k - 1], arr[j - 1])) break;
            exchange(arr, k - 1, j - 1);
            k = j;
        }
    }

    /**
     * 自底向上调整
     */
    @SuppressWarnings({"rawtypes"})
    public static void swim(Comparable[] arr, int k) {
        while (k > 1 && less(arr[k / 2 - 1], arr[k - 1])) {
            exchange(arr, k / 2 - 1, k - 1);
            k /= 2;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    @SuppressWarnings({"rawtypes"})
    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

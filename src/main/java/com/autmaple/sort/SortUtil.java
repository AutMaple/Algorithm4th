package com.autmaple.sort;

import edu.princeton.cs.algs4.StdOut;

public class SortUtil {
    public static <T> void exchange(Comparable<T>[] arr, int i, int j) {
        Comparable<T> temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    @SuppressWarnings({"rawtypes"})
    public static void show(Comparable[] arr) {
        for (Comparable item : arr) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    @SuppressWarnings({"rawtypes"})
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i + 1], arr[i])) return false;
        }
        return true;
    }
}

package com.autmaple.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    @SuppressWarnings({"rawtypes"})
    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort(Comparable[] arr, int low, int high) {
        if (low >= high)
            return;
        int i = low;
        int j = high + 1;
        Comparable v = arr[low];
        while (true) {
            while (SortUtil.less(arr[++i], v)) if (i == high) break;
            while (SortUtil.less(v, arr[--j])) if (j == low) break;
            if (i >= j) break;
            SortUtil.exchange(arr, i, j);
        }
        SortUtil.exchange(arr, low, j);
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }

}

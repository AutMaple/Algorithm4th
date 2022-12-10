package com.autmaple.sort.insertion;

import com.autmaple.Generator;
import edu.princeton.cs.algs4.StdOut;

/**
 * InsertionX 改版的插入排序，优点类似插入排序和选择排序相结合
 */
public class InsertionX {
    private InsertionX() {
    }

    @SuppressWarnings({"rawtypes"})
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        boolean changed = false;
        for (int i = n - 1; i > 0; i--) {
            if (less(arr[i], arr[i - 1])) {
                exchange(arr, i, i - 1);
                changed = true;
            }
        }
        // 如果没有发生过交换，说明已经是排序好的了
        if (!changed) return;
        for (int i = 2; i < n; i++) {
            Comparable v = arr[i];
            int j = i;
            while (less(v, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = v;
        }
        assert isSorted(arr);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @SuppressWarnings({"rawtypes"})
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) return false;
        }
        return true;
    }


    public static void show(Object[] arr) {
        System.out.print("[");
        for (Object obj : arr) {
            StdOut.print(obj + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Integer[] arr = Generator.intArray(10, 0, 100);
        show(arr);
        sort(arr);
        show(arr);
    }
}

package com.autmaple.sort;

/**
 * 插入排序
 */
public class Insertion {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - i - 1; j < arr.length - 1; j++) {
                if (SortUtil.less(arr[j + 1], arr[j]))
                    SortUtil.exchange(arr, j, j + 1);
            }
        }
    }
}

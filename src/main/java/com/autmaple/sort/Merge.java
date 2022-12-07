package com.autmaple.sort;

public class Merge {
    @SuppressWarnings({"rawtypes"})
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    @SuppressWarnings({"rawtypes"})
    public static void sort(Comparable[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    /**
     * 使用非递归的方式实现归并排序
     */
    @SuppressWarnings({"rawtypes"})
    public static void sortUseLoop(Comparable[] arr) {
        for (int size = 1; size < arr.length; size += size) {
            // arr.length - size 可以判断是否还有需要合并数组，例如：2,2,1 => 合并：2，2,1 => 4, 1
            for (int low = 0; low < arr.length - size; low += size * 2) {
                merge(arr, low, low + size - 1, Math.min(low + 2 * size - 1, arr.length - 1));
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(Comparable[] arr, int low, int mid, int high) {
        Comparable[] cache = new Comparable[arr.length];
        System.arraycopy(arr, low, cache, low, high - low + 1);
        int pre = low;
        int post = mid + 1;
        for (int i = low; i <= high; i++) {
            if (pre > mid) arr[i] = cache[post++];
            else if (post > high) arr[i] = cache[pre++];
            else if (cache[pre].compareTo(cache[post]) > 0) arr[i] = cache[post++];
            else arr[i] = cache[pre++];
        }
    }
}

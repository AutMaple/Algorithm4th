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
        // 每执行一次循环，i 会指向 >= V 的位置，j 会指向 <= V 的位置
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

    /**
     * 该版本的快速排序，将数据分成了三个部分: <br>
     * - 大于 partition item 的部分 <br>
     * - 小于 partition item 的部分 <br>
     * - 等于 partition item 的部分
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort3Flag(Comparable[] arr, int low, int high) {
        if (low >= high) return;
        int lt = low, i = low + 1, gt = high;
        Comparable v = arr[low];
        // 等号不能够少，gt 指向的是未测试过的数据项，因此 i == gt 的情况还需要执行一次比较。
        while (i <= gt) {
            int flag = arr[i].compareTo(v);
            if (flag < 0) SortUtil.exchange(arr, lt++, i++);
            else if (flag > 0) SortUtil.exchange(arr, gt--, i);
            else i++;
        }
        sort3Flag(arr, low, lt - 1);
        // i 在任何时候指向的都是最后一个 partition item 后面的项
        // 一次 gt + 1 == i, 即 gt + 1 和 i 是等价的，可以将 i 改成 gt + 1;
        sort3Flag(arr, i, high);
    }

}

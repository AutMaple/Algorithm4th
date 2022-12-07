package com.autmaple.sort;

/**
 * 希尔排序
 */
public class Shell {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // 该层循环的目的是找到位置 i 的元素在已排序好的数组中的位置，如果不需要交换，则直接终止寻找,否则交换之后，继续寻找
                for (int j = i; j >= h && SortUtil.less(arr[j], arr[j - h]); j -= h) {
                    SortUtil.exchange(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }
}

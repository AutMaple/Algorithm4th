package com.autmaple.sort;

/**
 * ιζ©ζεΊ
 */
public class Selection {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            int min = i;
            for(int j = i + 1; j < len; j++) {
                if(SortUtil.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            SortUtil.exchange(arr, i, min);
        }
    }
}

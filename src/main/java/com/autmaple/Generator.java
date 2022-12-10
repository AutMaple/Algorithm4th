package com.autmaple;

import java.util.Random;

public class Generator {
    /**
     * 生成一个长度为 len, 元素范围在 [low, high] 之间的 int 类型的随机数组
     *
     * @param len  长度
     * @param low  元素最小值
     * @param high 元素最大值
     * @return 随机数组
     */
    public static Integer[] intArray(int len, int low, int high) {
        Integer[] arr = new Integer[len];
        int sub = high - low + 1;
        for (int i = 0; i < len; i++) {
            Random random = new Random();
            arr[i] = low + random.nextInt(sub);
        }
        return arr;
    }
}

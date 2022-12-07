package com.autmaple.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    /**
     * algorithm 排序算法的执行时间
     * @param algorithm 排序算法
     * @param arr 待排序的数组
     * @return 算法执行的时间
     */
    public static double time(String algorithm, Double[] arr) {
        Stopwatch timer = new Stopwatch();
        if ("Insertion".equals(algorithm)) Insertion.sort(arr);
        else if ("Selection".equals(algorithm)) Selection.sort(arr);
        else if ("Shell".equals(algorithm)) Shell.sort(arr);
        else if ("Merge".equals(algorithm)) Merge.sort(arr);
        else if ("Quick".equals(algorithm)) Quick.sort(arr);
        else if ("Heap".equals(algorithm)) Heap.sort(arr);
        return timer.elapsedTime();
    }

    /**
     * 执行 T 次 algorithm 对应的排序算法，并返回执行的总时间
     * @param algorithm 排序算法
     * @param N 排序数组元素的个数
     * @param T 执行多少次排序算法
     * @return 执行 T 次排序算法的总时间
     */
    public static double timeRandomInput(String algorithm, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(algorithm, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String algorithm1 = args[0];
        String algorithm2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(algorithm1, N, T);
        double t2 = timeRandomInput(algorithm2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, algorithm1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, algorithm2);
    }
}

package com.autmaple.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
    public static double time(String algorithm, Double[] a) {
        return 0.0;
    }

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
        int N = Integer.parseInt(args[3]);
        int T = Integer.parseInt(args[4]);
        double t1 = timeRandomInput(algorithm1, N, T);
        double t2 = timeRandomInput(algorithm2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, algorithm1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, algorithm2);
    }
}

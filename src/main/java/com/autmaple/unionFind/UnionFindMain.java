package com.autmaple.unionFind;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindMain {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdOut.println(n);
//        UnionFind uf = new QuickFind(n); // 1000000 条记录耗时： 778827
        UnionFind uf = new QuickUnion(n); // 1000000 条记录耗时：4469904
//        UnionFind uf = new WeightedQuickUnion(n); // 1000000 条记录耗时: 6171
        long start = System.currentTimeMillis();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(p + " " + q);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        long end = System.currentTimeMillis();
        StdOut.println(uf.count() + " components");
        StdOut.println("Length: " + n);
        StdOut.println("Time: " + (end - start));
    }
}

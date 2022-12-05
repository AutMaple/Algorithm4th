package com.autmaple.unionFind;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindMain {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdOut.println(n);
//        UnionFind uf = new QuickFind(n);
        QuickUnion uf = new QuickUnion(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(p + " " + q);
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }
}

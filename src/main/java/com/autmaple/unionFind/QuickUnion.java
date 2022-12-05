package com.autmaple.unionFind;

public class QuickUnion implements UnionFind{
    private final int[] ids;
    private int count;

    public QuickUnion(int n) {
        this.ids = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            this.ids[i] = i;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while(p != this.ids[p]) {
            p = this.ids[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        this.ids[pRoot] = qRoot;
        this.count--;
    }
}

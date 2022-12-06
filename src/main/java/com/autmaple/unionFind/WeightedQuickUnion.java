package com.autmaple.unionFind;

/**
 * 基于权重快速连接的并查集算法
 *
 * 该算法的时间复杂度为 logN, 并且最坏的情况是：每次进行合并操作时，两棵树的节点数量相等，合并之后会让树的高度 + 1；
 */
public class WeightedQuickUnion implements UnionFind {
    private final int[] ids;
    private final int[] weight; // 各点所在的树的根节点的权重
    private int count; // 分组数

    public WeightedQuickUnion(int n) {
        this.count = n;
        this.weight = new int[n];
        this.ids = new int[n];
        for (int i = 0; i < n; i++) {
            this.ids[i] = i;
        }
        // 初始时，权重都为 1
        for (int i = 0; i < n; i++) {
            this.weight[i] = 1;
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
        while (p != this.ids[p]) {
            p = this.ids[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (this.weight[pRoot] > this.weight[qRoot]) {
            this.ids[qRoot] = pRoot;
            this.weight[pRoot] += this.weight[qRoot];
        } else {
            this.ids[pRoot] = qRoot;
            this.weight[qRoot] += this.weight[pRoot];
        }
        this.count--;
    }
}

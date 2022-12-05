package com.autmaple.unionFind;

public class QuickFind implements UnionFind {
    private final int[] ids;
    private int count;


    public QuickFind(int n) {
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
        return this.find(p) == this.find(q);
    }

    @Override
    public int find(int p) {
        return this.ids[p];
    }

    @Override
    public void union(int p, int q) {
        if(!connected(p, q)) {
            int componentId = this.ids[p];
            int qid = this.ids[q];
            for(int i = 0; i < this.ids.length; i++) {
                if(this.ids[i] == qid)
                    this.ids[i] = componentId;
            }
            this.count--;
        }
    }
}

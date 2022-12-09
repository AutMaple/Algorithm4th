package com.autmaple.sort.priorityQueue;

import edu.princeton.cs.algs4.In;

/**
 * 优先级队列解决多路合并的问题
 */
public class Multiway {
    public static void merge(In[] streams) {
        int length = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(length);
        for (int i = 0; i < length; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
    }

    public static void main(String[] args) {
        int len = args.length;
        In[] streams = new In[len];
        for (int i = 0; i < len; i++) {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}

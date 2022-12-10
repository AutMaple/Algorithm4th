package com.autmaple;

import com.autmaple.sort.insertion.Insertion;
import com.autmaple.sort.Merge;
import com.autmaple.sort.Quick;
import com.autmaple.sort.Selection;
import com.autmaple.sort.Shell;
import com.autmaple.sort.SortUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class SortUtilTest {
    Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 21, 32, 8, 8, 99, 101, 23};

    @Test
    public void selectTest() {
        Person[] arr = new Person[]{new Person(30, "AutMaple"), new Person(20, "Irvin"), new Person(35, "James")};
        Selection.sort(arr);
        SortUtil.show(arr);
    }

    @Test
    public void insertTest() {
        Insertion.sort(this.arr);
        SortUtil.show(this.arr);
    }

    @Test
    public void shellTest() {
        Shell.sort(this.arr);
        SortUtil.show(this.arr);
    }

    @Test
    public void mergeTest() {
//        Merge.sort(this.arr);
        Merge.sortUseLoop(this.arr);
        //1 2 3 4 5 6 7 8 8 8 9 21 23 32 99 101
        SortUtil.show(this.arr);
    }

    @Test
    public void quickTest() {
//        Quick.sort(arr);
        Quick.sort3Flag(this.arr, 0, this.arr.length - 1);
        SortUtil.show(arr);
    }

    @Test
    public void randomSequence() {
        int n = 10;
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniformDouble(0.0, 1.0);
            StdOut.println(x);
        }
    }
}


package com.autmaple;

import com.autmaple.sort.Insertion;
import com.autmaple.sort.Selection;
import com.autmaple.sort.SortUtil;
import org.junit.Test;

public class SortUtilTest {
    @Test
    public void selectTest() {
        Person[] arr = new Person[] {new Person(30, "AutMaple"), new Person(20, "Irvin"), new Person(35, "James")};
        Selection.sort(arr);
        SortUtil.show(arr);
    }

    @Test
    public void insertTest() {
        Integer[] arr = {9,8,7,6,5,4,3,2,1, 21,32,8,8,99,101,23};
        Insertion.sort(arr);
        SortUtil.show(arr);
    }
}


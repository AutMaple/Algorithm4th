package com.autmaple;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Person implements Comparable<Person>{
    private int age;
    private String name;

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}

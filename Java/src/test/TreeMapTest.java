package test;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>((o1, o2) -> o2.score - o1.score);
        set.add(new Student("Tom", 23));
        set.add(new Student("Harry", 123));
        set.add(new Student("Jenny", 88));
        set.add(new Student("Jessica", 134));
        System.out.println(set);
    }
}


class Student {
    public String name;
    public int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}
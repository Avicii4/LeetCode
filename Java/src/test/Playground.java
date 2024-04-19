package test;

import java.util.*;
import java.util.function.Function;

public class Playground {
    // 原生的函数f
    private static List<Integer> f(int[] a) {
        List<Integer> lst = new ArrayList<>();
        for (int num : a) {
            lst.add(num);
        }
        return lst;
    }

    // 把函数f作为参数传进来
    public static void useF(Function<int[], List<Integer>> func) {
        int[] arr = {1, 4, 5, 1};
        System.out.println(func.apply(arr));
    }

    public static void paperFold(int n) {
        printPaperFold(1, n, true);
    }

    private static void printPaperFold(int level, int n, boolean down) {
        if (level > n) {
            return;
        }
        printPaperFold(level + 1, n, true);
        System.out.println(down ? "down" : "up");
        printPaperFold(level + 1, n, false);
    }


    public static void main(String[] args) {
        // 使用
        //useF(Playground::f);

        String str="hahahahah";
        String newStr= str.replace("ah","xxx");
        System.out.println(newStr);
    }
}

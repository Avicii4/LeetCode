package test;

import java.util.*;
import java.util.function.Function;

public class Playground {
    // 原生的函数f
    private static List<Integer> f(int[] a){
        List<Integer> lst=new ArrayList<>();
        for (int num:a){
            lst.add(num);
        }
        return lst;
    }

    // 把函数f作为参数传进来
    public static void useF(Function<int[],List<Integer>> func){
        int[] arr={1,4,5,1};
        System.out.println(func.apply(arr));
    }

    public static void main(String[] args) {
        // 使用
        //useF(Playground::f);

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        q.add(3);
        q.add(1);
        q.add(2);
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }

    }
}

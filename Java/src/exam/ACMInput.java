package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ACMInput {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        f3(sc);
    }



    // 单行输入整数
    private static void f1(Scanner sc){
        List<Integer> list=new ArrayList<>();
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        System.out.println(list);
    }

    // 多行输入整数，存入二维数组
    private static void f2(Scanner sc){
        List<List<Integer>> list=new ArrayList<>();
        int m=sc.nextInt();
        int n=sc.nextInt();
        for(int i=0;i<m;i++){
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<n;j++){
                t.add(sc.nextInt());
            }
            list.add(t);
        }
        System.out.println(list);

    }

    private static void f3(Scanner sc){
        String s= sc.nextLine();
        String[] arr = s.split("-");
        Integer[] intArr = new Integer[arr.length];
        for (int i=0;i<arr.length;i++){
            intArr[i]=Integer.parseInt(arr[i]);
        }
        System.out.println(new ArrayList<>(Arrays.asList(intArr)));


    }
}

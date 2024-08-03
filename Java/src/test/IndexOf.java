package test;

import java.util.Arrays;

public class IndexOf {
    public static void main(String[] args) {
        String string = "aaa456ac";
        System.out.println(string.indexOf("1456"));
        System.out.println(string.indexOf("c"));
        System.out.println(string.charAt(3));

        String str1 = "abcd";
        String str2 = "ABCD";
        System.out.println(str2.toLowerCase());
        int a = str1.compareTo(str2);//a>0
        System.out.println(a);


        String str = "asd qwe zxc fff";
        String[] arr=str.split(" ");
        System.out.println(Arrays.toString(arr));

    }
}

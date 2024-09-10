package test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        Class clazz = list.getClass();
        Method m = clazz.getMethod("add", Object.class);
        m.invoke(list,"Hello");
        System.out.println(list.size());  // 打印 1
        System.out.println(list.get(0));  // 打印 Hello
    }

}

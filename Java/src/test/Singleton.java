package test;

public class Singleton {

    private volatile static Singleton uniqueInstance;


    private Singleton() {
    }

    public static Singleton getInstance() {
        // 对象没有被实例化，才会进入
        if (uniqueInstance == null) {
            // 只有一个线程能抢到锁，初始化
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                    // 1. 分配内存空间  2。内存初始化  3.引用指向
                }
            }
        }
        return uniqueInstance;
    }
}

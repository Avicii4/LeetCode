package problems.concurrency;

import java.util.concurrent.Semaphore;

public class LC1115 {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;  // 交替打印5次 "foo" 和 "bar"
        FooBar fooBar = new FooBar(n);

        // 创建一个打印 "foo" 的线程
        Thread threadFoo = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建一个打印 "bar" 的线程
        Thread threadBar = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动两个线程
        threadFoo.start();
        threadBar.start();

        // 等待两个线程执行完毕
        threadFoo.join();
        threadBar.join();
    }
}



class FooBar {
    private final int n;
    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSema.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSema.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSema.release();
        }
    }
}
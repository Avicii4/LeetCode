package structure;


import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;

    Producer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, " + getName() + " is waiting...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = (int) (Math.random() * 100);
                System.out.println(getName() + " produced: " + num);
                queue.add(num);
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue<Integer> queue;

    Consumer(Queue<Integer> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, " + getName() + " is waiting...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = queue.poll();
                System.out.println(getName() + " consumed: " + num);
                queue.notifyAll();

            }
        }
    }
}



public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;

        Producer producer1 = new Producer(queue, maxSize, "Producer 1");
        Producer producer2 = new Producer(queue, maxSize, "Producer 2");
        Consumer consumer1 = new Consumer(queue, "Consumer 1");
        Consumer consumer2 = new Consumer(queue, "Consumer 2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

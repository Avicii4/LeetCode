package test;

import java.util.Stack;

// 如何随时知道一个栈里的最小元素值
// 方法是再用一个辅助的min栈
public class StackWithMin {

    private Stack<Integer> stack;   // 数据栈
    private Stack<Integer> min;    // min栈

    public StackWithMin() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public int pop() {
        int elem = stack.pop();
        if (elem == min.peek()) {
            min.pop();
        }
        return elem;
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(1);
        System.out.println("Current Min: " + stack.getMin()); // 输出当前最小值
        stack.pop(); // 移除栈顶元素
        stack.pop(); // 移除栈顶元素
        System.out.println("Current Min after popping: " + stack.getMin());

    }

}

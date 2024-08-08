package problems.stack;

import java.util.Stack;

public class LC946 {
    // 验证合法出栈序列
    public static boolean validateStackSequences_1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int inputNum : pushed) {
            stack.push(inputNum);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        for (int i = index; i < popped.length; i++) {
            if (stack.pop() != popped[i]) {
                return false;
            }
        }
        return stack.isEmpty();

    }

    // 更优雅的写法
    public static boolean validateStackSequences_2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] in = new int[]{2, 1, 0};
        int[] out = new int[]{1, 2, 0};

        System.out.println(validateStackSequences_1(in, out));
        System.out.println(validateStackSequences_2(in, out));
    }
}

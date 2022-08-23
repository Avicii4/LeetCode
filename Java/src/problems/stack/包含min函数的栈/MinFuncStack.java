
/**
 * Created by Harry Chou at 2019/5/10.
 */
import java.util.Stack;

public class MinFuncStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int minData = Integer.MAX_VALUE;

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }
        minData = node < minData ? node : minStack.peek();
        minStack.push(minData);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

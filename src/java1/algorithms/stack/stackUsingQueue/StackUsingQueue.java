package java1.algorithms.stack.stackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

//Using one queue:TC-> Push: O(n), pop: O(1), top: O(1), SC -> O(n)
class MyStack {
    private Queue<Integer> queue;

    MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Using two queues TC-> Push: O(n) pop: O(1) top: O(1), SC-> O(n)
class MyStack1 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueue {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Test push and top
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); // 3
        System.out.println(stack.isEmpty()); // false

        // Test pop
        System.out.println(stack.pop()); // 3
        System.out.println(stack.top()); // 2

        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.isEmpty()); // true

        // Test push after pop
        stack.push(10);
        stack.push(20);
        System.out.println(stack.top()); // 20
        System.out.println(stack.pop()); // 20
        System.out.println(stack.top()); // 10

        // --- MyStack1 (two queues) ---
        MyStack1 stack1 = new MyStack1();

        // Test push and top
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.top()); // 3
        System.out.println(stack1.isEmpty()); // false

        // Test pop
        System.out.println(stack1.pop()); // 3
        System.out.println(stack1.top()); // 2

        System.out.println(stack1.pop()); // 2
        System.out.println(stack1.pop()); // 1
        System.out.println(stack1.isEmpty()); // true

        // Test push after pop
        stack1.push(10);
        stack1.push(20);
        System.out.println(stack1.top()); // 20
        System.out.println(stack1.pop()); // 20
        System.out.println(stack1.top()); // 10
    }
}

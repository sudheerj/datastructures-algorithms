package java1.algorithms.stack.minStack;

import java.util.Stack;

public class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int value) {
            stack.push(value);
            if(minStack.isEmpty()) {
                minStack.push(value);
            } else {
                minStack.push(Math.min(value, minStack.peek()));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Pushed 5, Min: " + minStack.getMin());

        minStack.push(3);
        System.out.println("Pushed 3, Min: " + minStack.getMin());

        minStack.push(7);
        System.out.println("Pushed 7, Min: " + minStack.getMin());

        minStack.push(2);
        System.out.println("Pushed 2, Min: " + minStack.getMin());

        System.out.println("Top: " + minStack.top());

        minStack.pop();
        System.out.println("After pop, Min: " + minStack.getMin());

        minStack.pop();
        System.out.println("After pop, Min: " + minStack.getMin());

        System.out.println("Top: " + minStack.top());
    }
}

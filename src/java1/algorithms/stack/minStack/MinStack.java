package java1.algorithms.stack.minStack;

import java.util.Stack;

//Two stacks TC: O(1) SC:O(n)
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
        System.out.println("--- Approach 1: Two Stacks ---");
        MinStack ms1 = new MinStack();

        ms1.push(5);
        int r1 = ms1.getMin();
        System.out.println("Test 1 - push(5) getMin(): " + (r1 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=5");

        ms1.push(3);
        int r2 = ms1.getMin();
        System.out.println("Test 2 - push(3) getMin(): " + (r2 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=3");

        ms1.push(7);
        int r3 = ms1.getMin();
        System.out.println("Test 3 - push(7) getMin(): " + (r3 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=3");

        ms1.push(2);
        int r4 = ms1.getMin();
        System.out.println("Test 4 - push(2) getMin(): " + (r4 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=2");

        int r5 = ms1.top();
        System.out.println("Test 5 - top(): " + (r5 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=2");

        ms1.pop();
        int r6 = ms1.getMin();
        System.out.println("Test 6 - pop() 2, getMin(): " + (r6 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=3");

        ms1.pop();
        int r7 = ms1.getMin();
        System.out.println("Test 7 - pop() 7, getMin(): " + (r7 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=3");

        ms1.pop();
        int r8 = ms1.getMin();
        System.out.println("Test 8 - pop() 3, getMin(): " + (r8 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=5");

        System.out.println("\n--- Approach 2: Single Stack with (value, min) pairs ---");
        MinStack1 ms2 = new MinStack1();

        ms2.push(5);
        int r9 = ms2.getMin();
        System.out.println("Test 1 - push(5) getMin(): " + (r9 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=5");

        ms2.push(3);
        int r10 = ms2.getMin();
        System.out.println("Test 2 - push(3) getMin(): " + (r10 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=3");

        ms2.push(7);
        int r11 = ms2.getMin();
        System.out.println("Test 3 - push(7) getMin(): " + (r11 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r11 + " expected=3");

        ms2.push(2);
        int r12 = ms2.getMin();
        System.out.println("Test 4 - push(2) getMin(): " + (r12 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r12 + " expected=2");

        int r13 = ms2.top();
        System.out.println("Test 5 - top(): " + (r13 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r13 + " expected=2");

        ms2.pop();
        int r14 = ms2.getMin();
        System.out.println("Test 6 - pop() 2, getMin(): " + (r14 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r14 + " expected=3");

        ms2.pop();
        int r15 = ms2.getMin();
        System.out.println("Test 7 - pop() 7, getMin(): " + (r15 == 3 ? "[PASS]" : "[FAIL]") + " result=" + r15 + " expected=3");

        ms2.pop();
        int r16 = ms2.getMin();
        System.out.println("Test 8 - pop() 3, getMin(): " + (r16 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r16 + " expected=5");
    }
}

//Store value and min as pair in stack TC: O(1) SC: O(n)
class MinStack1 {
    Stack<int[]> stack;

    MinStack1() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);
        stack.push(new int[]{val,min});
    }

    public int pop() {
        return stack.pop()[0];
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

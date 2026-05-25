package java1.algorithms.stack.queueUsingStacks;

import java.util.Stack;

//Approach1: push-> O(1) pop->O(n) peek->O(n)
class QueueUsingStacks1 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    QueueUsingStacks1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //O(1)
    public void push(int x) {
        stack1.push(x);
    }

    //O(n)
    public int pop() {
        while(stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;
    }

    //O(n)
    public int peek() {
        while(stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        int res = stack1.peek();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;        
    }

    //O(1)
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

class QueueUsingStacks2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    QueueUsingStacks2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //O(1)
    public void push(int x) {
        stack1.push(x);
    }

    //O(1)
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //O(1)
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();        
    }

    //O(1)
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        System.out.println("--- Approach 1: push O(1), pop/peek O(n) ---");

        // Test 1 & 2: pop() returns elements in FIFO order
        QueueUsingStacks1 q1a = new QueueUsingStacks1();
        q1a.push(1); q1a.push(2); q1a.push(3);
        int r1 = q1a.pop();
        System.out.println("Test 1 - pop() first (FIFO): " + (r1 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=1");
        int r2 = q1a.pop();
        System.out.println("Test 2 - pop() second (FIFO): " + (r2 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=2");

        // Test 3 & 4: peek() returns front without removing
        QueueUsingStacks1 q1b = new QueueUsingStacks1();
        q1b.push(10); q1b.push(20);
        int r3 = q1b.peek();
        System.out.println("Test 3 - peek() returns front: " + (r3 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=10");
        int r4 = q1b.pop();
        System.out.println("Test 4 - pop() after peek() still returns front: " + (r4 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=10");

        // Test 5: isEmpty() on new queue
        QueueUsingStacks1 q1c = new QueueUsingStacks1();
        boolean r5 = q1c.isEmpty();
        System.out.println("Test 5 - isEmpty() on new queue: " + (r5 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=true");

        // Test 6: isEmpty() after push returns false
        q1c.push(5);
        boolean r6 = q1c.isEmpty();
        System.out.println("Test 6 - isEmpty() after push: " + (!r6 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=false");

        // Test 7: interleaved push/pop/peek
        QueueUsingStacks1 q1d = new QueueUsingStacks1();
        q1d.push(1); q1d.push(2); q1d.pop(); q1d.push(3);
        int r7 = q1d.peek();
        System.out.println("Test 7 - interleaved push/pop/peek: " + (r7 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=2");

        System.out.println("\n--- Approach 2: push O(1), pop/peek amortized O(1) ---");

        // Test 1 & 2: pop() returns elements in FIFO order
        QueueUsingStacks2 q2a = new QueueUsingStacks2();
        q2a.push(1); q2a.push(2); q2a.push(3);
        int r8 = q2a.pop();
        System.out.println("Test 1 - pop() first (FIFO): " + (r8 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=1");
        int r9 = q2a.pop();
        System.out.println("Test 2 - pop() second (FIFO): " + (r9 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=2");

        // Test 3 & 4: peek() returns front without removing
        QueueUsingStacks2 q2b = new QueueUsingStacks2();
        q2b.push(10); q2b.push(20);
        int r10 = q2b.peek();
        System.out.println("Test 3 - peek() returns front: " + (r10 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=10");
        int r11 = q2b.pop();
        System.out.println("Test 4 - pop() after peek() still returns front: " + (r11 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r11 + " expected=10");

        // Test 5: isEmpty() on new queue
        QueueUsingStacks2 q2c = new QueueUsingStacks2();
        boolean r12 = q2c.isEmpty();
        System.out.println("Test 5 - isEmpty() on new queue: " + (r12 ? "[PASS]" : "[FAIL]") + " result=" + r12 + " expected=true");

        // Test 6: isEmpty() after push returns false
        q2c.push(5);
        boolean r13 = q2c.isEmpty();
        System.out.println("Test 6 - isEmpty() after push: " + (!r13 ? "[PASS]" : "[FAIL]") + " result=" + r13 + " expected=false");

        // Test 7: interleaved push/pop/peek
        QueueUsingStacks2 q2d = new QueueUsingStacks2();
        q2d.push(1); q2d.push(2); q2d.pop(); q2d.push(3);
        int r14 = q2d.peek();
        System.out.println("Test 7 - interleaved push/pop/peek: " + (r14 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r14 + " expected=2");
    }
}

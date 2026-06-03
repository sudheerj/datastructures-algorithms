package java1.algorithms.design.browserHistory;

import java.util.Stack;

// Using DoublyLinkedList TC: visit-> O(1), forward -> O(k), back -> O(k) k= steps, SC: O(n) n = number of nodes stored(current, back, forward)
public class BrowserHistory {
    static class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    //Visit a new page
    public void visitPage(String url) {
        Node newNode = new Node(url);

        current.next = null; //clear forward history
        newNode.prev = current;

        current.next = newNode;
        current = newNode;
    }

    //Go forward K pages
    public String forward(int steps) {
        while(steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }

        return current.url;
    }

    //Go backward K pages
    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }
    public static void main(String[] args) {
        System.out.println("Testing BrowserHistory (DoublyLinkedList):");
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visitPage("google.com");
        bh.visitPage("facebook.com");
        bh.visitPage("youtube.com");
        String out1 = bh.back(1); // facebook.com
        String out2 = bh.back(1); // google.com
        String out3 = bh.forward(1); // facebook.com
        bh.visitPage("linkedin.com");
        String out4 = bh.forward(2); // linkedin.com
        String out5 = bh.back(2); // google.com
        String out6 = bh.back(7); // leetcode.com
        System.out.println("Test 1: " + (out1.equals("facebook.com") ? "PASS" : "FAIL"));
        System.out.println("Test 2: " + (out2.equals("google.com") ? "PASS" : "FAIL"));
        System.out.println("Test 3: " + (out3.equals("facebook.com") ? "PASS" : "FAIL"));
        System.out.println("Test 4: " + (out4.equals("linkedin.com") ? "PASS" : "FAIL"));
        System.out.println("Test 5: " + (out5.equals("google.com") ? "PASS" : "FAIL"));
        System.out.println("Test 6: " + (out6.equals("leetcode.com") ? "PASS" : "FAIL"));
    }
}

class BrowserHistory1 {
    Stack<String> forward = new Stack<>();
    Stack<String> backward = new Stack<>();
    String current;

    BrowserHistory1(String homepage) {
        current = homepage;
    }

    //Visit new page
    public void visitPage(String url) {
        backward.push(current);
        current = url;
        forward.clear();
    }

    //Go forward k steps
    public String forward(int steps) {
        while(steps > 0 && !forward.isEmpty()) {
            backward.push(current);
            current = forward.pop();
            steps--;
        }
        return current;
    }

    //Go backward k steps
    public String backward(int steps) {
        while(steps > 0 && !backward.isEmpty()) {
            forward.push(current);
            current = backward.pop();
            steps--;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println("Testing BrowserHistory1 (Stack-based):");
        BrowserHistory1 bh = new BrowserHistory1("leetcode.com");
        bh.visitPage("google.com");
        bh.visitPage("facebook.com");
        bh.visitPage("youtube.com");
        String out1 = bh.backward(1); // facebook.com
        String out2 = bh.backward(1); // google.com
        String out3 = bh.forward(1); // facebook.com
        bh.visitPage("linkedin.com");
        String out4 = bh.forward(2); // linkedin.com
        String out5 = bh.backward(2); // google.com
        String out6 = bh.backward(7); // leetcode.com
        System.out.println("Test 1: " + (out1.equals("facebook.com") ? "PASS" : "FAIL"));
        System.out.println("Test 2: " + (out2.equals("google.com") ? "PASS" : "FAIL"));
        System.out.println("Test 3: " + (out3.equals("facebook.com") ? "PASS" : "FAIL"));
        System.out.println("Test 4: " + (out4.equals("linkedin.com") ? "PASS" : "FAIL"));
        System.out.println("Test 5: " + (out5.equals("google.com") ? "PASS" : "FAIL"));
        System.out.println("Test 6: " + (out6.equals("leetcode.com") ? "PASS" : "FAIL"));
    }
}

package java1.algorithms.linkedlist.palindromeLinkedlist;

import java1.algorithms.linkedlist.Node;

public class PalindromeLinkedlist {
    private static boolean isPalindrome(Node head) {
        Node slow = head, fast = head;

        // find middle node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half
        Node prev = null;
        while (slow != null) {
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // check palindrome
        Node left = head, right = prev;
        while (right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private static Node build(int... vals) {
        Node dummy = new Node(0);
        Node cur = dummy;
        for (int v : vals) {
            cur.next = new Node(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test 1: even-length palindrome
        System.out.println(isPalindrome(build(1, 2, 2, 1)) + " (expected true)");

        // Test 2: odd-length palindrome
        System.out.println(isPalindrome(build(1, 2, 3, 2, 1)) + " (expected true)");

        // Test 3: single node
        System.out.println(isPalindrome(build(7)) + " (expected true)");

        // Test 4: two same nodes
        System.out.println(isPalindrome(build(5, 5)) + " (expected true)");

        // Test 5: not a palindrome
        System.out.println(isPalindrome(build(1, 2)) + " (expected false)");

        // Test 6: longer non-palindrome
        System.out.println(isPalindrome(build(1, 2, 3, 4, 5)) + " (expected false)");
    }
}

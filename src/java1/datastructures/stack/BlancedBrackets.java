package java1.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * The nested brackets problem is a problem that determines if a sequence of
 * brackets are properly nested. A sequence of brackets s is considered properly
 * nested if any of the following conditions are true: - s is empty - s has the
 * form (U) or [U] or {U} where U is a properly nested string - s has the form
 * VW where V and W are properly nested strings For example, the string
 * "()()[()]" is properly nested but "[(()]" is not. The function called
 * is_balanced takes as input a string S which is a sequence of brackets and
 * returns true if S is nested and false otherwise.
 *
 */
class BalancedBrackets {

    /**
     *
     * @param s
     * @return
     */
    static boolean isBalanced(String s) {
        Stack<Character> bracketsStack = new Stack<>();
        char[] text = s.toCharArray();
        for (char x : text) {
            switch (x) {
                case '{':
                case '<':
                case '(':
                case '[':
                    bracketsStack.push(x);
                    break;
                case '}':
                    if (bracketsStack.peek() == '{') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '>':
                    if (bracketsStack.peek() == '<') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (bracketsStack.peek() == '(') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (bracketsStack.peek() == '[') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return bracketsStack.empty();
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter sequence of brackets: ");
            String s = in.nextLine();
            if (isBalanced(s)) {
                System.out.println(s + " is balanced");
            } else {
                System.out.println(s + " ain't balanced");
            }
        }
    }
}

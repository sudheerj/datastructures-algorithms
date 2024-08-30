package java1.algorithms.stack.balancedBrackets;

import java.util.Stack;


class BalancedBrackets {

    static boolean isBalanced(String characters) {
        if(characters.length() == 0) return true;
        if(characters.length() == 1 || characters.length()%2 != 0) return false;
        
        Stack<Character> myStack = new Stack<>();
        char[] text = characters.toCharArray();
        for (char x : text) {
            switch (x) {
                case '{':
                case '<':
                case '(':
                case '[':
                    myStack.push(x);
                    break;
                case '}':
                    if (myStack.peek() == '{') {
                        myStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '>':
                    if (myStack.peek() == '<') {
                        myStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (myStack.peek() == '(') {
                        myStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (myStack.peek() == '[') {
                        myStack.pop();
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return myStack.empty();
    }

    public static void main(String args[]) {
        String str1 = "()[]{}<>";
        String str2 = "[({<>})]";
        String str3 = "([)]>";
        System.out.println(isBalanced(str1));
        System.out.println(isBalanced(str2));
        System.out.println(isBalanced(str3));
    }
}

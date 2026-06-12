package java1.algorithms.stack.basicCalculator2;

import java.util.Stack;

public class BasicCalculator2 {
    //Using stack evaluation pattern TC: O(n) SC: O(n)
    private int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            //Read numbers
            if(Character.isDigit(ch)) {
                num = num * 10 + ch -'0';
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) {
                if(sign == '+') {
                    stack.push(num);
                } else if(sign == '-') {
                    stack.push(-num);
                } else if(sign == '*') {
                    stack.push(stack.pop() * num);
                } else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int result = 0;
        for(int ch: stack) {
            result += ch;
        }

        return result;
    }

    //Using single-pass expression evaluation with space optimization TC: O(n) SC: O(1)
    private int calculate2(String s) {
        int num = 0, lastNum = 0, result = 0;
        char sign = '+';

        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) {
                if(sign == '+') {
                    result += lastNum;
                    lastNum = num;
                } else if(sign == '-') {
                    result -= lastNum;
                    lastNum = num;
                } else if(sign == '*') {
                    result += lastNum * num;
                } else if(sign == '/') {
                    result += lastNum / num;
                }

                sign = ch;
                num = 0;
            }
        }

        return result;
    }
}

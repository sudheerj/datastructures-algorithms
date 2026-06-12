package java1.algorithms.stack.parseBoolExpr;

import java.util.Stack;

public class ParseBoolExpr {
    //Stack + Reduce expression TC: O(n) SC: O(n)
    private boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for(char ch: expression.toCharArray()) {
            if(ch == ',' || ch == '(') {
                continue;
            } else if(ch != ')') {
                stack.push(ch);
            } else {
                int trueCount = 0;
                int falseCount = 0;

                while(stack.peek() == 't' || stack.peek() == 'f') {
                    if(stack.peek() == 't') {
                        trueCount++;
                    }
                    if(stack.peek() == 'f') {
                        falseCount++;
                    }
                }

                char op = stack.pop();
                char result;

                if(op == '!') {
                    result = (falseCount == 1) ? 't' : 'f';
                } else if(op == '&') {
                    result = (falseCount > 0) ? 'f' : 't';
                } else { // |
                    result = (trueCount > 0) ? 't' : 'f';
                }

                stack.push(result);
            }

            return stack.peek() == 't';
        }
    }
}

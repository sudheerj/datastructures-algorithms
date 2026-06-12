package java1.algorithms.greedy.validParenthesisInString;

import java.util.Stack;

public class ValidParenthesisInString {
    //Greedy range solution TC: O(n) SC: O(1)
    private boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;// min number of open parenthesis, max number of open parenthesis

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                leftMin++;
                leftMax++;
            } else if(ch == ')') {
                leftMin--;
                leftMax--;
            } else { //* 
                leftMin--;
                leftMax++;
            }

            if(leftMax < 0) {
                return false;
            }

            leftMin = Math.min(0, leftMin);
        }

        return leftMin == 0;
    }

    //Two stacks: one for open parenthesis and other one for '*'' TC: O(n) SC: O(n)
    private boolean checkValidString2(String s) {
        Stack<Character> openStack = new Stack<>();
        Stack<Character> starStack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                openStack.push(i);
            } else if(ch == '*') {
                starStack.push(i);
            } else { // )
                if(!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        //remaining '(' and '*' characters
        while(!openStack.isEmpty() && !starStack.isEmpty()) {
            if(openStack.peek() > starStack.peek()) {
                return false;
            }

            openStack.pop();
            starStack.pop();
        }

        return openStack.isEmpty();
    }
}

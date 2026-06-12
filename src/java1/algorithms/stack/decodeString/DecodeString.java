package java1.algorithms.stack.decodeString;

import java.util.Stack;

public class DecodeString {
    //Stack expression evaluation TC: O(n) SC: O(n)
    private String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(char ch: s.toCharArray()) {

            //Read single/multi-digit number
            if(Character.isDigit(ch)) {
                num = num * 10 + ch -'0';
            } else if(ch == '[') { //Start of new bucket
                stack.push(curr);
                stack.push(new StringBuilder(String.valueOf(num)));

                num = 0;  //Reset for new context
                curr = new StringBuilder(); //Reset for new context
            } else if(ch == ']'){ //End of bucket -> Decode
                int k = Integer.parseInt(stack.pop().toString());
                StringBuilder prev = stack.pop();

                for(int i=0; i<k; i++) {
                    prev.append(curr);
                }

                curr = prev;
            } else { //Normal character
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}

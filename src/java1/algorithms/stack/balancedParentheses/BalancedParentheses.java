//Hashmap:- TC:O(n) SC:O(n)
package java1.algorithms.stack.balancedParentheses;

import java.util.*;

public class BalancedParentheses {
    private static boolean hasBalancedParentheses(String str) {
        if(str.length() == 1 || str.length()%2 !=0) return false;
        
        Map<Character, Character> hashMap = new HashMap<>();

        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Stack<Character> myStack = new Stack<>();
        for(int i=0; i< str.length(); i++) {
            char ch = str.charAt(i);
            if(hashMap.containsKey(ch)) {
                if(myStack.size() != 0 && myStack.pop() != hashMap.get(ch)) {
                    return false;
                }
            } else {
                myStack.push(ch);
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "{([])}";
        System.out.println(hasBalancedParentheses(str1));

        String str2 = "{(][)}";
        System.out.println(hasBalancedParentheses(str2));
    }

}

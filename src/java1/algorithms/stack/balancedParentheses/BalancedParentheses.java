//Hashmap:- TC:O(n) SC:O(n)
package java1.algorithms.stack.balancedParentheses;

import java.util.*;

public class BalancedParentheses {
    //Using stack push & pop opeartions TC: O(n) SC: O(n)
    private static boolean validParenthesis(String str) {
        if(str.length() == 1 || str.length() %2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()) {
            //open brackets -> push
            if(ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else { // closing brackets -> pop
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(ch == '}' && top != '{') return false;
                if(ch == ')' && top != '(') return false;
                if(ch == ']' && top != '[') return false;
            } 
        }
        //empty -> valid
        return stack.isEmpty();
    }
    private static boolean hasBalancedParentheses(String str) {
        if(str.length() == 1 || str.length()%2 !=0) return false;
        
        Map<Character, Character> hashMap = new HashMap<>();

        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put('>', '<');

        Stack<Character> myStack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(hashMap.containsKey(ch)) {
                if(myStack.isEmpty() || myStack.pop() != hashMap.get(ch)) {
                    return false;
                }
            } else {
                myStack.push(ch);
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String[] common     = {"{([])}",   "{(][)}",  "()",   "()[]{}", "(]",  "([)]",  "{[]}", "(())",  "((("};
        boolean[] expCommon = { true,        false,     true,   true,     false,  false,   true,   true,    false};

        System.out.println("=== Approach 1: Stack ===");
        for (int i = 0; i < common.length; i++) {
            boolean result = validParenthesis(common[i]);
            System.out.println("[" + (result == expCommon[i] ? "PASS" : "FAIL") + "] \"" + common[i] + "\": " + result + "  (expected " + expCommon[i] + ")");
        }

        String[] hmTests     = {"{([])}",  "{(][)}", "()",  "()[]{}", "(]",   "([)]", "{[]}", "(())",  "(((",  "<>",  "<(>)"};
        boolean[] hmExpected = { true,       false,    true,  true,     false,  false,  true,   true,    false, true,  false};

        System.out.println("=== Approach 2: HashMap ===");
        for (int i = 0; i < hmTests.length; i++) {
            boolean result = hasBalancedParentheses(hmTests[i]);
            System.out.println("[" + (result == hmExpected[i] ? "PASS" : "FAIL") + "] \"" + hmTests[i] + "\": " + result + "  (expected " + hmExpected[i] + ")");
        }
    }

}

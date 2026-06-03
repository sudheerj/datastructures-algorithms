package java1.algorithms.stack.constructSmallestNumDIString;

import java.util.Stack;

public class ConstructSmallestNumDIString {
    //Greedy + stack (Monotonic stack idea for reversing D segments)
    private String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<= pattern.length(); i++) {
            stack.push(i+1);

            if(i == pattern.length() || pattern.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
            ConstructSmallestNumDIString solver = new ConstructSmallestNumDIString();
            String[] patterns = {"IIIDIDDD", "D", "I", "DDI", "IDID", ""};
            String[] expected = {"123549876", "21", "12", "3214", "13254", "1"};
            for (int i = 0; i < patterns.length; i++) {
                String result = solver.smallestNumber(patterns[i]);
                String status = result.equals(expected[i]) ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %s | Expected: %s | %s\n", i+1, result, expected[i], status);
            }
    }

}

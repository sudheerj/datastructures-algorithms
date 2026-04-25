package java1.algorithms.stack.simplifyPath;

import java.util.Stack;

public class SimplifyPath {
    //Stack TC:O(n),SC:O(n)
    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for(String curr: paths) {
            if(curr.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!curr.equals("") && !curr.equals(".")) {
                stack.push(curr);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        // Example 1: Normal path
        System.out.println("Input: /home/ -> Output: " + simplifyPath("/home/")); // /home

        // Example 2: Path with ..
        System.out.println("Input: /home/../ -> Output: " + simplifyPath("/home/../")); // /

        // Example 3: Path with .
        System.out.println("Input: /a/./b/../../c/ -> Output: " + simplifyPath("/a/./b/../../c/")); // /c

        // Example 4: Multiple slashes
        System.out.println("Input: /a//b////c/d//././/.. -> Output: " + simplifyPath("/a//b////c/d//././/..")); // /a/b/c

        // Example 5: Root only
        System.out.println("Input: /../ -> Output: " + simplifyPath("/../")); // /

        // Example 6: Empty path
        System.out.println("Input:  -> Output: " + simplifyPath("")); // /
    }
}

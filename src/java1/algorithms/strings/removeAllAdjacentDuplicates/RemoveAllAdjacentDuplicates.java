package java1.algorithms.strings.removeAllAdjacentDuplicates;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    private static String removeDuplicates(String str, int k) {
        Stack<Pair> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            //if same as top, increase count
            if(!stack.isEmpty() && stack.peek().ch == ch) {
                stack.peek().count++;

                //if count reaches k, remove group
                if(stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                //new group started
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder result = new StringBuilder();
        for(Pair pair: stack) {
            for(int i=0; i<pair.count; i++) {
                result.append(pair.ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[][] tests = {
            {"abcd",       "2", "abcd"},
            {"deeedbbcccbdaa", "3", "aa"},
            {"pbbcggttciiippooaais", "2", "ps"},
            {"aabbaa",     "2", ""},
            {"abcddcba",   "2", ""},
        };

        for (String[] test : tests) {
            String result = removeDuplicates(test[0], Integer.parseInt(test[1]));
            String status = result.equals(test[2]) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + test[2]);
        }
    }
}

package java1.algorithms.stack.baseBallGame;

import java.util.Stack;

public class BaseBallGame {
    //Stack + simulation TC: O(n) SC: O(n)
    private static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String ops: operations) {
            switch(ops) {
                case "+":
                    int lastScore = stack.pop();
                    int newScore = lastScore + stack.peek();
                    stack.push(lastScore);
                    stack.push(newScore);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(ops));
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }

    public static void main(String[] args) {

        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));           // 30

        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); // 27

        System.out.println(calPoints(new String[]{"1"}));                           // 1

        System.out.println(calPoints(new String[]{"1","D"}));                       // 3

        System.out.println(calPoints(new String[]{"1","2","+"}));                   // 6

        System.out.println(calPoints(new String[]{"3","4","+","D"}));               // 28
    }
}

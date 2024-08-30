package java1.algorithms.stack.reversePolishNotation;

import java.util.Stack;

public class ReversePolishNotation {

    private static int reversePolishNotation(String[] tokens){
        Stack<Integer> myStack = new Stack<>();

        for(String token: tokens){
            switch (token) {
                case "+": {
                    int secondPrev = Integer.valueOf(myStack.pop());
                    int firstPrev = Integer.valueOf(myStack.pop());
                    myStack.push(firstPrev+secondPrev);
                    break;
                }
                case "-": {
                    int secondPrev = Integer.valueOf(myStack.pop());
                    int firstPrev = Integer.valueOf(myStack.pop());
                    myStack.push(firstPrev-secondPrev);
                    break;
                }
                case "*": {
                    int secondPrev = Integer.valueOf(myStack.pop());
                    int firstPrev = Integer.valueOf(myStack.pop());
                    myStack.push(firstPrev*secondPrev);
                    break;
                }
                case "/": {
                    int secondPrev = Integer.valueOf(myStack.pop());
                    int firstPrev = Integer.valueOf(myStack.pop());
                    myStack.push(firstPrev/secondPrev);
                    break;
                }
                default:
                    myStack.push(Integer.parseInt(token));
                    break;
            }
        }

        return myStack.pop();
    }
    public static void main(String[] args) {
        String[] tokens1 = {"1","3","+","4","*"};
        String[] tokens2 = {"5","4","3","2","+","-10","*","/","*","10","+","4","+"};
        System.out.println(reversePolishNotation(tokens1));
        System.out.println(reversePolishNotation(tokens2));
    }
}
package java1.algorithms.stack.numberOfPeopleSeeInQueue;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfPeopleSeeInQueue {

    private static int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] visibilityCount = new int[length];
        Stack<Integer> stack = new Stack<>();


        for(int i=length-1; i>-1; i--) {
            while(!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                ++visibilityCount[i];
            }
            if(!stack.isEmpty()) {
                ++visibilityCount[i];
            }
            stack.push(heights[i]);
        }

        return visibilityCount;
    }

    public static void main(String[] args) {
        int[] heights1 = {10,6,8,5,11,9};
        System.out.println(Arrays.toString(canSeePersonsCount(heights1)));

        int[] heights2 = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(canSeePersonsCount(heights2)));

        int[] heights3 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(canSeePersonsCount(heights3)));
    }
    
}

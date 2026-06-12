package java1.algorithms.stack.find132Pattern;

import java.util.Stack;

public class Find132Pattern {
    //Monotonic decreasing stack TC: O(n) SC: O(n)
    private boolean find132Pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondNum = Integer.MIN_VALUE;

        for(int i=nums.length-1; i>=0; i--) {
            
            if(nums[i] < secondNum) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondNum = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}

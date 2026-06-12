package java1.algorithms.stack.nextGreaterElement2;

import java.util.Stack;

public class NextGreaterElement2 {
    private int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();//Store indices because values may contain duplicates
        int n = nums.length;
        int[] result = new int[nums.length]; 

        //Traverse the array twice for circular array
        for(int i=0; i< 2 *n; i++) {
            int num = nums[i%n];

            while(!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                result[index] = num;
            }

            //store all indices in the first pass
            if(i<n) {
                stack.push(i);
            }
        }
        return result;
    }
}

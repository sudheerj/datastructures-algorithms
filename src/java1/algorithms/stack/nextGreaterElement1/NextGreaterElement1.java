package java1.algorithms.stack.nextGreaterElement1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    //Monotonic decreasing stack + HashMap TC: O(n + m) SC: O(m) m = first string length n= length of 2nd string
    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> greaterMap = new HashMap<>();

        //Iterate over nums2 and build num->greater map
        for(int num: nums2) {

            while(!stack.isEmpty() && stack.peek() < num) {
                greaterMap.put(stack.pop(), num);
            }

            stack.push(num);
        }

        while(!stack.isEmpty()) {
            greaterMap.put(stack.pop(), -1);
        }

        //Push greater elements into result using HashMap lookup
        int[] result = new int[nums1.length];
        for(int i=0; i< nums1.length; i++) {
            result[i] = greaterMap.get(nums1[i]);
        }

        return result;
    }
}

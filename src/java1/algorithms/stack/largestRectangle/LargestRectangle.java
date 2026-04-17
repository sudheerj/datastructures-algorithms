package java1.algorithms.stack.largestRectangle;

import java.util.Stack;

//Monotonic increasing stack: TC:O(n) SC:O(n)
public class LargestRectangle {
    public static void main(String[] args) {
        int[][] testCases = {
                { 2, 1, 5, 6, 2, 3 }, // 10
                { 2, 4 }, // 4
                { 1, 1, 1, 1 }, // 4
                { 6, 2, 5, 4, 5, 1, 6 }, // 12
                { 2, 1, 2 }, // 3
                {}, // 0
                { 1 }, // 1
                { 2, 1, 2, 3, 1 } // 4
        };
        int[] expected = { 10, 4, 4, 12, 3, 0, 1, 4 };
        for (int i = 0; i < testCases.length; i++) {
            int result = largestRectangle(testCases[i]);
            System.out.println(java.util.Arrays.toString(testCases[i]) + " => " + result
                    + (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }
    }

    private static int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

package java1.algorithms.stack.maximalRectangle;

import java.util.Stack;

public class MaximalRectangle {
    //Build histogram for each row and run largest rectangle algorithm
    private int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        //build histogram for each row
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            //compute maxArea for each histogram
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
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

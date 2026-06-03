package java1.algorithms.graph.floodFill;

import java.util.Arrays;

public class FloodFill {
    // DFS recursion TC: O(m * n) SC: O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // if already same color, no need to process
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, color, originalColor);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int originalColor) {
        // boundary + color check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // update current cell color
        image[r][c] = newColor;

        // explore all directions
        dfs(image, r - 1, c, newColor, originalColor);
        dfs(image, r, c + 1, newColor, originalColor);
        dfs(image, r + 1, c, newColor, originalColor);
        dfs(image, r, c - 1, newColor, originalColor);
    }

    private static void printImage(int[][] image) {
        System.out.print("[");
        for (int i = 0; i < image.length; i++) {
            System.out.print(Arrays.toString(image[i]));
            if (i < image.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();

        // Test case 1
        int[][] image1 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println("Test case 1:");
        System.out.print("Input: image = ");
        printImage(image1);
        System.out.println("sr = 1, sc = 1, color = 2");
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        System.out.print("Output: ");
        printImage(result1);
        System.out.println("Expected: [[2,2,2],[2,2,0],[2,0,1]]");
        System.out.println("Explanation: From the center of the image with position (sr, sc) = (1, 1) (0-indexed),");
        System.out.println(
                "all pixels connected by a path of the same color as the starting pixel are colored with the new color.");
        System.out.println();

        // Test case 2
        int[][] image2 = { { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println("Test case 2:");
        System.out.print("Input: image = ");
        printImage(image2);
        System.out.println("sr = 0, sc = 0, color = 0");
        int[][] result2 = solution.floodFill(image2, 0, 0, 0);
        System.out.print("Output: ");
        printImage(result2);
        System.out.println("Expected: [[0,0,0],[0,0,0]]");
        System.out.println("Explanation: The starting pixel is already colored 0, so no change is made.");
        System.out.println();

        // Test case 3
        int[][] image3 = { { 0, 0, 0 }, { 0, 1, 1 } };
        System.out.println("Test case 3:");
        System.out.print("Input: image = ");
        printImage(image3);
        System.out.println("sr = 1, sc = 1, color = 1");
        int[][] result3 = solution.floodFill(image3, 1, 1, 1);
        System.out.print("Output: ");
        printImage(result3);
        System.out.println("Expected: [[0,0,0],[0,1,1]]");
        System.out.println("Explanation: The starting pixel is already colored 1, which is the same as the new color.");
        System.out.println();

        // Test case 4
        int[][] image4 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println("Test case 4:");
        System.out.print("Input: image = ");
        printImage(image4);
        System.out.println("sr = 1, sc = 0, color = 3");
        int[][] result4 = solution.floodFill(image4, 1, 0, 3);
        System.out.print("Output: ");
        printImage(result4);
        System.out.println("Expected: [[3,3,3],[3,3,0],[3,0,1]]");
        System.out.println("Explanation: All pixels with color 1 connected to position (1,0) are changed to 3.");
        System.out.println();

        // Test case 5
        int[][] image5 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println("Test case 5:");
        System.out.print("Input: image = ");
        printImage(image5);
        System.out.println("sr = 1, sc = 1, color = 2");
        int[][] result5 = solution.floodFill(image5, 1, 1, 2);
        System.out.print("Output: ");
        printImage(result5);
        System.out.println("Expected: [[0,0,0],[0,2,0],[0,0,0]]");
        System.out.println("Explanation: Only the center pixel is changed since it's isolated.");
    }
}

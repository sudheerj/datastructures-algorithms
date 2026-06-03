package java1.algorithms.graph.shortestPath.shortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private final int[][] DIRS = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 0 },
            { -1, 1 } };

    // Shortest path unweighted graph using BFS TC: O(n^2) SC: O(n^2)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // if start or end is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        grid[0][0] = 1; // mark as visited

        int steps = 1; // Start counting from 1 (includes the starting cell)
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                if (r == n - 1 && c == n - 1) {
                    return steps;
                }

                // explore all 8 directions(including diagonal)
                for (int[] dir : DIRS) {
                    int nr = r + dir[0], nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        queue.add(new int[] { nr, nc });
                        grid[nr][nc] = 1; // mark as visited
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();

        // Test case 1
        int[][] grid1 = { { 0, 1 }, { 1, 0 } };
        int result1 = solution.shortestPathBinaryMatrix(grid1);
        System.out.println("Test case 1: grid = [[0,1],[1,0]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");
        System.out.println("Explanation: Path is (0,0) -> (1,1)");
        System.out.println();

        // Test case 2
        int[][] grid2 = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        int result2 = solution.shortestPathBinaryMatrix(grid2);
        System.out.println("Test case 2: grid = [[0,0,0],[1,1,0],[1,1,0]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 4");
        System.out.println("Explanation: Path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2)");
        System.out.println();

        // Test case 3
        int[][] grid3 = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        int result3 = solution.shortestPathBinaryMatrix(grid3);
        System.out.println("Test case 3: grid = [[1,0,0],[1,1,0],[1,1,0]]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: -1");
        System.out.println("Explanation: Start cell is blocked, so no path exists.");
        System.out.println();

        // Test case 4
        int[][] grid4 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int result4 = solution.shortestPathBinaryMatrix(grid4);
        System.out.println("Test case 4: grid = [[0,0,0],[0,1,0],[0,0,0]]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 4");
        System.out.println("Explanation: Path can go around the obstacle diagonally.");
        System.out.println();

        // Test case 5
        int[][] grid5 = { { 0 } };
        int result5 = solution.shortestPathBinaryMatrix(grid5);
        System.out.println("Test case 5: grid = [[0]]");
        System.out.println("Output: " + result5);
        System.out.println("Expected: 1");
        System.out.println("Explanation: Already at destination (single cell grid).");
    }
}

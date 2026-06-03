package java1.algorithms.graph.maxAreaOfIsland;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    //Recursive DFS TC: O(m * n) SC: O(m * n)
    private static int maxAreaOfIslandDFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        return 1 + dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1);
    }

    // BFS TC: O(m * n) SC: O(m * n)
    private static int maxAreaOfIslandBFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { r, c });
                    grid[r][c] = 0;
                    int area = 0;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        area++;
                        int row = cell[0], col = cell[1];
                        for (int[] dir : directions) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                                queue.add(new int[] { nr, nc });
                                grid[nr][nc] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    // Inline test harness
    public static void main(String[] args) {
        int[][][] testGrids = {
                {
                        { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                        { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }
                },
                {
                        { 0, 0, 0, 0, 0, 0, 0, 0 }
                },
                {
                        { 1, 1, 1 },
                        { 1, 0, 1 },
                        { 1, 1, 1 }
                }
        };
        int[] expected = { 6, 0, 8 };

        System.out.println("Testing MaxAreaOfIslands (DFS):");
        for (int i = 0; i < testGrids.length; i++) {
            int[][] gridCopy = deepCopy(testGrids[i]);
            int res = maxAreaOfIslandDFS(gridCopy);
            System.out.println((res == expected[i] ? "PASS" : "FAIL") + " Test " + (i + 1) + ": got " + res
                    + ", expected " + expected[i]);
        }

        System.out.println("\nTesting MaxAreaOfIslands (BFS):");
        for (int i = 0; i < testGrids.length; i++) {
            int[][] gridCopy = deepCopy(testGrids[i]);
            int res = maxAreaOfIslandBFS(gridCopy);
            System.out.println((res == expected[i] ? "PASS" : "FAIL") + " Test " + (i + 1) + ": got " + res
                    + ", expected " + expected[i]);
        }

    }

    // Utility: deep copy a 2D array
    private static int[][] deepCopy(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, grid[0].length);
        }
        return copy;
    }
}

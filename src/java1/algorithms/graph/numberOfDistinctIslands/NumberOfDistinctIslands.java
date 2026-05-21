package java1.algorithms.graph.numberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    // Recursive DFS + HashSet TC: O(m × n) — SC: O(m × n)
    private static int numberOfDistinctIslands(char[][] grid) {
        Set<String> distinctIslands = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    StringBuilder islandPattern = new StringBuilder();
                    dfs(grid, r, c, r, c, islandPattern);
                    distinctIslands.add(islandPattern.toString());
                }
            }
        }

        return distinctIslands.size();
    }

    private static void dfs(char[][] grid, int row, int col, int baseRow, int baseCol, StringBuilder islandPattern) {
        //Out of bounds or water or already visted checks
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;
        grid[row][col] = '0';

        islandPattern.append(row - baseRow).append(":").append(col - baseCol).append("|");

        // down
        dfs(grid, row + 1, col, baseRow, baseCol, islandPattern);
        // top
        dfs(grid, row - 1, col, baseRow, baseCol, islandPattern);
        // right
        dfs(grid, row, col + 1, baseRow, baseCol, islandPattern);
        // left
        dfs(grid, row, col - 1, baseRow, baseCol, islandPattern);

    }

    public static void main(String[] args) {
        // Test 1: two identical 2×2 blocks → 1 distinct shape
        System.out.println(numberOfDistinctIslands(new char[][] {
                { '1', '1', '0', '0' },
                { '1', '1', '0', '0' },
                { '0', '0', '1', '1' },
                { '0', '0', '1', '1' }
        }) + " (expected 1)");

        // Test 2: L-shape + horizontal pair + 2×2 block → 3 distinct shapes
        System.out.println(numberOfDistinctIslands(new char[][] {
                { '1', '1', '0', '1', '1' },
                { '1', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' },
                { '0', '0', '0', '1', '1' }
        }) + " (expected 3)");

        // Test 3: two identical L-shapes (same translation) → 1 distinct
        System.out.println(numberOfDistinctIslands(new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '0', '0', '1', '1' },
                { '0', '0', '0', '1', '0' }
        }) + " (expected 1)");

        // Test 4: no islands
        System.out.println(numberOfDistinctIslands(new char[][] {
                { '0', '0', '0' },
                { '0', '0', '0' }
        }) + " (expected 0)");

        // Test 5: 3 isolated single cells — all same shape → 1 distinct
        System.out.println(numberOfDistinctIslands(new char[][] {
                { '1', '0', '1' },
                { '0', '0', '0' },
                { '1', '0', '0' }
        }) + " (expected 1)");
    }
}

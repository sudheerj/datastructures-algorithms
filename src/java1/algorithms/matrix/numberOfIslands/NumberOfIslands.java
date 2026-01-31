package matrix;

/**
 * Number of Islands
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 *
 * Time Complexity: O(m * n) where m is rows and n is columns
 * Space Complexity: O(m * n) for recursion stack in worst case
 */
public class NumberOfIslands {

    /**
     * DFS approach to count islands
     * TC: O(m * n), SC: O(m * n)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: out of bounds or water
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Explore all 4 directions
        dfs(grid, r + 1, c); // down
        dfs(grid, r - 1, c); // up
        dfs(grid, r, c + 1); // right
        dfs(grid, r, c - 1); // left
    }

    /**
     * BFS approach to count islands
     * TC: O(m * n), SC: O(min(m, n))
     */
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        // Example 1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid1)); // 1

        // Example 2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid2)); // 3
    }
}

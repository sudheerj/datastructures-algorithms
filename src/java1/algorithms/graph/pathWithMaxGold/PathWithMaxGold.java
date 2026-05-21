package java1.algorithms.graph.pathWithMaxGold;

public class PathWithMaxGold {
    int maxGold = 0; // track global max across all DFS paths

    // DFS + Backtracking  TC: O(m*n * 3^(m*n)) or O(4^(m*n))  SC: O(m*n) for recursion stack
    private int pathWithMaxGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                //can start from every non-zero gold cell
                if(grid[r][c] != 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int[][] grid, int row, int col, int currentGold) {
        //boundary or no gold cell
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return;

        int gold = grid[row][col];
        currentGold += gold;
        maxGold = Math.max(maxGold, currentGold);

        //mark as visited (set to 0)
        grid[row][col] = 0;

        //explore all 4 directions
        dfs(grid, row-1, col, currentGold);
        dfs(grid, row, col+1, currentGold);
        dfs(grid, row+1, col, currentGold);
        dfs(grid, row, col-1, currentGold);

        //backtrack (restore cell value)
        grid[row][col] = gold;
    }

    public static void main(String[] args) {
        // Test 1: Classic grid — best path through center (9->8->7)
        PathWithMaxGold sol1 = new PathWithMaxGold();
        System.out.println(sol1.pathWithMaxGold(new int[][]{
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        })); // Expected: 24

        // Test 2: Larger grid with isolated regions
        PathWithMaxGold sol2 = new PathWithMaxGold();
        System.out.println(sol2.pathWithMaxGold(new int[][]{
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
        })); // Expected: 28

        // Test 3: Single non-zero cell
        PathWithMaxGold sol3 = new PathWithMaxGold();
        System.out.println(sol3.pathWithMaxGold(new int[][]{
            {5}
        })); // Expected: 5

        // Test 4: All zeros — no gold to collect
        PathWithMaxGold sol4 = new PathWithMaxGold();
        System.out.println(sol4.pathWithMaxGold(new int[][]{
            {0, 0},
            {0, 0}
        })); // Expected: 0

        // Test 5: All non-zero — can traverse entire grid
        PathWithMaxGold sol5 = new PathWithMaxGold();
        System.out.println(sol5.pathWithMaxGold(new int[][]{
            {1, 2},
            {3, 4}
        })); // Expected: 10

        // Test 6: Single row — linear path
        PathWithMaxGold sol6 = new PathWithMaxGold();
        System.out.println(sol6.pathWithMaxGold(new int[][]{
            {1, 2, 3}
        })); // Expected: 6
    }
}

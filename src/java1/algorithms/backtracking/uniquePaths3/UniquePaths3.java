package java1.algorithms.backtracking.uniquePaths3;

public class UniquePaths3 {
    int totalPaths = 0;
    int totalCellsToBeVisited = 0;
    private int uniquePaths3(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int sr =0, sc = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 0) totalCellsToBeVisited++;
                if(grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                }
            }
        }

        totalCellsToBeVisited += 1;//incldue start cell

        dfs(grid, sr, sc, 0);

        return totalPaths;
    }

    private void dfs(int[][] grid, int r, int c, int count) {
        //boundary or obstacle check
        if(r < 0 || r>= grid.length || c < 0 || c>=grid[0].length || grid[r][c] == -1) {
            return;
        }

        //path reached
        if(totalCellsToBeVisited == count) {
            totalPaths++;
            return;
        }

        //mark visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        //explore 4 directions
        dfs(grid, r-1, c, count+1);
        dfs(grid, r, c+1, count+1);
        dfs(grid, r+1, c, count+1);
        dfs(grid, r, c-1, count+1);

        grid[r][c] = temp; //backtrack
    }
}

package java1.algorithms.graph;

public class NumberOfIslands {
    //DFS: TC: O(rows * cols) SC: O(1)
    private static int numIslands(char[][] grid){
        int count = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0;  c< grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';

        //down, up, right, left
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
    
}

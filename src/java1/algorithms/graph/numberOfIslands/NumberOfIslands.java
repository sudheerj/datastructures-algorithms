package java1.algorithms.graph.numberOfIslands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    //DFS: TC: O(rows * cols) SC: O(rows * cols)
    private static int numIslands1(char[][] grid){
        int islandCount = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0;  c< grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    //BFS: TC: O(rows * cols) SC: O(rows * cols)
    private static int numIslands2(char[][] grid){
        int islandCount = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0;  c< grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    islandCount++;
                    bfs(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    private static void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

            for (int[] direction : directions) {
                row = coordinates[0]+direction[0];
                col = coordinates[1]+direction[1];
                if(row >=0 && row < grid.length && col >=0 && col <grid[0].length && grid[row][col] == '1') {
                    queue.add(new int[]{row, col});
                    grid[row][col] = '0';
                }
            }
        }
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
        char[][] grid1 = {
            {'0','1','1','1','0'},
            {'0','1','0','1','0'},
            {'0','1','0','1','0'},
            {'0','1','0','0','0'}
        };
        char[][] grid11 = Arrays.stream(grid1)
        .map(arr -> Arrays.copyOf(arr, arr.length))
        .toArray(char[][]::new);

        System.out.println(numIslands1(grid1));
        System.out.println(numIslands2(grid11));

        char[][] grid2 = {
            {'1','1','0','1','1'},
            {'1','1','0','0','0'},
            {'0','0','1','0','1'},
            {'0','0','0','1','1'}
        };
        char[][] grid22 = Arrays.stream(grid2)
        .map(arr -> Arrays.copyOf(arr, arr.length))
        .toArray(char[][]::new);
        System.out.println(numIslands1(grid2));
        System.out.println(numIslands2(grid22));
    }
    
}

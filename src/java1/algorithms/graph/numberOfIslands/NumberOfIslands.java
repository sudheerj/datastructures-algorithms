package java1.algorithms.graph.numberOfIslands;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    //Recursive DFS: TC: O(rows * cols) SC: O(rows * cols)
    private static int numIslands1(char[][] grid){
        if(grid == null || grid.length == 0) return 0;

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

    private static void dfs(char[][] grid, int row, int col) {
        // boundary + water check
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        
        //mark as visited
        grid[row][col] = '0';

        //down, up, right, left
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    private static final int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    //BFS: TC: O(rows * cols) SC: O(rows * cols)
    private static int numIslands2(char[][] grid){
        if(grid == null || grid.length == 0) return 0;

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
        queue.offer(new int[]{row, col});

        //mark as visited
        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int newRow = current[0]+direction[0];
                int newCol = current[1]+direction[1];
                //boundary + land check
                if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol <grid[0].length && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }

    //Iterative DFS TC: O(m * n)  SC: O(m * n)
    private static int numIslands3(char[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int islandsCount =0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == '1') {
                    islandsCount++;
                    dfs1(grid, r, c);
                }
            }
        }

        return islandsCount;
    }

    private static void dfs1(char[][] grid, int r, int c) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{r, c});

        //mark as visited
        grid[r][c] = '0';

        while(!stack.isEmpty()) {
            int[] current = stack.pop();

            for(int[] dir: directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if(newRow >= 0 && newCol >=0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    stack.push(new int[]{newRow, newCol});
                    //mark as visited
                    grid[newRow][newCol] = '0';
                }
            }
        }
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

        char[][] grid111 = Arrays.stream(grid1)
        .map(arr -> Arrays.copyOf(arr, arr.length))
        .toArray(char[][]::new);

        System.out.println(numIslands1(grid1));
        System.out.println(numIslands2(grid11));
        System.out.println(numIslands3(grid111));

        char[][] grid2 = {
            {'1','1','0','1','1'},
            {'1','1','0','0','0'},
            {'0','0','1','0','1'},
            {'0','0','0','1','1'}
        };
        char[][] grid22 = Arrays.stream(grid2)
        .map(arr -> Arrays.copyOf(arr, arr.length))
        .toArray(char[][]::new);

        char[][] grid222 = Arrays.stream(grid2)
        .map(arr -> Arrays.copyOf(arr, arr.length))
        .toArray(char[][]::new);

        System.out.println(numIslands1(grid2));
        System.out.println(numIslands2(grid22));
        System.out.println(numIslands3(grid222));
    }
    
}

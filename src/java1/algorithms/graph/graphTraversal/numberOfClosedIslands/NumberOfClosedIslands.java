package java1.algorithms.graph.graphTraversal.numberOfClosedIslands;

import java.util.LinkedList;
import java.util.Queue;

//Closed islands = Total islands -border touching islands
public class NumberOfClosedIslands {
    //DFS Recursive TC: O(m * n) SC: O(m * n)
    private int closedIslandDFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        //Remove boundary-touched islands
        for(int c=0; c < cols; c++) {
            dfs(grid, 0, c);
            dfs(grid, rows-1, c);
        }

        for(int r=0; r < rows; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, cols-1);
        }

        int count = 0;
        //Count remaining closed islands
        for(int r=1; r<rows-1; r++) {
            for(int c=1; c<cols-1; c++) {
                if(grid[r][c] == 0) {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {
        if(r < 0 || r>=grid.length || c < 0 || c>=grid[0].length || grid[r][c] == 1) return;

        grid[r][c] = 1;

        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
    }

    //BFS recursive version TC: O(m * n) SC: O(m * n)
    private int closedIslandBFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        //Remove border-touched islands
        for(int c=0; c<cols; c++) {
            bfs(grid, 0, c);
            bfs(grid, rows-1, c);
        }

        for(int r=0; r<rows; r++) {
            bfs(grid, r, 0);
            bfs(grid, r, cols-1);
        }

        int count = 0;
        //count remaining closed islands
        for(int r=1; r<rows-1; r++) {
            for(int c=1; c<cols-1; c++) {
                if(grid[r][c] == 0) {
                    count++;
                    bfs(grid, r, c);
                } 
            }
        }

        return count;
    }

    private void bfs(int[][] grid, int r, int c) {
        if(grid[r][c] == 1) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = 1;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int[] dir: dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {

        NumberOfClosedIslands closedIslands = new NumberOfClosedIslands();

        // Test Case 1 -> Expected: 1
        int[][] grid1DFS = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        int[][] grid1BFS = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println("Test 1");
        System.out.println("DFS: " + closedIslands.closedIslandDFS(grid1DFS));
        System.out.println("BFS: " + closedIslands.closedIslandBFS(grid1BFS));
        System.out.println();


        // Test Case 2 -> Expected: 2
        int[][] grid2DFS = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,1,1,1,1,1,1}
        };

        int[][] grid2BFS = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,1,1,1,1,1,1}
        };

        System.out.println("Test 2");
        System.out.println("DFS: " + closedIslands.closedIslandDFS(grid2DFS));
        System.out.println("BFS: " + closedIslands.closedIslandBFS(grid2BFS));
        System.out.println();


        // Test Case 3 -> Expected: 0
        int[][] grid3DFS = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int[][] grid3BFS = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        System.out.println("Test 3");
        System.out.println("DFS: " + closedIslands.closedIslandDFS(grid3DFS));
        System.out.println("BFS: " + closedIslands.closedIslandBFS(grid3BFS));
        System.out.println();


        // Test Case 4 -> Expected: 1
        int[][] grid4DFS = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };

        int[][] grid4BFS = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };

        System.out.println("Test 4");
        System.out.println("DFS: " + closedIslands.closedIslandDFS(grid4DFS));
        System.out.println("BFS: " + closedIslands.closedIslandBFS(grid4BFS));
        System.out.println();


        // Test Case 5 -> Expected: 0
        int[][] grid5DFS = {
                {1,1,1,1},
                {1,0,0,0},
                {1,1,1,1}
        };

        int[][] grid5BFS = {
                {1,1,1,1},
                {1,0,0,0},
                {1,1,1,1}
        };

        System.out.println("Test 5");
        System.out.println("DFS: " + closedIslands.closedIslandDFS(grid5DFS));
        System.out.println("BFS: " + closedIslands.closedIslandBFS(grid5BFS));
    }
}

package java1.algorithms.graph.graphTraversal.countSubIslands;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {
    //DFS Recursion:- Traverse whole island for every island TC: O(m * n) SC: O(m * n)
    private int countSubIslandsDFS(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = grid2[0].length;
        int count = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid2[r][c] == 1) {
                    if(dfs(grid1, grid2, r, c)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if(r < 0 || r>= grid2.length || c < 0 || c>=grid2[0].length || grid2[r][c] == 0) return true;

        grid2[r][c] = 0;

        boolean isSubIsland = grid1[r][c] == 1;

        boolean top = dfs(grid1, grid2, r-1, c);
        boolean right = dfs(grid1, grid2, r, c+1);
        boolean bottom = dfs(grid1, grid2, r+1, c);
        boolean left = dfs(grid1, grid2, r, c-1);

        return isSubIsland && top && right && bottom && left;
    }

    //BFS TC: O(m * n) SC: O(m * n)
    private int countSubIslandsBFS(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = grid2[0].length;

        int count = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid2[r][c] == 1) {
                    if(bfs(grid1, grid2, r, c)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        grid2[r][c] = 0;

        boolean subIsland = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int row = currCell[0], col = currCell[1];

            if(grid1[row][col] == 0) {
                subIsland = false;
            }

            for(int[] dir: dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >=0 && nr < grid2.length && nc >= 0 && nc < grid2[0].length && grid2[nr][nc] == 1) {
                    grid2[nr][nc] = 0;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return subIsland;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2ForDFS = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        int[][] grid2ForBFS = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        CountSubIslands obj = new CountSubIslands();

        System.out.println("DFS: " +
                obj.countSubIslandsDFS(grid1, grid2ForDFS));

        System.out.println("BFS: " +
                obj.countSubIslandsBFS(grid1, grid2ForBFS));
    }
}

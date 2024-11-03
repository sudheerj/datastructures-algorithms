package java1.algorithms.graph.wallsGates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsGates {
    private static final int INF = 2147483647;

    private static void wallsAndGates(int[][] grid){
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
       
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];
            for (int[] dr : directions) {
                int nr = r + dr[0], nc = c + dr[1];

                if(nr < 0 ||  nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != INF) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid1 = new int[][] {
                {INF,  -1,  0,  INF},
                {INF, INF, INF,  -1},
                {INF,  -1, INF,  -1},
                {0,   -1,   INF, INF}
        };
        wallsAndGates(grid1);
        System.out.println(Arrays.deepToString(grid1));

        int[][] grid2 = {
            {-1,  0},
            {INF, INF}
        };
        wallsAndGates(grid2);
        System.out.println(Arrays.deepToString(grid2));
    }
}

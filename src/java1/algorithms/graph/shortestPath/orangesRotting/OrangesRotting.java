package java1.algorithms.graph.shortestPath.orangesRotting;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //BFS multi-source TC: O(m * n) SC: O(m * n)
    private int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        //Step1: Add all rotten oranges to queue and count fresh oranges
        for(int r=0; r< rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }


        int minuites = 0;
        //Step2: BFS from all rotten oranges (multi-source BFS)
        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            //Step3: Process all oranges in current minute
            for(int i=0; i< size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                //Step 4: Infect adjacent fresh oranges
                for(int[] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            //Step 5: One minute has passed after each BFS level
            minuites++;
        }

        //Step 6: If fresh oranges remain, it's impossible
        return fresh == 0 ? minuites : -1;
    }
    public static void main(String[] args) {
        OrangesRotting obj = new OrangesRotting();
        int[][][] testCases = {
            // Example 1
            {
                {2,1,1},
                {1,1,0},
                {0,1,1}
            },
            // Example 2
            {
                {2,1,1},
                {0,1,1},
                {1,0,1}
            },
            // Example 3
            {
                {0,2}
            },
            // All rotten
            {
                {2,2},
                {2,2}
            },
            // No oranges
            {
                {0,0},
                {0,0}
            }
        };
        int[] expected = {4, -1, 0, 0, 0};
        for (int i = 0; i < testCases.length; i++) {
            int[][] grid = deepCopy(testCases[i]);
            int exp = expected[i];
            int result = obj.orangesRotting(grid);
            String status = result == exp ? "PASS" : "FAIL";
            System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, exp, status);
        }
    }

    // Utility to deep copy a 2D array
    private static int[][] deepCopy(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }
}

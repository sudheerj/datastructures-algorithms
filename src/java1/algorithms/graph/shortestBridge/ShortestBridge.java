package java1.algorithms.graph.shortestBridge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    //DFS for finding first island + BFS for expanding to 2nd island TC: O(n^2) SC: O(n^2)
    private int shortestBridge(int[][] grid) {
        //Step1: Find first island using DFS
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        for(int r=0; r<n; r++) {
            if(found) break;
            for(int c=0; c<n; c++) {
                if(grid[r][c] == 1) {
                    dfs(grid, r, c, queue);
                    found = true;
                    break;
                }
            }
        }

        //Step2: BFS expansion
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i< size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for(int[] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if(grid[nr][nc] == 1) {
                        return steps;
                    }
                    if(grid[nr][nc] == 0) {
                        queue.add(new int[]{nr, nc});
                        grid[nr][nc] = -1; //mark as visited
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        if(r < 0 || r >= grid.length || c <0 || c>=grid[0].length || grid[r][c] != 1) return;

        //mark as visted
        grid[r][c] = -1;
        queue.add(new int[]{r, c});

        for(int[] dir: directions) {
            dfs(grid, r+dir[0], c+dir[1], queue);
        }

    }
    // Utility to deep copy a 2D array
    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = java.util.Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public static void main(String[] args) {
        ShortestBridge sol = new ShortestBridge();
        int[][][] tests = {
            { {0,1},{1,0} }, // 1
            { {0,1,0},{0,0,0},{0,0,1} }, // 2
            { {1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1} }, // 1
        };
        int[] expected = {1,2,1,2,4};

        System.out.println("Testing shortestBridge (DFS+BFS):");
        for (int i = 0; i < tests.length; i++) {
            int[][] input = deepCopy(tests[i]);
            int result = sol.shortestBridge(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}

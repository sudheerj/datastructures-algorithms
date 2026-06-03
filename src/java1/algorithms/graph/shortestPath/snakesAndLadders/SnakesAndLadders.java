package java1.algorithms.graph.shortestPath.snakesAndLadders;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    //Shortest path moves using BFS TC: O(n^2) SC: O(n^2)
    private int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int moves=0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            // each level = one dice throw
            for(int i=0; i<size; i++) {
                int curr = queue.poll();

                if(curr == n * n) return moves;

                //try all dice possibilities(1->6)
                for(int dice=1; dice<=6; dice++) {
                    int next = curr + dice;

                    if(next > n * n) continue;

                    int[] pos = getPos(next, n);
                    int r = pos[0], c = pos[1];

                    //apply snake or ladder
                    if(board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;

    }

    // Convert number (1 → n²) into (row, col) on zigzag board
    private int[] getPos(int num, int n) {
        int rowFromBottom = (num-1)/n;
        int row = n-1-rowFromBottom;
        int col = (num-1)%n;
        // reverse direction on every alternate row
        if(rowFromBottom%2 == 1) {
            col = n-1-col;
        }
        return new int[]{row, col};
    }
    public static void main(String[] args) {
        SnakesAndLadders obj = new SnakesAndLadders();
        int[][][] testCases = {
            // Example 1
            {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
            },
            // Example 2 (no snakes/ladders)
            {
                {-1,-1,-1},
                {-1,-1,-1},
                {-1,-1,-1}
            },
            // Example 3 (ladder at start)
            {
                {-1,-1,-1},
                {-1,9,8},
                {-1,8,9}
            }
        };
        int[] expected = {4, 2, 1};
        for (int i = 0; i < testCases.length; i++) {
            int[][] board = deepCopy(testCases[i]);
            int exp = expected[i];
            int result = obj.snakesAndLadders(board);
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

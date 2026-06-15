package java1.algorithms.graph.graphTraversal.surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    //DFS recursive traversal TC: O(m * n) SC: O(m * n)
    //Find all non-surrounded O's, mark them and flip surrounded O's
    private static char[][] solve1(char[][] board) {
        if(board == null || board.length == 0)  return board;

        int m = board.length;
        int n = board[0].length;

        //check first and last columns
        for(int r=0; r<m; r++) {
            dfs(board, r, 0);
            dfs(board, r, n-1);
        }

        //check first and last rows
        for(int c=0; c<n; c++) {
            dfs(board, 0, c);
            dfs(board, m-1, c);
        }

        //Transform surrounded 'O''s to 'X' and restore unsurrounded 'O's 
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }else if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }

        return board;
    }

    private static void dfs(char[][] board, int r, int c) {
        //boundary and non 'O's check
        if(r < 0 || r>=board.length || c< 0 || c>= board[0].length || board[r][c] != 'O') {
            return;
        }

        //mark unsurrounded 'O's
        board[r][c] = 'T';

        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
    }

    //BFS: TC: O(m * n) SC: O(m * n)
    private static char[][] solve2(char[][] board) {
        if(board == null || board.length == 0)  return board;

        int m = board.length;
        int n = board[0].length;

        //check first and last columns
        for(int r=0; r<m; r++) {
            bfs(board, r, 0);
            bfs(board, r, n-1);
        }

        //check first and last rows
        for(int c=0; c<n; c++) {
            bfs(board, 0, c);
            bfs(board, m-1, c);
        }

        //Transform surrounded 'O''s to 'X' and restore unsurrounded 'O's 
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }else if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }

        return board;
    }

    private static void bfs(char[][] board, int r, int c) {
        if(board[r][c] != 'O') return;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        board[r][c] = 'T';

        int[][] dirs = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for(int[] dir: dirs) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                    board[nr][nc] = 'T';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] dfsBoard = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] bfsBoard = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve1(dfsBoard);

        System.out.println("DFS Result:");
        for (char[] row : dfsBoard) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }

        solve2(bfsBoard);

        System.out.println("\nBFS Result:");
        for (char[] row : bfsBoard) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}

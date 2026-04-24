package java1.algorithms.matrix.nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    //Backtracking solution: TC: O(n!) SC: O(n*n)
    private List<List<String>> nQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, n, board);
        return result;
    }

    private void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c))
                continue;

            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        // Example 1: n = 1
        // Expected: [["Q"]]
        System.out.println("Input: n = 1\nOutput: " + solver.nQueens(1));

        // Example 2: n = 2 (no solution)
        // Expected: []
        solver = new NQueens();
        System.out.println("Input: n = 2\nOutput: " + solver.nQueens(2));

        // Example 3: n = 3 (no solution)
        // Expected: []
        solver = new NQueens();
        System.out.println("Input: n = 3\nOutput: " + solver.nQueens(3));

        // Example 4: n = 4
        // Expected: [[".Q..","...Q","Q...","..Q."], ["..Q.","Q...","...Q",".Q.."]]
        solver = new NQueens();
        System.out.println("Input: n = 4\nOutput: " + solver.nQueens(4));

        // Example 5: n = 5
        // Expected: 10 solutions (not shown for brevity)
        solver = new NQueens();
        System.out.println("Input: n = 5\nOutput: " + solver.nQueens(5));
    }

}

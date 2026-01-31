package matrix;

/**
 * Game of Life
 *
 * Given an m x n grid of cells where each cell is either live (1) or dead (0),
 * compute the next state according to Conway's Game of Life rules:
 * 1. Live cell with < 2 live neighbors dies (under-population).
 * 2. Live cell with 2-3 live neighbors lives.
 * 3. Live cell with > 3 live neighbors dies (over-population).
 * 4. Dead cell with exactly 3 live neighbors becomes live (reproduction).
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) - in-place modification
 */
public class GameOfLife {

    /**
     * In-place solution using state encoding
     * State encoding:
     * 0: dead -> dead
     * 1: live -> dead
     * 2: dead -> live
     * 3: live -> live
     * TC: O(m * n), SC: O(1)
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // First pass: encode new state
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = countLiveNeighbors(board, r, c);

                if (board[r][c] == 1) {
                    // Currently alive
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[r][c] = 3; // Stays alive
                    }
                    // else stays 1 (will die)
                } else {
                    // Currently dead
                    if (liveNeighbors == 3) {
                        board[r][c] = 2; // Becomes alive
                    }
                }
            }
        }

        // Second pass: decode final state
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = board[r][c] >= 2 ? 1 : 0;
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int nr = r + dr;
                int nc = c + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Check original state (1 or 3 means originally alive)
                    if (board[nr][nc] == 1 || board[nr][nc] == 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();

        // Example 1
        int[][] board1 = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println("Before: " + java.util.Arrays.deepToString(board1));
        solution.gameOfLife(board1);
        System.out.println("After: " + java.util.Arrays.deepToString(board1));
        // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

        // Example 2
        int[][] board2 = {{1, 1}, {1, 0}};
        System.out.println("\nBefore: " + java.util.Arrays.deepToString(board2));
        solution.gameOfLife(board2);
        System.out.println("After: " + java.util.Arrays.deepToString(board2));
        // [[1,1],[1,1]]
    }
}

package java1.algorithms.backtracking.sudokoSolver;

public class SudokoSolver {
    //TC: O(9^m) SC: O(m) m = number of empty cells
    private boolean solveSudoko(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(board[r][c] == '.') {
                    for(char num='1'; num<= '9'; num++) {
                        if(isValidSudoko(board, r, c, num)) {
                            board[r][c] = num;

                            if(solveSudoko(board)) {
                                return true;
                            }

                            board[r][c] = '.'; //backtracking
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSudoko(char[][] board, int r, int c, int num) {
        //row check
        for(int i=1; i<=9; i++) {
            if(board[r][i] == num) {
                return false;
            }

            //column check
            if(board[i][c] == num) {
                return false;
            }

            //3*3 box check
            int row = 3 * (r/3) + r/3;
            int col = 3 * (c/3) + c%3;

            if(board[row][col] == 3) {
                return false;
            }
        }

        return true;
    }
}

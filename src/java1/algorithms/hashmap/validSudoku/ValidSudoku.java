package java1.algorithms.hashmap.validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    private static boolean isValidSuduko1(char[][] board){
        int rows = board.length, cols = board[0].length;
        int k = (int)Math.sqrt(rows);

        Set<String> seen = new HashSet<>();

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                char cell = board[r][c];

                if(cell == '.') continue;
                if(!seen.add(cell +" in row " + r)
                   || !seen.add(cell +" in col " + c)
                   || !seen.add(cell +" in row-" + r/k + " col-"+c/k)) return false;
            }
        }

        return true;
    }

    private static boolean isValidSuduko2(char[][] board) {
        int n = board.length;
        int k = (int)Math.sqrt(n);

        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxes = new boolean[n][n];

        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                char cell = board[r][c];
                if(cell == '.') continue;

                int num = cell - '1'; //map 1-9 to 0-8
                int boxIndex = (r/k)*k+(c/k);

                if(rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[r][num] = cols[c][num] = boxes[boxIndex][num] = true;

            }
        }
        return true;
    }

    private static boolean isValidSuduko3(char[][] board){
        Map<Integer, Set<Character>> rowsMap = new HashMap<>();
        Map<Integer, Set<Character>> colsMap = new HashMap<>();
        Map<Integer, Set<Character>> squaresMap = new HashMap<>();

        int rows = board.length, cols = board[0].length;
        int k = (int)Math.sqrt(rows);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Character cell = board[r][c];
                if(cell == '.') {
                    continue;
                }
                rowsMap.putIfAbsent(r, new HashSet<>());
                colsMap.putIfAbsent(c, new HashSet<>());
                squaresMap.putIfAbsent((r/k)*k+c/k, new HashSet<>());

                if(rowsMap.get(r).contains(cell) 
                || colsMap.get(c).contains(cell)
                || squaresMap.get((r/k)*k+c/k).contains(cell)) {
                    return false;
                }

                rowsMap.get(r).add(cell);
                colsMap.get(c).add(cell);
                squaresMap.get((r/k)*k+c/k).add(cell);
            }
        }

        return true;

    }
    public static void main(String[] args) {
        char[][] board1 = new char[][] 
        {{'2','1','.','.','4','.','.','.','.'},
        {'3','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','1'}};

        char[][] board2 = new char[][] 
        {{'2','1','.','.','4','.','.','.','.'},
        {'3','.','.','5','.','.','.','.','.'},
        {'.','9','2','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','1'}};

        System.out.println(isValidSuduko1(board1));
        System.out.println(isValidSuduko1(board2));
        System.out.println(isValidSuduko2(board1));
        System.out.println(isValidSuduko2(board2));
        System.out.println(isValidSuduko3(board1));
        System.out.println(isValidSuduko3(board2));
    }
}

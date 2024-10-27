package java1.algorithms.hashmap.validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    private static boolean isValidSuduko(char[][] board){
        Map<Integer, Set<Character>> rowsMap = new HashMap<>();
        Map<Integer, Set<Character>> colsMap = new HashMap<>();
        Map<Integer, Set<Character>> squaresMap = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                Character cell = board[r][c];
                if(cell == '.') {
                    continue;
                }
                if(rowsMap.getOrDefault(r, new HashSet<>()).contains(cell) 
                || colsMap.getOrDefault(c, new HashSet<>()).contains(cell)
                || squaresMap.getOrDefault((r/3)*3+c/3, new HashSet<>()).contains(cell)) {
                    return false;
                }

                rowsMap.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
                colsMap.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
                squaresMap.computeIfAbsent((r/3)*3+c/3, k -> new HashSet<>()).add(cell);
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

        System.out.println(isValidSuduko(board1));
        System.out.println(isValidSuduko(board2));

        
    }
}

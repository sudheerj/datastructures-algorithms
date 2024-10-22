package java1.algorithms.matrix.wordSearch;

public class WordSearch {
    // DFS Backtracking:- TC: O(m * n * 4^L) SC:O(L)
    private static boolean isWordExist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                //Start dfs with first letter in the board
                if(dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        //Not found even after exhaustive search in the board
        return false;
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int curr) {
        // If the entire word has been found in the board
        if(word.length() == curr) return true;

        // Verify out of bounds or mismatched letter
        if(r < 0 || r >= board.length || c<0 || c >= board[0].length || board[r][c] != word.charAt(curr) || board[r][c] == '*') return false;

        //Mark the current word as visited
        char temp = board[r][c];
        board[r][c] = '*';

        //Explore neighbour letter of current word for the next letter in a word
        boolean top = dfs(board, word, r-1, c, curr+1);
        boolean left = dfs(board, word, r, c-1, curr+1);
        boolean bottom = dfs(board, word, r+1, c, curr+1);
        boolean right = dfs(board, word, r, c+1, curr+1);

        //Restore the original letter
        board[r][c] = temp;

        return top || left || bottom || right;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'A','B','C','D'}, {'W','M','G','O'}, {'B','D','C','N'}
        };
        char[][] board2 = {
            {'A','B','C','D'}, {'W','M','G','O'}, {'B','D','C','N'}
        };
        String word1 = "DOG";
        String word2 = "CAT";
        System.out.println(isWordExist(board1, word1));
        System.out.println(isWordExist(board2, word2));
    }
}

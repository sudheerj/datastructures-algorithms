 // DFS Backtracking:- TC: O(m * n * 4^L) SC:O(L)

 function isWordExist(board, word) {
    let rows = board.length, cols = board[0].length;

    for(let r=0; r<rows; r++) {
        for(let c=0; c<cols; c++) {
            //Start dfs with first letter in the board
            return dfs(board, word, r, c, 0)) {
                return true;
            }
        }
    }
    //Not found even after exhaustive search in the board
    return false;
 }

 function dfs(board, word, r, c, curr) {
     // If the entire word has been found in the board
    if(word.length === curr) return true;

    // Verify out of bounds or mismatched letter
    if(r <0 || r>= board.length || c<0 || c>= board[0].length || board[r][c] !== word[curr] || board[r][c] === '*') return false;

    //Mark the current word as visited
    let temp = board[r][c];
    board[r][c] = '*';

    //Explore neighbour letter of current word for the next letter in a word
    let top = dfs(board, word, r-1, c, curr+1);
    let left = dfs(board, word, r, c-1, curr+1);
    let bottom = dfs(board, word, r+1, c, curr+1);
    let right = dfs(board, word, r, c+1, curr+1);

    //Restore the original letter
    board[r][c] = temp;
    return top || left || bottom || right;
 }

let board1 = [
    ['A','B','C','D'], ['W','M','G','O'], ['B','D','C','N']
];
let board2 = [
    ['A','B','C','D'], ['w','A','G','O'], ['B','T','C','N']
];

let word1 = "DOG";
let word2 = "CAT";
console.log(isWordExist(board1, word1));
console.log(isWordExist(board2, word2));
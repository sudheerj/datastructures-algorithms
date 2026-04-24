function solveNQueens(n) {
    const result = [];
    const cols = new Set(), posDiag = new Set(), negDiag = new Set();
    const board = Array.from({ length: n }, () => Array(n).fill('.'));
    function backtrack(r) {
        if (r === n) {
            result.push(board.map(row => row.join('')));
            return;
        }
        for (let c = 0; c < n; c++) {
            if (cols.has(c) || posDiag.has(r + c) || negDiag.has(r - c)) continue;
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            backtrack(r + 1);
            cols.delete(c);
            posDiag.delete(r + c);
            negDiag.delete(r - c);
            board[r][c] = '.';
        }
    }
    backtrack(0);
    return result;
}

console.log("Input: n = 1\nOutput:", solveNQueens(1));
console.log("Input: n = 2\nOutput:", solveNQueens(2));
console.log("Input: n = 3\nOutput:", solveNQueens(3));
console.log("Input: n = 4\nOutput:", solveNQueens(4));
console.log("Input: n = 5\nOutput:", solveNQueens(5));

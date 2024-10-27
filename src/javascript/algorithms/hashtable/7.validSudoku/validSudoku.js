function isValidSuduko(board){
    let rowsMap = new Map();
    let colsMap = new Map();
    let squaresMap = new Map();

    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            const cell = board[r][c];

            if(cell === '.') {
                continue;
            }

            if(rowsMap.get(r)?.has(cell) 
                || colsMap.get(c)?.has(cell)
                || squaresMap.get(Math.floor(r/3)*3+Math.floor(c/3))?.has(cell)) {
                    return false;
                }
            
            rowsMap.set(r, new Set(rowsMap.get(r)).add(cell));
            colsMap.set(c, new Set(colsMap.get(c)).add(cell));
            squaresMap.set(Math.floor(r/3)*3+Math.floor(c/3), new Set(squaresMap.get(Math.floor(r/3)*3+Math.floor(c/3))).add(cell));
        }
        
    }

    return true;
}

const board1 = 
        [['2','1','.','.','4','.','.','.','.'],
        ['3','.','.','5','.','.','.','.','.'],
        ['.','9','8','.','.','.','.','.','3'],
        ['5','.','.','.','6','.','.','.','4'],
        ['.','.','.','8','.','3','.','.','5'],
        ['7','.','.','.','2','.','.','.','6'],
        ['.','.','.','.','.','.','2','.','.'],
        ['.','.','.','4','1','9','.','.','8'],
        ['.','.','.','.','8','.','.','7','1']];

        const board2 =  
        [['2','1','.','.','4','.','.','.','.'],
        ['3','.','.','5','.','.','.','.','.'],
        ['.','9','2','.','.','.','.','.','3'],
        ['5','.','.','.','6','.','.','.','4'],
        ['.','.','.','8','.','3','.','.','5'],
        ['7','.','.','.','2','.','.','.','6'],
        ['.','.','.','.','.','.','2','.','.'],
        ['.','.','.','4','1','9','.','.','8'],
        ['.','.','.','.','8','.','.','7','1']];

        console.log(isValidSuduko(board1));
        console.log(isValidSuduko(board2));

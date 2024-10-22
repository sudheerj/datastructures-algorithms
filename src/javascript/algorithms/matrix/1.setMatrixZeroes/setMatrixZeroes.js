//TC: O(m*n) SC:O(1)

function setZeroes(matrix) {
    let rows = matrix.length, cols = matrix[0].length;
    let rowZero = false;

    for(let r=0; r<rows; r++) {
        for(let c=0; c<cols; c++) {
            if(matrix[r][c] === 0) {
                matrix[0][c] = 0;
                if(r >0) {
                    matrix[r][0] = 0;
                } else {
                    rowZero = true;
                }
            }
        }
    }

    for(let r=1; r<rows; r++) {
        for(let c=1; c<cols; c++) {
            if(matrix[0][c] === 0 || matrix[r][0] === 0) {
                matrix[r][c] = 0;
            }
        }
    }

    if(matrix[0][0] === 0) {
        for(let r=1; r<rows; r++) {
            matrix[r][0] = 0;
        }
    }

    if(rowZero) {
        for(let c=0; c<cols; c++) {
            matrix[0][c] = 0;
        }
    }
}

let matrix1 = [[1, 0, 1], [1, 0, 1], [0, 1, 1]];
let matrix2 = [[1, 2, 3], [4, 0, 6], [7, 8, 9]];
setZeroes(matrix1);
console.log(matrix1);
setZeroes(matrix2);
console.log(matrix2);
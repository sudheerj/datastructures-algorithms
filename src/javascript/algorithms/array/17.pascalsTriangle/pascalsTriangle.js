function generatePascalsTriangle(numRows){
    let triangle = [];

    for (let row = 0; row < numRows; row++) {
        let currentRow = Array(row+1).fill(1);
        for (let col = 1; col < row; col++) {
            currentRow[col] = triangle[row-1][col-1]+triangle[row-1][col];
        }
        triangle.push(currentRow);
    }

    return triangle;
}

let numRows1 = 5;
console.log(generatePascalsTriangle(numRows1));
let numRows2 = 1;
console.log(generatePascalsTriangle(numRows2));
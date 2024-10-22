// TC: O(m*n) SC: O(1)

function spiralOrder(matrix) {
    let traversal = [];
    let left= 0, right = matrix[0].length-1;
    let top=0, bottom= matrix.length-1;

    while(top<=bottom && left <=right) {
        // Top row elements
        for(let i=left; i<=right; i++) {
            traversal.push(matrix[top][i]);
        }
        top++;

        // Last column elements
        for(let i=top; i<=bottom; i++) {
            traversal.push(matrix[i][right]);
        }

        right--;

        if(top <= bottom && left<= right) {
            // Last row elements
            for(let i=right; i>=left; i--){
                traversal.push(matrix[bottom][i]);
            }

            bottom--;

            // First column elements
            for(let i= bottom; i>=top; i--) {
                traversal.push(matrix[i][left]);
            }

            left++;
        }
        
    }
    return traversal;
}

let matrix1 = [
    [1,2], [3,4]
];
let matrix2 = [
    [1,2,3], [4,5,6], [7,8,9]
];
let matrix3 = [
    [1,2,3,4], [5,6,7,8], [9,10,11,12]
];

console.log(spiralOrder(matrix1));
console.log(spiralOrder(matrix2));
console.log(spiralOrder(matrix3));
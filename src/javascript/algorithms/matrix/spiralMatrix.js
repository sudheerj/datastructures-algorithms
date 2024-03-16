// TC: O(rows*cols) SC: O(n)

function spiralOrder(matrix) {
    let traversal = [];
    let r1= 0, r2 = matrix[0].length-1;
    let c1=0, c2= matrix.length-1;

    while(c1<=c2 && r1 <=r2) {
        // Top row: r1: c1->c2
        for(let i=c1; i<=c2; i++) {
            traversal.push(matrix[r1][i]);
        }

        // Last column: c2: r1+1 -> r2
        for(let i=r1+1; i<=r2; i++) {
            traversal.push(matrix[i][c2]);
        }

        if(c1 < c2 && r1< r2) {
            // Last row: r2: c2-1 -> c1
            for(let i= c2-1; i>=c1; i--) {
                traversal.push(matrix[r2][i]);
            }

            // First column: c1: r2-1 -> r1+1
            for(let i=r2-1; i>=r1+1; i--){
                traversal.push(matrix[i][c1]);
            }
        }

        c1++;
        r1++;
        c2--;
        r2--;
    }
    return traversal;
}

let matrix = [
    [1, 2, 3], [4, 5, 6], [7, 8, 9]
];
console.log(spiralOrder(matrix));
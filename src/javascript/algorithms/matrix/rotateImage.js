// TC: O(n*2) SC: O(1)

function rotateImage(matrix) {
    let left = 0, right = matrix[0].length-1;

    while(left < right) {
        for(let i=0; i< right - left; i++) {
            let top = left, bottom = right;

            // Save the topLeft
            let topLeft = matrix[top][left+i];

            //Move bottom left to top left
            matrix[top][left+i] = matrix[bottom-i][left];

            //Move bottom right to bottom left
            matrix[bottom-i][left] = matrix[bottom][right-i];

            //Move top right to bottom right
            matrix[bottom][right-i] = matrix[top+i][right];

            //Move top left to top right
            matrix[top+i][right] = topLeft;
        }
        left++;
        right--;
    }
}

let matrix = [
    [1, 2, 3, 4], 
    [5, 6, 7, 8],
    [9, 10, 11, 12], 
    [13, 14, 15, 16]
];
rotateImage(matrix);
console.log(matrix);
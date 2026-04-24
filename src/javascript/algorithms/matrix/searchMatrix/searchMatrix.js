function searchMatrix(matrix, target) {
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) return false;
    const rows = matrix.length, cols = matrix[0].length;
    let left = 0, right = rows * cols - 1;
    while (left <= right) {
        const mid = left + Math.floor((right - left) / 2);
        const value = matrix[Math.floor(mid / cols)][mid % cols];
        if (target > value) {
            left = mid + 1;
        } else if (target < value) {
            right = mid - 1;
        } else {
            return true;
        }
    }
    return false;
}

const matrix1 = [[1,3,5,7],[10,11,16,20],[23,30,34,60]];
console.log("Input: matrix1, target=3 -> Output:", searchMatrix(matrix1, 3)); // true
console.log("Input: matrix1, target=13 -> Output:", searchMatrix(matrix1, 13)); // false
const matrix2 = [[1,2,3,4,5]];
console.log("Input: matrix2, target=4 -> Output:", searchMatrix(matrix2, 4)); // true
const matrix3 = [[1],[3],[5]];
console.log("Input: matrix3, target=5 -> Output:", searchMatrix(matrix3, 5)); // true
const matrix4 = [[7]];
console.log("Input: matrix4, target=7 -> Output:", searchMatrix(matrix4, 7)); // true
console.log("Input: matrix4, target=2 -> Output:", searchMatrix(matrix4, 2)); // false
const matrix5 = [];
console.log("Input: empty matrix, target=1 -> Output:", false);

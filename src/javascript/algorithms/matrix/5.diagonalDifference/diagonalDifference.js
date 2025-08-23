function diagonalDifference(arr) {
    let firstDiagonalSum = 0;
    let secondDiagonalSum = 0;

    for(let i = 0; i < arr.length; i++) {
        firstDiagonalSum += arr[i][i];
        secondDiagonalSum += arr[i][arr.length - 1 - i];
    }

    return Math.abs(firstDiagonalSum-secondDiagonalSum);
}

// Example usage
const matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];
console.log(diagonalDifference(matrix)); // Output: 0
// Another example
const matrix2 = [
    [1, 2, 1],
    [4, 5, 6],
    [7, 8, 9]
];
console.log(diagonalDifference(matrix2)); // Output: 2
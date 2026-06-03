// Eliminate row or column TC: O(m+n) SC: O(1)
function searchMatrix(matrix, target) {
    const rows = matrix.length, cols = matrix[0].length;
    let row = 0, col = cols - 1; // start from top-right

    while (row < rows && col >= 0) {
        if (matrix[row][col] === target) return true;
        if (matrix[row][col] < target) row++;   // move down
        else col--;                              // move left
    }

    return false;
}

function runTests() {
    const m1 = [
        [1,  4,  7,  11, 15],
        [2,  5,  8,  12, 19],
        [3,  6,  9,  16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30],
    ];
    const m2 = [[1, 1]];
    const m3 = [[1, 3, 5], [2, 4, 6], [3, 5, 7]];

    const tests = [
        { matrix: m1, target: 5,  expected: true  },
        { matrix: m1, target: 20, expected: false },
        { matrix: m1, target: 15, expected: true  },
        { matrix: m2, target: 2,  expected: false },
        { matrix: m2, target: 1,  expected: true  },
        { matrix: m3, target: 4,  expected: true  },
    ];

    for (const { matrix, target, expected } of tests) {
        const result = searchMatrix(matrix, target);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] target=${target} result=${result} expected=${expected}`);
    }
}

runTests();

function countNumberOfTeams(rating) {
    const n = rating.length;
    let res = 0;
    for (let j = 0; j < n; j++) {
        let leftLess = 0, leftGreater = 0, rightGreater = 0, rightLess = 0;
        for (let i = 0; i < j; i++) {
            if (rating[i] < rating[j]) leftLess++;
            else if (rating[i] > rating[j]) leftGreater++;
        }
        for (let k = j + 1; k < n; k++) {
            if (rating[k] > rating[j]) rightGreater++;
            else if (rating[k] < rating[j]) rightLess++;
        }
        res += leftLess * rightGreater + leftGreater * rightLess;
    }
    return res;
}

function runTests() {
    const testCases = [
        [[2, 5, 3, 4, 1], 3],
        [[2, 1, 3], 0],
        [[1, 2, 3, 4], 4],
        [[4, 3, 2, 1], 4],
        [[1, 3, 2, 4, 5], 5],
        [[1, 2, 3, 2, 1], 6],
        [[1, 1, 1, 1], 0],
        [[1, 2, 1, 2, 1, 2], 0]
    ];
    testCases.forEach(([arr, expected], i) => {
        const result = countNumberOfTeams(arr);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected} | ${status}`);
    });
}

if (require.main === module) {
    runTests();
}

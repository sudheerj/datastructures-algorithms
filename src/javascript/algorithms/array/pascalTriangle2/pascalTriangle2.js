// Copy from previous row TC: O(k^2) SC: O(k)
function getRow1(rowIndex) {
    let row = [1];
    for (let i = 1; i <= rowIndex; i++) {
        const next = [1];
        for (let j = 1; j < i; j++) {
            next.push(row[j - 1] + row[j]);
        }
        next.push(1);
        row = next;
    }
    return row;
}

// In-place right-to-left TC: O(k^2) SC: O(k)
function getRow2(rowIndex) {
    const row = new Array(rowIndex + 1).fill(1);
    for (let i = 2; i <= rowIndex; i++) {
        for (let j = i - 1; j > 0; j--) {
            row[j] = row[j - 1] + row[j];
        }
    }
    return row;
}

function runTests() {
    const tests = [
        { rowIndex: 0, expected: [1] },
        { rowIndex: 1, expected: [1, 1] },
        { rowIndex: 2, expected: [1, 2, 1] },
        { rowIndex: 3, expected: [1, 3, 3, 1] },
        { rowIndex: 4, expected: [1, 4, 6, 4, 1] },
        { rowIndex: 5, expected: [1, 5, 10, 10, 5, 1] },
    ];

    console.log("=== getRow1 (copy from previous row) ===");
    for (const { rowIndex, expected } of tests) {
        const result = getRow1(rowIndex);
        const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
        console.log(`[${status}] rowIndex=${rowIndex} result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }

    console.log("=== getRow2 (in-place right-to-left) ===");
    for (const { rowIndex, expected } of tests) {
        const result = getRow2(rowIndex);
        const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
        console.log(`[${status}] rowIndex=${rowIndex} result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

runTests();

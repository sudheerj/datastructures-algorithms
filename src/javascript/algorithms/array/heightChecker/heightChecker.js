// Frequency counting  TC: O(n)  SC: O(1)

/**
 * @param {number[]} heights
 * @returns {number}
 */
function heightChecker(heights) {
    const count = new Array(101).fill(0);

    for (const h of heights) {
        count[h]++;
    }

    let mismatches = 0;
    let currentHeight = 1;
    for (const h of heights) {
        while (count[currentHeight] === 0) currentHeight++;
        if (h !== currentHeight) mismatches++;
        count[currentHeight]--;
    }

    return mismatches;
}

function runTests() {
    const tests = [
        { heights: [1, 1, 4, 2, 1, 3],       expected: 3 },  // 3 students out of position
        { heights: [5, 1, 2, 3, 4],           expected: 5 },  // all students out of position
        { heights: [1, 2, 3, 4, 5],           expected: 0 },  // already sorted
        { heights: [2, 1, 2, 1, 1, 2, 2, 1],  expected: 4 },  // mixed mismatches
        { heights: [1],                        expected: 0 },  // single student
        { heights: [3, 3, 3, 3],              expected: 0 },  // all same height
    ];

    tests.forEach(({ heights, expected }) => {
        const result = heightChecker(heights);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();

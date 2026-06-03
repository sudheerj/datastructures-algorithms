// Approach 1: Frequency counting (running total)  TC: O(n)  SC: O(n)
function findIdenticalPairs(nums) {
    let count = 0;
    const frequencyMap = {};

    for (const num of nums) {
        if (frequencyMap[num]) {
            count += frequencyMap[num];
        }
        frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }

    return count;
}

// Approach 2: Combinatorics — nC2 = n*(n-1)/2 per group  TC: O(n)  SC: O(n)
function findIdenticalPairs2(nums) {
    const frequencyMap = {};
    for (const num of nums) {
        frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }

    let count = 0;
    for (const c of Object.values(frequencyMap)) {
        count += (c * (c - 1)) / 2;
    }
    return count;
}

function runTests() {
    const tests = [
        { nums: [6, 3, 1, 5, 3, 6, 5, 6], expected: 5 },  // mixed duplicates
        { nums: [2, 2, 2, 2],              expected: 6 },  // all same: 4C2=6
        { nums: [1, 2, 3, 4],              expected: 0 },  // all distinct
        { nums: [1, 1],                    expected: 1 },  // single pair
        { nums: [1],                       expected: 0 },  // single element
    ];

    console.log("--- Approach 1: Frequency Counting ---");
    tests.forEach(({ nums, expected }) => {
        const result = findIdenticalPairs(nums);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });

    console.log("--- Approach 2: Combinatorics ---");
    tests.forEach(({ nums, expected }) => {
        const result = findIdenticalPairs2(nums);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();
// Difference array + prefix sum  TC: O(n + q) SC: O(n)
function isZeroArray(nums, queries) {
    const n = nums.length;
    const diffArr = new Array(n + 1).fill(0);

    for (const [left, right] of queries) {
        diffArr[left]++;
        diffArr[right + 1]--;
    }

    let currentCoverage = 0;
    for (let i = 0; i < n; i++) {
        currentCoverage += diffArr[i];
        if (currentCoverage < nums[i]) return false;
    }

    return true;
}

function runTests() {
    const tests = [
        { nums: [1, 0, 1],    queries: [[0, 2]],                          expected: true  },
        { nums: [4, 3, 2, 1], queries: [[1, 3], [0, 2]],                  expected: false },
        { nums: [2, 0, 2],    queries: [[0, 2], [0, 2]],                  expected: true  },
        { nums: [1, 2, 3, 4], queries: [[0, 3], [1, 3], [2, 3], [3, 3]], expected: true  },
        { nums: [3, 1, 2],    queries: [[0, 1], [1, 2]],                  expected: false },
    ];

    tests.forEach(({ nums, queries, expected }) => {
        const result = isZeroArray(nums, queries);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] nums=[${nums}] result=${result} expected=${expected}`);
    });
}

runTests();

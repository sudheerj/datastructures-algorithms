// Binary search + difference array + prefix sum  TC: O((n+q) log q) SC: O(n)
function minZeroArray(nums, queries) {
    const n = nums.length;
    const q = queries.length;

    function isZeroArray(k) {
        const diffArr = new Array(n + 1).fill(0);
        for (let i = 0; i < k; i++) {
            const [l, r] = queries[i];
            diffArr[l]++;
            diffArr[r + 1]--;
        }
        let currentCoverage = 0;
        for (let i = 0; i < n; i++) {
            currentCoverage += diffArr[i];
            if (currentCoverage < nums[i]) return false;
        }
        return true;
    }

    let left = 0, right = q, answer = -1;
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        if (isZeroArray(mid)) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return answer;
}

function runTests() {
    const tests = [
        { nums: [2, 0, 2],    queries: [[0, 2], [0, 2], [1, 1]],           expected: 2  },
        { nums: [4, 3, 2, 1], queries: [[1, 3], [0, 2]],                   expected: -1 },
        { nums: [1, 2, 3, 4], queries: [[0, 3], [1, 3], [2, 3], [3, 3]],   expected: 4  },
        { nums: [0, 0, 0],    queries: [[0, 1], [1, 2]],                    expected: 0  },
        { nums: [1, 2, 3],    queries: [[0, 2], [1, 2], [2, 2]],            expected: 3  },
    ];

    tests.forEach(({ nums, queries, expected }) => {
        const result = minZeroArray(nums, queries);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] nums=[${nums}] result=${result} expected=${expected}`);
    });
}

runTests();

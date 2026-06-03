// Sorting solution TC: O(n log n) SC: O(1)
function maximumProduct1(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    return Math.max(
        nums[n-3] * nums[n-2] * nums[n-1],
        nums[0] * nums[1] * nums[n-1]
    );
}

// Greedy solution TC: O(n) SC: O(1)
function maximumProduct2(nums) {
    let max1 = -Infinity, max2 = -Infinity, max3 = -Infinity;
    let min1 = Infinity, min2 = Infinity;

    for (const num of nums) {
        if (num > max1)      { max3 = max2; max2 = max1; max1 = num; }
        else if (num > max2) { max3 = max2; max2 = num; }
        else if (num > max3) { max3 = num; }

        if (num < min1)      { min2 = min1; min1 = num; }
        else if (num < min2) { min2 = num; }
    }

    return Math.max(max1 * max2 * max3, min1 * min2 * max1);
}

function runTests() {
    const tests = [
        { nums: [-3, 1, 2, -2, 5, 6],  expected: 60  },
        { nums: [-10, -10, 1, 3, 2],   expected: 300 },
        { nums: [1, 2, 3],              expected: 6   },
        { nums: [-1, -2, -3, -4],       expected: -6  },
        { nums: [-5, -4, 1, 2, 3],      expected: 60  },
        { nums: [1, 2, 3, 4],           expected: 24  },
    ];

    console.log("=== maximumProduct1 (sorting) ===");
    for (const { nums, expected } of tests) {
        const result = maximumProduct1([...nums]);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] nums=[${nums}] result=${result} expected=${expected}`);
    }

    console.log("=== maximumProduct2 (greedy) ===");
    for (const { nums, expected } of tests) {
        const result = maximumProduct2([...nums]);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] nums=[${nums}] result=${result} expected=${expected}`);
    }
}

runTests();

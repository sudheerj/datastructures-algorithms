// Approach 1: Backtracking (binary decision tree) TC: O(n * 2^n) SC: O(n * 2^n)
function subsets(nums) {
    const result = [];
    function dfs(i, subset) {
        if (i >= nums.length) {
            result.push([...subset]);
            return;
        }
        subset.push(nums[i]);
        dfs(i + 1, subset);
        subset.pop();
        dfs(i + 1, subset);
    }
    dfs(0, []);
    return result;
}

// Approach 2: Iterative expansion TC: O(n * 2^n) SC: O(n * 2^n)
function subsetsIterative(nums) {
    let result = [[]];
    for (const num of nums) {
        result = result.concat(result.map(s => [...s, num]));
    }
    return result;
}

// Approach 3: Bit masking TC: O(n * 2^n) SC: O(n * 2^n)
function subsetsBitmask(nums) {
    const n = nums.length;
    const result = [];
    for (let mask = 0; mask < (1 << n); mask++) {
        const subset = [];
        for (let j = 0; j < n; j++) {
            if (mask & (1 << j)) subset.push(nums[j]);
        }
        result.push(subset);
    }
    return result;
}

function normalize(subsetsList) {
    return new Set(subsetsList.map(s => JSON.stringify([...s].sort((a, b) => a - b))));
}

function setsEqual(a, b) {
    if (a.size !== b.size) return false;
    for (const v of a) if (!b.has(v)) return false;
    return true;
}

function runTests() {
    const tests = [
        { input: [1, 2, 3], expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]] },
        { input: [0],        expected: [[], [0]] },
        { input: [],         expected: [[]] },
        { input: [1, 2],     expected: [[], [1], [2], [1,2]] },
    ];

    for (const { input, expected } of tests) {
        const exp = normalize(expected);
        const r1 = subsets(input), r2 = subsetsIterative(input), r3 = subsetsBitmask(input);
        console.log(`${setsEqual(normalize(r1), exp) ? '[PASS]' : '[FAIL]'} [Backtracking] input=[${input}]`);
        console.log(`${setsEqual(normalize(r2), exp) ? '[PASS]' : '[FAIL]'} [Iterative   ] input=[${input}]`);
        console.log(`${setsEqual(normalize(r3), exp) ? '[PASS]' : '[FAIL]'} [Bit Masking ] input=[${input}]`);
    }

    // Test 5: [1,2,3,4] — expect 2^4 = 16 subsets
    const t5 = [1, 2, 3, 4];
    for (const [label, fn] of [['Backtracking', subsets], ['Iterative   ', subsetsIterative], ['Bit Masking ', subsetsBitmask]]) {
        const count = fn(t5).length;
        console.log(`${count === 16 ? '[PASS]' : '[FAIL]'} [${label}] input=[1,2,3,4] count=${count} expected=16`);
    }
}

runTests();

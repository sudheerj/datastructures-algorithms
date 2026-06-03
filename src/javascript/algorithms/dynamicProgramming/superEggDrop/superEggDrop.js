// Super Egg Drop (LC 887)
// DP + Binary search  TC: O(k * n * log n)  SC: O(k * n)

/**
 * @param {number} n - number of floors
 * @param {number} k - number of eggs
 * @return {number}
 */
function superEggDrop(n, k) {
    const memo = new Map();

    function dfs(floors, eggs) {
        if (floors <= 1) return floors;
        if (eggs === 1) return floors;

        const key = `${floors},${eggs}`;
        if (memo.has(key)) return memo.get(key);

        let low = 1, high = floors;
        let minAttempts = Infinity;

        while (low <= high) {
            const mid = low + Math.floor((high - low) / 2);
            const breakCase   = dfs(mid - 1, eggs - 1); // egg breaks
            const surviveCase = dfs(floors - mid, eggs); // egg survives
            const attempts = 1 + Math.max(breakCase, surviveCase);
            minAttempts = Math.min(minAttempts, attempts);

            if (breakCase < surviveCase) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        memo.set(key, minAttempts);
        return minAttempts;
    }

    return dfs(n, k);
}

function runTests() {
    const tests = [
        { n: 1,  k: 1, expected: 1 },
        { n: 2,  k: 1, expected: 2 },
        { n: 6,  k: 2, expected: 3 },
        { n: 10, k: 2, expected: 4 },
        { n: 14, k: 3, expected: 4 },
        { n: 2,  k: 2, expected: 2 },
    ];

    for (const { n, k, expected } of tests) {
        const result = superEggDrop(n, k);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] n=${n} k=${k} result=${result} expected=${expected}`);
    }
}

runTests();

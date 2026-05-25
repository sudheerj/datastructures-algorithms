// Approach: Frequency Counting + Try All Target Frequencies TC: O(n) SC: O(1)
function minOpsToEqualFrequencies(s) {
    const freqCount = new Array(26).fill(0);
    for (const ch of s) {
        freqCount[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    const maxFreq = Math.max(...freqCount);
    let ans = Infinity;

    for (let target = 1; target <= maxFreq; target++) {
        let ops = 0;
        for (const freq of freqCount) {
            if (freq === 0) continue;
            if (freq > target) {
                ops += freq - target;   // delete excess
            } else if (freq < target) {
                ops += freq;            // delete all occurrences
            }
            // freq === target: 0 ops needed
        }
        ans = Math.min(ans, ops);
    }

    return ans;
}

function runTests() {
    const tests = [
        { input: "abc",       expected: 0 },
        { input: "aab",       expected: 1 },
        { input: "aabbc",     expected: 1 },
        { input: "aaabbc",    expected: 2 },
        { input: "aaabbbccc", expected: 0 },
    ];

    for (const { input, expected } of tests) {
        const result = minOpsToEqualFrequencies(input);
        const status = result === expected ? "[PASS]" : "[FAIL]";
        console.log(`${status} input="${input}" result=${result} expected=${expected}`);
    }
}

runTests();

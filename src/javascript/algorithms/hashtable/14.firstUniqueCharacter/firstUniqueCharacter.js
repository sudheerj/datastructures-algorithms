// Approach 1: frequency count array  TC: O(n)  SC: O(1)
function firstUniqChar1(str) {
    const countArr = new Array(26).fill(0);
    const a = 'a'.charCodeAt(0);

    for (const ch of str) countArr[ch.charCodeAt(0) - a]++;

    for (let i = 0; i < str.length; i++) {
        if (countArr[str.charCodeAt(i) - a] === 1) return i;
    }
    return -1;
}

// Approach 2: frequency map  TC: O(n)  SC: O(n)
function firstUniqChar2(str) {
    const charCount = new Map();

    for (const ch of str) {
        charCount.set(ch, (charCount.get(ch) || 0) + 1);
    }

    for (let i = 0; i < str.length; i++) {
        if (charCount.get(str[i]) === 1) return i;
    }

    return -1;
}

function runTests() {
    const tests = [
        { str: "leetcode",     expected:  0 },
        { str: "loveleetcode", expected:  2 },
        { str: "zeep",         expected:  0 },
        { str: "mama",         expected: -1 },
        { str: "aabb",         expected: -1 },
        { str: "z",            expected:  0 },
    ];

    console.log("--- Approach 1: Frequency Array ---");
    for (const { str, expected } of tests) {
        const result = firstUniqChar1(str);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] str="${str}" result=${result} expected=${expected}`);
    }

    console.log("--- Approach 2: Frequency Map ---");
    for (const { str, expected } of tests) {
        const result = firstUniqChar2(str);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] str="${str}" result=${result} expected=${expected}`);
    }
}

runTests();

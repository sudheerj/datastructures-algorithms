// Find All Anagrams in a String
// TC: O(n)  SC: O(1) — two fixed-size arrays of 26

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
function findAnagrams(s, p) {
    const result = [];
    if (s.length < p.length) return result;

    const pCount = new Array(26).fill(0);
    const sCount = new Array(26).fill(0);
    const a = 'a'.charCodeAt(0);

    for (const ch of p) pCount[ch.charCodeAt(0) - a]++;
    for (let i = 0; i < p.length; i++) sCount[s.charCodeAt(i) - a]++;

    if (pCount.join(',') === sCount.join(',')) result.push(0);

    for (let i = p.length; i < s.length; i++) {
        sCount[s.charCodeAt(i) - a]++;
        sCount[s.charCodeAt(i - p.length) - a]--;
        if (pCount.join(',') === sCount.join(',')) result.push(i - p.length + 1);
    }

    return result;
}

function runTests() {
    const tests = [
        { s: "cbaebabacd", p: "abc", expected: [0, 6] },
        { s: "abab",       p: "ab",  expected: [0, 1, 2] },
        { s: "af",         p: "be",  expected: [] },
        { s: "aa",         p: "bb",  expected: [] },
        { s: "a",          p: "a",   expected: [0] },
        { s: "baa",        p: "aa",  expected: [1] },
    ];

    for (const { s, p, expected } of tests) {
        const result = findAnagrams(s, p);
        const pass = JSON.stringify(result) === JSON.stringify(expected);
        console.log(`[${pass ? "PASS" : "FAIL"}] s="${s}" p="${p}" result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

runTests();

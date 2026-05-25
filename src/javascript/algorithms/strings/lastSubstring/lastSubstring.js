// Two-pointer string comparison  TC: O(n) SC: O(1)

function lastSubstring(s) {
    const n = s.length;
    let i = 0;   // current best suffix start
    let j = 1;   // challenger suffix start
    let k = 0;   // comparison offset

    while (j + k < n) {
        if (s[i + k] === s[j + k]) {
            k++;
        } else if (s[i + k] < s[j + k]) {   // challenger is better
            i = Math.max(i + k + 1, j);
            j = i + 1;
            k = 0;
        } else {                              // current best is better
            j = j + k + 1;
            k = 0;
        }
    }

    return s.slice(i);
}

function runTests() {
    const tests = [
        { s: "abab",     expected: "bab" },
        { s: "leetcode", expected: "tcode" },
        { s: "cacacb",   expected: "cb" },
        { s: "zz",       expected: "zz" },
        { s: "abcde",    expected: "e" },
    ];

    tests.forEach(({ s, expected }) => {
        const result = lastSubstring(s);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();

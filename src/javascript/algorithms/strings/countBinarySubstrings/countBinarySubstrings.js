/**
 * Count Binary Substrings (LeetCode 696)
 *
 * Return the number of substrings with equal consecutive 0s and 1s.
 *
 * Approach: Group Counting
 * TC: O(n)  SC: O(1)
 */

function countBinarySubstrings(s) {
    let prev = 0, curr = 1, count = 0;

    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            curr++;
        } else {
            count += Math.min(prev, curr);
            prev = curr;
            curr = 1;
        }
    }

    count += Math.min(prev, curr);
    return count;
}

const testCases = [
    { s: "00110011", expected: 6, label: "groups [2,2,2,2]" },
    { s: "10101",    expected: 4, label: "groups [1,1,1,1,1]" },
    { s: "00011",    expected: 2, label: "groups [3,2]" },
    { s: "0",        expected: 0, label: "single char" },
    { s: "01",       expected: 1, label: "groups [1,1]" },
    { s: "000111",   expected: 3, label: "groups [3,3]" },
];

testCases.forEach(({ s, expected, label }) => {
    const result = countBinarySubstrings(s);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] "${s}" (${label}): ${result} (expected ${expected})`);
});

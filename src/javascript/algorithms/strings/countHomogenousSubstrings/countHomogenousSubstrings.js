/**
 * Count Number of Homogeneous Substrings (LeetCode 1759)
 *
 * Return the number of homogeneous substrings modulo 10^9 + 7.
 *
 * Approach: Streak Counting
 * TC: O(n)  SC: O(1)
 */

const MOD = 1_000_000_007n;

function countHomogenousSubstrings(s) {
    let count = 0n, streak = 1n;

    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            streak++;
        } else {
            streak = 1n;
        }
        count = (count + streak) % MOD;
    }

    return Number((count + 1n) % MOD);
}

const testCases = [
    { s: "abbcccaa", expected: 13, label: "groups a(1)+b(2)+c(3)+a(2)" },
    { s: "xy",        expected: 2,  label: "groups x(1)+y(1)" },
    { s: "zzzzz",    expected: 15, label: "single group z(5)" },
    { s: "a",         expected: 1,  label: "single char" },
    { s: "aaa",       expected: 6,  label: "single group a(3)" },
    { s: "aab",       expected: 4,  label: "groups a(2)+b(1)" },
];

testCases.forEach(({ s, expected, label }) => {
    const result = countHomogenousSubstrings(s);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] "${s}" (${label}): ${result} (expected ${expected})`);
});

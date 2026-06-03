function maxPower(s) {
    if (!s || s.length === 0) return 0;
    let maxStreak = 1, current = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i-1]) {
            current++;
        } else {
            current = 1;
        }
        maxStreak = Math.max(maxStreak, current);
    }
    return maxStreak;
}

function runTests() {
    const tests = ["leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist", "", "a"];
    const expected = [2, 5, 5, 11, 1, 0, 1];
    for (let i = 0; i < tests.length; i++) {
        const result = maxPower(tests[i]);
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();

function removeOccurrences(s, part) {
    const m = part.length;
    const result = [];
    for (const ch of s) {
        result.push(ch);
        if (result.length >= m && result.slice(-m).join('') === part) {
            result.length -= m;
        }
    }
    return result.join('');
}

function runTests() {
    const tests = [
        ["daabcbaabcbc", "abc"],
        ["axxxxyyyyb", "xy"],
        ["aabababa", "aba"],
        ["aaaaa", "aa"],
        ["abcabcabc", "abc"],
        ["", "a"],
        ["abc", "d"]
    ];
    const expected = ["dab", "axxxxyyyyb", "ba", "a", "", "", "abc"];
    for (let i = 0; i < tests.length; i++) {
        const [s, part] = tests[i];
        const result = removeOccurrences(s, part);
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();

function stringShift(s, shift) {
    let netShift = 0;
    for (const [direction, amount] of shift) {
        if (direction === 0) netShift -= amount;
        else netShift += amount;
    }
    const n = s.length;
    netShift = (netShift % n + n) % n;
    if (netShift === 0) return s;
    return s.slice(-netShift) + s.slice(0, n - netShift);
}

function runTests() {
    const testStrings = ["abc", "abcdefg", "x", "hello", "rotation"];
    const testShifts = [
        [[0,1],[1,2]],
        [[1,1],[1,1],[0,2],[1,3]],
        [[0,100]],
        [[1,5]],
        [[0,3],[1,4]]
    ];
    const expected = ["cab", "efgabcd", "x", "hello", "tionrota"];
    for (let i = 0; i < testStrings.length; i++) {
        const result = stringShift(testStrings[i], testShifts[i]);
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();

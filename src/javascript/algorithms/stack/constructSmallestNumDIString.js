function smallestNumber(pattern) {
    let result = '';
    const stack = [];
    for (let i = 0; i <= pattern.length; i++) {
        stack.push(i + 1);
        if (i === pattern.length || pattern[i] === 'I') {
            while (stack.length) {
                result += stack.pop();
            }
        }
    }
    return result;
}

function runTests() {
    const patterns = ["IIIDIDDD", "D", "I", "DDI", "IDID", ""];
    const expected = ["123549876", "21", "12", "3214", "13254", "1"];
    for (let i = 0; i < patterns.length; i++) {
        const result = smallestNumber(patterns[i]);
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();

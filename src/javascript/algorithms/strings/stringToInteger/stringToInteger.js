// String traversal  TC: O(n) SC: O(1)
const INT_MAX =  2147483647;
const INT_MIN = -2147483648;

function myAtoI(s) {
    let i = 0;
    let result = 0;
    let sign = 1;

    // Skip leading whitespace
    while (i < s.length && s[i] === ' ') i++;

    // Check sign (only once)
    if (i < s.length && (s[i] === '+' || s[i] === '-')) {
        sign = s[i] === '-' ? -1 : 1;
        i++;
    }

    // Convert digits
    while (i < s.length && s[i] >= '0' && s[i] <= '9') {
        result = result * 10 + parseInt(s[i]);
        i++;

        // Handle overflow
        if (sign * result > INT_MAX) return INT_MAX;
        if (sign * result < INT_MIN) return INT_MIN;
    }

    return sign * result;
}

function runTests() {
    const tests = [
        { s: "42",            expected: 42 },
        { s: "   -042",       expected: -42 },
        { s: "1337c0d3",      expected: 1337 },
        { s: "0-1",           expected: 0 },
        { s: "-91283472332",  expected: INT_MIN },
    ];

    tests.forEach(({ s, expected }) => {
        const result = myAtoI(s);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();

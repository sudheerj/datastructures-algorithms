// Multiply Strings
// Given two non-negative integers num1 and num2 represented as strings, return the product as a string.

function multiplyStrings(num1, num2) {
    if (num1 === "0" || num2 === "0") return "0";
    const m = num1.length, n = num2.length;
    const res = new Array(m + n).fill(0);
    const s1 = num1.split('').reverse().join('');
    const s2 = num2.split('').reverse().join('');
    for (let i = 0; i < s1.length; i++) {
        for (let j = 0; j < s2.length; j++) {
            const digit = (s1[i] - '0') * (s2[j] - '0');
            res[i + j] += digit;
            res[i + j + 1] += Math.floor(res[i + j] / 10);
            res[i + j] = res[i + j] % 10;
        }
    }
    let i = res.length - 1;
    while (i > 0 && res[i] === 0) i--;
    let result = '';
    while (i >= 0) result += res[i--];
    return result;
}

// Test cases
const testCases = [
    ["2", "3"],           // 6
    ["123", "456"],       // 56088
    ["0", "12345"],       // 0
    ["999", "999"],       // 998001
    ["123456789", "987654321"] // 121932631112635269
];
testCases.forEach(([num1, num2], i) => {
    console.log(`Test case ${i + 1}: num1 = '${num1}', num2 = '${num2}'`);
    console.log('Output:', multiplyStrings(num1, num2));
});

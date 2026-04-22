function addBinary(a, b) {
    let result = [];
    let i = a.length - 1, j = b.length - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry) {
        let curr = carry;
        if (i >= 0) curr += +a[i--];
        if (j >= 0) curr += +b[j--];
        result.push(curr % 2);
        carry = Math.floor(curr / 2);
    }
    return result.reverse().join("");
}

if (require.main === module) {
    const testCases = [
        ["11", "1", "100"],
        ["1010", "1011", "10101"],
        ["0", "0", "0"],
        ["1", "0", "1"],
        ["111", "111", "1110"],
        ["", "1", "1"],
        ["1", "", "1"],
        ["", "", ""],
    ];
    testCases.forEach(([a, b, expected], i) => {
        const result = addBinary(a, b);
        console.log(`Test ${i+1}: addBinary('${a}', '${b}') = '${result}' | Expected: '${expected}' | ${result === expected ? 'PASS' : 'FAIL'}`);
    });
}

module.exports = addBinary;

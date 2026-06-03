const { betterCompression } = require('./betterStringCompression');

const testCases = [
    ["a3b2c1", "a3b2c1"],
    ["a12b56c1a2", "a14b56c1"],
    ["x1y2z3x4", "x5y2z3"],
    ["a1b1c1d1e1f1", "a1b1c1d1e1f1"],
    ["a10b10a10", "a20b10"],
    ["a1b2c3d4e5f6g7h8i9j10", "a1b2c3d4e5f6g7h8i9j10"],
    ["a1a1a1a1", "a4"],
    ["m5n10m5n10", "m10n20"],
];

testCases.forEach(([input, expected]) => {
    const result = betterCompression(input);
    const status = result === expected ? 'PASS' : 'FAIL';
    console.log(`Input: "${input}" | Output: "${result}" | Expected: "${expected}" | ${status}`);
});

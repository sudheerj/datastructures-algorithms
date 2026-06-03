const { numberToWords } = require('./integerToEnglishWords');

const testCases = [
    [0, "Zero"],
    [5, "Five"],
    [13, "Thirteen"],
    [20, "Twenty"],
    [45, "Forty Five"],
    [100, "One Hundred"],
    [123, "One Hundred Twenty Three"],
    [1000, "One Thousand"],
    [12345, "Twelve Thousand Three Hundred Forty Five"],
    [1000000, "One Million"],
    [1000000000, "One Billion"],
    [1234567891, "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"],
];

testCases.forEach(([input, expected]) => {
    const result = numberToWords(input).replace(/\s+/g, ' ').trim();
    const status = result === expected ? 'PASS' : 'FAIL';
    console.log(`Input: ${input} | Output: "${result}" | Expected: "${expected}" | ${status}`);
});

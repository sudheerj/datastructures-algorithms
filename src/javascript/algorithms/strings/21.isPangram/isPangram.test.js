const { isPangram } = require('./isPangram');


const testCases = [
    ["abcdefghijklmnopqrstuvwxyz", "pangram"],
    ["abcdefghijklmnopqrstuvwxy", "not pangram"],
    ["Abcdefghijklmnopqrstuvwxyz", "pangram"],
    ["A quick brown fox", "not pangram"],
    ["Mr. Jock, TV quiz PhD, bags few lynx.", "pangram"],
    ["Waltz, nymph, for quick jigs vex Bud.", "pangram"],
    ["John Doe", "not pangram"],
    ["Pack my box with five dozen liquor jugs.", "pangram"],
];

testCases.forEach(([input, expected]) => {
    const result = isPangram(input);
    const status = result === expected ? 'PASS' : 'FAIL';
    console.log(`Input: "${input}" | Output: "${result}" | Expected: "${expected}" | ${status}`);
});

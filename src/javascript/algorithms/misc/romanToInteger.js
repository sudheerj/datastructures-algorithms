// Roman to Integer
//
// Time Complexity: O(n), where n is the length of the input string.
// Space Complexity: O(1), since the map size is constant and only a few variables are used.
function romanToInteger(s) {
    const roman = {I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000};
    let result = 0, prev = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        const curr = roman[s[i]];
        if (curr < prev) {
            result -= curr;
        } else {
            result += curr;
        }
        prev = curr;
    }
    return result;
}

// Test cases
const tests = ["III", "IV", "IX", "LVIII", "MCMXCIV", "XL", "XC", "CD", "CM"];
const expected = [3, 4, 9, 58, 1994, 40, 90, 400, 900];
for (let i = 0; i < tests.length; i++) {
    const res = romanToInteger(tests[i]);
    console.log(`romanToInteger('${tests[i]}') = ${res} | Expected: ${expected[i]}`);
}

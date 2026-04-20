function reverseInteger(x) {
    let result = 0;
    let sign = x < 0 ? -1 : 1;
    x = Math.abs(x);
    while (x !== 0) {
        let digit = x % 10;
        x = Math.floor(x / 10);
        if (result > Math.floor((2 ** 31 - 1) / 10)) return 0;
        result = result * 10 + digit;
    }
    result *= sign;
    if (result < -(2 ** 31) || result > 2 ** 31 - 1) return 0;
    return result;
}


// Example 1: Positive number
console.log(reverseInteger(123)); // Expected: 321
// Example 2: Negative number
console.log(reverseInteger(-456)); // Expected: -654
// Example 3: Number with trailing zeros
console.log(reverseInteger(1200)); // Expected: 21
// Example 4: Zero
console.log(reverseInteger(0)); // Expected: 0
// Example 5: Overflow positive
console.log(reverseInteger(1534236469)); // Expected: 0
// Example 6: Overflow negative
console.log(reverseInteger(-1563847412)); // Expected: 0

module.exports = { reverseInteger };

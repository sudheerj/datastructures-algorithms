function plusOne(digits) {
    if (!digits || digits.length === 0) return [1];
    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    digits.unshift(1);
    return digits;
}

// Example 1: No carry
console.log("Input: [1, 2, 3] -> Output:", plusOne([1, 2, 3]));
// Example 2: Carry at the end
console.log("Input: [1, 2, 9] -> Output:", plusOne([1, 2, 9]));
// Example 3: All 9's
console.log("Input: [9, 9, 9] -> Output:", plusOne([9, 9, 9]));
// Example 4: Single digit, no carry
console.log("Input: [5] -> Output:", plusOne([5]));
// Example 5: Single digit, carry
console.log("Input: [9] -> Output:", plusOne([9]));
// Example 6: Leading zeros
console.log("Input: [0, 0, 1] -> Output:", plusOne([0, 0, 1]));
// Example 7: Empty array (edge case)
console.log("Input: [] -> Output:", plusOne([]));

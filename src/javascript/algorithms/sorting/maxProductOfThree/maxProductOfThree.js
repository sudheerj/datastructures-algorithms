// TC: O(n log n), SC: O(1)
function maxProductOfThree(numbers) {
    numbers.sort((a, b) => a - b);

    const n = numbers.length;

    // 1. Product of the three largest numbers
    const product1 = numbers[n-1] * numbers[n-2] * numbers[n-3];
    // 2. Product of two smallest (possibly negative) and the largest
    const product2 = numbers[0] * numbers[1] * numbers[n-1];

    return Math.max(product1, product2);
}

// Test Case 1: Mixed positives and negatives
console.log(maxProductOfThree([-3, 1, 2, -2, 5, 6])); // ➞ 60 // Best triplet: 2 * 5 * 6 = 60

// Test Case 2: Two negatives and one large positive
console.log(maxProductOfThree([-10, -10, 1, 3, 2])); // ➞ 300 // Best triplet: -10 * -10 * 3 = 300

// Test Case 3: All positive
console.log(maxProductOfThree([1, 2, 3])); // ➞ 6 // Best triplet: 1 * 2 * 3 = 6

// Test Case 4: All negative
console.log(maxProductOfThree([-1, -2, -3, -4])); // ➞ -6 // Best triplet: -1 * -2 * -3 = -6
function minAbsSumOfTwo(numbers) {
    // Step 1: Sort the array
    numbers.sort((a, b) => a - b);
    let left =0, right = numbers.length - 1;
    let minAbsSum = Infinity;

    while(left <= right) {
        let sum = numbers[left] + numbers[right];
        let absSum = Math.abs(sum);

        minAbsSum = Math.min(minAbsSum, absSum);

        // Move the pointer that brings us closer to 0
        if(sum < 0) {
            left++;
        } else {
            right--;
        }
    }

    return minAbsSum;
}

console.log(minAbsSumOfTwo([1, 4, -3]));         // Output: 1  (1 + (-3) = -2 → |1 + (-3)| = 2, 1 + 4 = 5, -3 + 4 = 1)
console.log(minAbsSumOfTwo([-8, 4, 5, -10, 3])); // Output: 1  (-8 + 5 = -3, -10 + 4 = -6, 3 + (-4) = -1)
console.log(minAbsSumOfTwo([2, 2, 2]));          // Output: 4  (2 + 2)
console.log(minAbsSumOfTwo([-1, -2, -3]));       // Output: 2  (-1 + -1 = -2 → | -2 |)
console.log(minAbsSumOfTwo([0, 0]));             // Output: 0

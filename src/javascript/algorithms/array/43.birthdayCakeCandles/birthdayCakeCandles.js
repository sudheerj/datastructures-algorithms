function birthdayCakeCandles(arr) {
    const max = Math.max(...arr);
    return arr.filter(candle => candle === max).length;
}

// Test cases
console.log(birthdayCakeCandles([3, 2, 1, 3])); // Output: 2
console.log(birthdayCakeCandles([4, 4, 1, 3])); // Output: 2
console.log(birthdayCakeCandles([1, 2, 3, 4])); // Output: 1
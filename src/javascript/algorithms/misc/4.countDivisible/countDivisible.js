function countDivisible(firstNumber, secondNumber, divisor) {
    const countDivisibleUntilSecondNum = Math.floor(secondNumber/divisor);
    const countDivisibleBeforeFirstNum = Math.floor((firstNumber-1)/divisor);

    return countDivisibleUntilSecondNum - countDivisibleBeforeFirstNum;
}

console.log(countDivisible(6, 11, 2)); // Output: 3
console.log(countDivisible(0, 0, 11)); // Output: 1 (0 is divisible by 11)
console.log(countDivisible(10, 10, 5)); // Output: 1 (10 is divisible by 5)
console.log(countDivisible(10, 10, 7)); // Output: 0 (10 is not divisible by 7)

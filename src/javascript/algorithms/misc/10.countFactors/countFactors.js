function countFactors(number) {
    const sqrt = Math.sqrt(number);
    let count = 0;

    for(let i = 1; i <=sqrt; i++) {
        if( number % i === 0 )  {
            if( i === number/i) {
                count++;
            } else {
                count += 2;
            }
        }
    }

    return count;
}

console.log(countFactors(24));  // Output: 8 → [1, 2, 3, 4, 6, 8, 12, 24]
console.log(countFactors(16));  // Output: 5 → [1, 2, 4, 8, 16]
console.log(countFactors(1));   // Output: 1
console.log(countFactors(2));   // Output: 2 → [1, 2]

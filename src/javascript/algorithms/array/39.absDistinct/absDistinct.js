function absDistinct(numbers) {
    numbers.sort((a, b) => a - b);
    const seen = new Set();

    let left = 0, right = numbers.length - 1;

    while(left <= right) {
        const leftAbs = Math.abs(numbers[left]);
        const rightAbs = Math.abs(numbers[right]);

        if(leftAbs > rightAbs) {
            seen.add(leftAbs);
            left++;
        } else {
            seen.add(rightAbs);
            right--;
        }
    }

    return seen.size;
}

console.log(absDistinct([-5, -3, -1, 0, 3, 6])); // Output: 5
console.log(absDistinct([-2, -1, 0, 1, 2, 2]));  // Output: 3
console.log(absDistinct([-1, -1, -1, 1, 1, 1])); // Output: 1
console.log(absDistinct([]));                   // Output: 0

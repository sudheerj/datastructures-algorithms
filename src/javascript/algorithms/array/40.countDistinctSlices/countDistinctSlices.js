function countDistinctSlices(m, numbers) {
    const length = numbers.length;
    const seen = Array(m+1).fill(false);

    let left = 0, right = 0, total = 0;

    while(right < length) {
        if(!seen[numbers[right]]) {
            seen[numbers[right]] = true;
            total += right - left + 1;
            if(total > 1000000000)  return 1000000000;
            right++;
        } else {
            seen[numbers[left]] = false;
            left++;
        }
    }

    return total;
}

console.log(countDistinctSlices(6, [3, 4, 5, 5, 2]));   // [3, 4, 5, 5, 2] → Output: 9
console.log(countDistinctSlices(5, [1, 2, 3, 4]));      // [1, 2, 3, 4] → Output: 10
console.log(countDistinctSlices(2, [1, 1, 1, 1]));      // [1, 1, 1, 1] → Output: 4
console.log(countDistinctSlices(3, [0, 1, 0, 2, 0]));   // [0, 1, 0, 2, 0] → Output: 10
function tapeEquilibrium(nums) {
    let totalSum = nums.reduce((sum, num) => sum + num, 0);
    let minDiff = Infinity;
    let leftSum = 0;

    for(const num of nums) {
        leftSum += num;
        const rightSum = totalSum - leftSum;
        const diff = Math.abs(leftSum - rightSum);
        minDiff = Math.min(minDiff, diff);
    }

    return minDiff;
}


console.log(tapeEquilibrium([3, 1, 2, 4, 3])); // Output: 1
console.log(tapeEquilibrium([5, 6, 2, 4, 1])); // Output: 4
console.log(tapeEquilibrium([1, 2]));          // Output: 1

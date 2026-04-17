function equilibriumIndex(nums) {
    let total = nums.reduce((a, b) => a + b, 0);
    let leftSum = 0;
    for (let i = 0; i < nums.length; i++) {
        let rightSum = total - leftSum - nums[i];
        if (leftSum === rightSum) return i;
        leftSum += nums[i];
    }
    return nums.length === 1 ? 0 : -1;
}

module.exports = equilibriumIndex;

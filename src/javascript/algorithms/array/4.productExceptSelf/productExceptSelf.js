function productExceptSelf(nums) {
    const length = nums.length;
    const result = new Array(length);
    let prefix = 1,  postfix = 1;

    // Calculate prefix products
    for(let i=0; i<length; i++) {
        result[i] = prefix;
        prefix *= nums[i];
    }

    // Calculate postfix products and multiply them with prefix products
    for(let i=length-1; i>=0; i--) {
        result[i] *= postfix;
        postfix *= nums[i];
    }

    return result;
}

// Test cases
const testCases = [
    [1, 2, 3, 4, 5],
    [-3, 3, 2, 0, -4],
    [0, 0],
    [1],
    [2, 3]
];

testCases.forEach((nums, idx) => {
    console.log(`Test Case ${idx + 1}`);
    console.log(`Input: ${nums}`);
    console.log(`Output: ${productExceptSelf(nums)}\n`);
});

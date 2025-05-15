function productExceptSelf(nums) {
    const result = new Array(nums.length);
    let prefix = postfix = 1;

    // Calculate prefix products
    for(let i=0; i<nums.length; i++) {
        result[i] = prefix;
        prefix *= nums[i];
    }

    // Calculate postfix products and multiply them with prefix products
    for(let i=nums.length-1; i>=0; i--) {
        result[i] *= postfix;
        postfix *= nums[i];
    }

    return result;
}

// Test cases
const nums1 = [1, 2, 3, 4, 5];
console.log(`Input: ${nums1}, Output: ${productExceptSelf(nums1)}`);

const nums2 = [-3, 3, 2, 0, -4];
console.log(`Input: ${nums2}, Output: ${productExceptSelf(nums2)}`);
function productExceptSelf(nums) {
    let result =[];
    let prefix = postfix = 1;

    for(let i=0; i<nums.length; i++) {
        result[i] = prefix;
        prefix *= nums[i];
    }

    for(let i=nums.length-1; i>=0; i--) {
        result[i] *= postfix;
        postfix *= nums[i];
    }

    return result;
}

let nums1 = [1, 2, 3, 4, 5];
console.log(productExceptSelf(nums1));
let nums2 = [-3, 3, 2, 0, -4];
console.log(productExceptSelf(nums2));
function maxProductSubArray(nums) {
    let result = nums[0], currentMax = nums[0], currentMin = nums[0];

    for(let i=1; i < nums.length; i++) {
        const num = nums[i];
        const tempMaxProduct = currentMax * num;
        const tempMinProduct = currentMin * num;
        currentMax = Math.max(num, tempMaxProduct, tempMinProduct);
        currentMin = Math.min(num, tempMaxProduct, tempMinProduct);
        result = Math.max(result, currentMax);
    }
    return result;
}

let numbers1 = [6, 7,-4, 5, 8, 1];
console.log(maxProductSubArray(numbers1));
let numbers2 = [2, -7, -4, 0, 3, 3];
console.log(maxProductSubArray(numbers2));
function maxProductSubArray(nums) {
    let result = nums[0];
    let currentMax = currentMin = 1;

    for(let num of nums) {
        let tempMaxProduct = currentMax * num;
        let tempMinProduct = currentMin * num;
        currentMax = Math.max(Math.max(tempMaxProduct, tempMinProduct), num);
        currentMin = Math.min(Math.min(tempMaxProduct, tempMinProduct), num);
        result = Math.max(result, currentMax);
    }
    return result;
}

let numbers1 = [6, 7,-4, 5, 8, 1];
console.log(maxProductSubArray(numbers1));
let numbers2 = [2, 7,-4, 0, 3, 3];
console.log(maxProductSubArray(numbers2));
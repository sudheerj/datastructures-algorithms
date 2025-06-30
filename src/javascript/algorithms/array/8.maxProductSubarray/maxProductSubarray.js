function maxProductSubArray(nums) {
    let globaMax = nums[0], currentMax = nums[0], currentMin = nums[0];

    for(let i=1; i < nums.length; i++) {
        const num = nums[i];

        if(num < 0) [currentMin, currentMax] = [currentMax, currentMin];

        currentMax = Math.max(num, currentMax * num);
        currentMin = Math.min(num, currentMin * num);

        globaMax = Math.max(globaMax, currentMax);
    }
    return globaMax;
}

let numbers1 = [6, 7,-4, 5, 8, 1];
console.log(maxProductSubArray(numbers1));
let numbers2 = [2, -7, -4, 0, 3, 3];
console.log(maxProductSubArray(numbers2));
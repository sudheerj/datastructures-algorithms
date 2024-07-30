function firstMissingPositive(nums) {
    let length = nums.length;
    let nonExistNum = length + 1;

    for(let i = 0; i < length; i++) {
        if(nums[i] <=0 || nums[i] > length) {
            nums[i] = nonExistNum;
        }
    }

    for(let i=0; i< length; i++) {
        let index = Math.abs(nums[i]);
        if(index === nonExistNum) {
            continue;
        }

        index--;
        if(nums[index] > 0) {
            nums[index] = -1 * nums[index];
        }
    }

    for(let i=0; i< length; i++) {
        if(nums[i] > 0) {
            return i+1;
        }
    }

    return nonExistNum;
}

let nums1 = [3 ,4, -1, 1];
let nums2 = [-1,7,8,9,11,12,-10];
let nums3 = [1,2,0];

console.log(firstMissingPositive(nums1));
console.log(firstMissingPositive(nums2));
console.log(firstMissingPositive(nums3));
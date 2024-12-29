function findDuplicateAndMissing(nums){
    const length = nums.length;
    let duplicate = -1;
    let missing = -1;

    for (let num of nums) {
        num = Math.abs(num);
        if(nums[num-1]<0) {
            duplicate = num;
        } else {
            nums[num-1] = -nums[num-1];
        }
    }

    for (let i=0; i<length; i++) {
        if(nums[i] >0) {
            missing = i+1;
        }
    }

    return [duplicate, missing];
}

const nums1 = [1,3,3,4];
const nums2 = [1,1];
console.log(findDuplicateAndMissing(nums1));
console.log(findDuplicateAndMissing(nums2));
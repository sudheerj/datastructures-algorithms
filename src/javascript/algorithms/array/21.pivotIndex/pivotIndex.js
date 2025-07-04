function pivotIndex1(nums){
    const totalSum = nums.reduce((acc, num) => acc+num, 0);
    let leftSum = 0, rightSum = 0;

    for (let i = 0; i < nums.length; i++) {
        rightSum = totalSum - leftSum - nums[i];
        if(rightSum === leftSum) {
            return i;
        }
        
        leftSum += nums[i];
    }

    return -1;
}

function pivotIndex2(nums){
    let leftSumMap = new Map();
    let rightSumMap = new Map();
    let leftSum =0;
    let rightSum = 0;

    for (let i = 0; i < nums.length; i++) {
        if(i>0) {
            leftSum += nums[i-1];
        }
        leftSumMap.set(i, leftSum);
    }

    for (let i = nums.length-1; i >= 0; i--) {
        if(i<nums.length-1){
            rightSum += nums[i+1];
        }
        rightSumMap.set(i, rightSum);
    }

    for (let i = 0; i < nums.length; i++) {
        if(leftSumMap.get(i) === rightSumMap.get(i)) {
            return i;
        }
    }

    return -1;
}

let nums1 = [2,6,4,2,5,7];
let nums2 = [1,2,3,4];
console.log(pivotIndex1(nums1));
console.log(pivotIndex1(nums2));
console.log(pivotIndex2(nums1));
console.log(pivotIndex2(nums2));
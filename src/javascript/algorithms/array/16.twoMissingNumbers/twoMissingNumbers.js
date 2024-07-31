//TC: O(n) SC: O(n)
function findTwoMissingNumbers(nums) {
    let present = new Array(nums.length+2).fill(false);
    let missingTwoNums = [];

    for(let num of nums) {
        present[num-1] = true;
    }

    for (let i = 1; i <= nums.length+2; i++) {
        if(!present[i-1]) {
            missingTwoNums.push(i);
        }
    }

    return missingTwoNums;
}

//TC: O(n) SC: O(1)
function findTwoMissingNumbers1(nums) {
    let missingTwoNums =[];
    let len = nums.length+2;
    let sum = Math.floor((len * (len + 1))/2);

    let numsSum = 0;
    for (let i = 0; i < nums.length; i++) {
        numsSum += nums[i];
    }

    let missingTwoNumsSum = sum - numsSum; 
    let missingTwoNumsAvg = Math.floor(missingTwoNumsSum/2); 

    let sumUntilAvg = Math.floor((missingTwoNumsAvg * (missingTwoNumsAvg + 1))/2); 
    let numsSumUntilAvg = 0;
    
    for(let i=0; i<nums.length; i++){
        if(nums[i] <= missingTwoNumsAvg) {
            numsSumUntilAvg += nums[i]; 
        }
    }

    let missingFirstNum = sumUntilAvg-numsSumUntilAvg;
    missingTwoNums.push(missingFirstNum);
    missingTwoNums.push(missingTwoNumsSum - missingFirstNum);
    
    return missingTwoNums;
}


const nums1 = [3, 2, 5, 1, 6, 8];
const nums2 = [3, 2, 5, 1, 6, 4];
console.log(findTwoMissingNumbers(nums1));
console.log(findTwoMissingNumbers(nums2));

console.log(findTwoMissingNumbers1(nums1));
console.log(findTwoMissingNumbers1(nums2));
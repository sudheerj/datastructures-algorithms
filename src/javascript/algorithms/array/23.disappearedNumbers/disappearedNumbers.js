function findDisappearedNumbers(nums){
    for (let i = 0; i < nums.length; i++) {
        const index = Math.abs(nums[i])-1;
        if(nums[index]>0) {
            nums[index] = -nums[index];
        }
    }

    let missingNumbers = [];
    for (let i = 0; i < nums.length; i++) {
        if(nums[i] >0) {
            missingNumbers.push(i+1);
        }
    }

    return missingNumbers;
}

const nums1= [6, 3, 1, 5, 3, 7, 5];
const nums2= [1,1];

console.log(findDisappearedNumbers(nums1));
console.log(findDisappearedNumbers(nums2));
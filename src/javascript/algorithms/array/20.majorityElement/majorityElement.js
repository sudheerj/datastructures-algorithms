function majorityElement(nums){
    let count = 0;
    let candidate = null;

    for (const num of nums) {
        if(count === 0) {
            candidate = num;
        }

        count += num === candidate ? 1 : -1;
    }

    return candidate;
}

const nums1 = [5,4,5,5];
const nums2 = [3,4,3,5,3,3,1,3];
console.log(majorityElement(nums1));
console.log(majorityElement(nums2));
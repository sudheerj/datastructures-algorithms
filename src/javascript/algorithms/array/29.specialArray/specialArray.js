function specialArray(nums){
    const len = nums.length;
    const counts = new Array(len+1).fill(0);

    //Step1: Count frequencies
    for (const num of nums) {
        if(num >= len) {
            counts[len]++;
        } else {
            counts[num]++;
        }
    }

    let elementsGreaterThanX = 0;
    //Step2: Return x number of elements greater or equal to x
    for (let x = len; x >=1 ; x--) {
        elementsGreaterThanX += counts[x];
        if(elementsGreaterThanX === x) {
            return x;
        }  
    }

    return -1;
}

const nums1 = [2,3];
const nums2 = [0,0,0];
const nums3 = [0,4,3,0,4];
console.log(specialArray(nums1));
console.log(specialArray(nums2));
console.log(specialArray(nums3));
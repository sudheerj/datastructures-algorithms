function removeElement(nums, val){
    let k=0;
    for (const num of nums) {
        if(num !== val) {
            nums[k] = num;
            k++;
        }       
    }

    return k;
}

const nums1 = [4, 1, 1, 4, 1], val1=4;
console.log(removeElement(nums1, val1));
const nums2 = [0, 3, 5, 5, 3, 1, 5, 2], val2=5;
console.log(removeElement(nums2, val2));



function intersection(nums1, nums2) {
    const set = new Set(nums1);
    const result = [];

    for (const num of nums2) {
        if(set.has(num)) {
            result.push(num);
            set.delete(num);
        }
    }

    return result;
}

const nums1 = [5,3,3,5], nums2 = [5,3];
const nums3 = [1, 3, 5], nums4 = [2,4];
console.log(intersection(nums1, nums2));
console.log(intersection(nums3, nums4));
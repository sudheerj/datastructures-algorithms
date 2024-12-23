function findIdenticalPairs(nums){
    let count = 0;
    let frequencyMap = {};

    for (const num of nums) {
        if(frequencyMap[num]) {
            count += frequencyMap[num];
            frequencyMap[num]++;
        } else {
            frequencyMap[num] = 1;
        }
    }

    return count;
}

const nums1 = [6, 3, 1, 5, 3, 6, 5, 6];
const nums2 = [2, 2, 2, 2];
const nums3 = [1, 2, 3, 4];

console.log(findIdenticalPairs(nums1));
console.log(findIdenticalPairs(nums2));
console.log(findIdenticalPairs(nums3));
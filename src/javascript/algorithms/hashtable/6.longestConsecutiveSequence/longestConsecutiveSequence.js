// TC: O(2n) ~ O(n) SC: O(n)

function longestConsecutiveSequence(nums) {
    const numSet = new Set(nums);
    let longestStreak = 0;

    for(let num of [...numSet]) {
        //Check if left element exists to find the sequence
        if(!numSet.has(num-1)) {
            let currentStreak = 1;
            while(numSet.has(num+1)) {
                currentStreak++;
                num++;
            }
            longestStreak = Math.max(currentStreak, longestStreak);
        }
        if(longestStreak > nums.length/2) break;
    }

    return longestStreak;
}

let nums1 = [20, 4, 10, 1, 3, 2];
console.log(longestConsecutiveSequence(nums1));
let nums2 = [7, 0, 6, 2, 3, 1, 5, 4];
console.log(longestConsecutiveSequence(nums2));
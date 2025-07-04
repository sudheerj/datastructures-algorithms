function dominator(nums){
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

function equiLeader(nums) {
    if(nums.length === 0) return 0;

    const leaderCandidate = dominator(nums);
    const totalOccurrences = nums.filter(num => num === leaderCandidate).length;

    if(totalOccurrences <= nums.length/ 2) return 0;

    let equileaders = 0;
    let leadersCountSoFar = 0;

    for(let i = 0; i < nums.length-1; i++) {
        if(nums[i] === leaderCandidate) {
            leadersCountSoFar++;
        }

        let leftLeadersCount = leadersCountSoFar;
        let rightLeadersCount = totalOccurrences - leadersCountSoFar;
        let leftSize = i + 1;
        let rightSize = nums.length - leftSize;

        if(leftLeadersCount > leftSize / 2 && rightLeadersCount > rightSize / 2) {
            equileaders++;
        }
    }

    return equileaders;
}

console.log(equiLeader([4, 3, 4, 4, 4, 2]));       // ➤ Output: 2
console.log(equiLeader([1, 2, 1, 1, 2, 1]));       // ➤ Output: 2
console.log(equiLeader([1, 2, 3, 4, 5]));          // ➤ Output: 0
console.log(equiLeader([7, 7, 7, 7, 7]));          // ➤ Output: 4
console.log(equiLeader([0, 0, 1, 0, 2, 0, 0]));    // ➤ Output: 3
console.log(equiLeader([5, 5, 1, 1, 5, 5, 1, 5])); // ➤ Output: 2
console.log(equiLeader([]));                      // ➤ Output: 0
console.log(equiLeader([1]));                     // ➤ Output: 0

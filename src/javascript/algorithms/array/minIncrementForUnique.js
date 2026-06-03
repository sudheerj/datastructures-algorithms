function minIncrementForUnique(nums) {
    nums.sort((a, b) => a - b);
    let moves = 0;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            moves += nums[i - 1] + 1 - nums[i];
            nums[i] = nums[i - 1] + 1;
        }
    }
    return moves;
}

if (require.main === module) {
    const tests = [
        [[1,2,2], 1],
        [[3,2,1,2,1,7], 6],
        [[0,2,2,2,3,7], 8],
        [[1,1,1,1], 6],
        [[0,0,0,0,0], 10],
        [[1,2,3], 0],
        [[2,2,2,2,2,2,2], 21],
        [[100,100,100], 3],
    ];
    tests.forEach(([nums, expected], idx) => {
        const result = minIncrementForUnique(nums.slice());
        console.log(`Test ${idx+1}: Output=${result}, Expected=${expected} [${result===expected?'PASS':'FAIL'}]`);
    });
}

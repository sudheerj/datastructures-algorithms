function circularArrayLoop(nums) {
    const n = nums.length;
    const next = (i) => ((i + nums[i]) % n + n) % n;
    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) continue;
        let direction = nums[i] > 0;
        let slow = i, fast = i;
        while (true) {
            let nextSlow = next(slow);
            let nextFast = next(fast);
            if (nums[fast] * nums[nextFast] <= 0 || nums[slow] * nums[nextSlow] <= 0) break;
            let fast2 = next(nextFast);
            if (nums[fast] * nums[fast2] <= 0) break;
            slow = nextSlow;
            fast = fast2;
            if (slow === fast) {
                if (slow === next(slow)) break;
                return true;
            }
        }
        // Mark all nodes in this path as 0
        let j = i, val = nums[i];
        while (nums[j] * val > 0) {
            let nxt = next(j);
            nums[j] = 0;
            j = nxt;
        }
    }
    return false;
}

if (require.main === module) {
    const tests = [
        [[2,-1,1,2,2], true],
        [[-1,2], false],
        [[-2,1,-1,-2,-2], false],
        [[1,1,2], true],
        [[1,2,3,4,5,6,7,8,9,10], true],
        [[1,-1,5,1,4], false],
        [[1,1,1,1,1,1,1,1,1,1], true],
        [[0,1,2], false],
    ];
    tests.forEach(([nums, expected], idx) => {
        const result = circularArrayLoop(nums.slice());
        console.log(`Test ${idx+1}: Output=${result}, Expected=${expected} [${result===expected?'PASS':'FAIL'}]`);
    });
}

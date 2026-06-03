/**
 * Maximum Profit in Job Scheduling
 * 
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
 * obtaining a profit of profit[i].
 * 
 * Return the maximum profit you can take such that there are no two jobs in the subset
 * with overlapping time range.
 */

/**
 * Recursive with start times sorting TC: O(2^n) SC: O(n)
 */
function jobSchedulingRecursive(startTime, endTime, profit) {
    const n = startTime.length;
    const jobs = [];
    
    for (let i = 0; i < n; i++) {
        jobs.push([startTime[i], endTime[i], profit[i]]);
    }
    
    jobs.sort((a, b) => a[0] - b[0]);
    
    function dfs(i) {
        if (i === n) return 0;
        
        // Skip current job
        const skip = dfs(i + 1);
        
        // Take current job and find next non-overlapping job
        let nextIdx = i + 1;
        while (nextIdx < n && jobs[i][1] > jobs[nextIdx][0]) {
            nextIdx++;
        }
        
        const take = jobs[i][2] + dfs(nextIdx);
        
        return Math.max(skip, take);
    }
    
    return dfs(0);
}

/**
 * Top-down memoization TC: O(n^2) SC: O(n)
 */
function jobSchedulingMemoization(startTime, endTime, profit) {
    const n = startTime.length;
    const jobs = [];
    
    for (let i = 0; i < n; i++) {
        jobs.push([startTime[i], endTime[i], profit[i]]);
    }
    
    jobs.sort((a, b) => a[0] - b[0]);
    const dp = new Array(n).fill(-1);
    
    function dfs(i) {
        if (i === n) return 0;
        
        if (dp[i] !== -1) return dp[i];
        
        // Skip current job
        const skip = dfs(i + 1);
        
        // Take current job and find next non-overlapping job
        let nextIdx = i + 1;
        while (nextIdx < n && jobs[i][1] > jobs[nextIdx][0]) {
            nextIdx++;
        }
        
        const take = jobs[i][2] + dfs(nextIdx);
        
        dp[i] = Math.max(skip, take);
        return dp[i];
    }
    
    return dfs(0);
}

/**
 * DP + endtime sorting + Binary search TC: O(n log n) SC: O(n)
 */
function jobSchedulingDPBinarySearch(startTime, endTime, profit) {
    const n = startTime.length;
    const jobs = [];
    
    for (let i = 0; i < n; i++) {
        jobs.push([startTime[i], endTime[i], profit[i]]);
    }
    
    jobs.sort((a, b) => a[1] - b[1]);
    
    function binarySearch(idx) {
        let low = 0, high = idx - 1;
        let result = -1;
        
        while (low <= high) {
            const mid = low + Math.floor((high - low) / 2);
            
            if (jobs[mid][1] <= jobs[idx][0]) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }
    
    const dp = new Array(n);
    dp[0] = jobs[0][2];
    
    for (let i = 1; i < n; i++) {
        // Include current job
        let include = jobs[i][2];
        const prev = binarySearch(i);
        
        if (prev !== -1) {
            include += dp[prev];
        }
        
        // Exclude current job
        const exclude = dp[i - 1];
        
        dp[i] = Math.max(include, exclude);
    }
    
    return dp[n - 1];
}

// Test harness
const tests = [
    [[1,2,3,3], [3,4,5,6], [50,10,40,70], 120],
    [[1,2,3,4,6], [3,5,10,6,9], [20,20,100,70,60], 150],
    [[1,1,1], [2,3,4], [5,6,4], 6],
    [[1,2,3,4,5], [2,3,4,5,6], [1,2,3,4,5], 15],
    [[1], [2], [50], 50],
    [[6,15,7,11,1,3,16,2], [19,18,19,16,10,8,19,8], [2,9,1,19,5,7,3,19], 41],
    [[4,2,4,8,2], [5,5,5,10,8], [1,2,8,10,4], 18],
    [[1,2,2,3], [2,5,3,4], [3,4,1,2], 7],
    [[1,3,6,8], [2,5,7,9], [5,12,4,10], 31],
    [[1,2,3,4,5,6], [3,4,5,6,7,8], [5,6,5,4,11,2], 21]
];

console.log("Maximum Profit in Job Scheduling - Test Results:");
console.log("=".repeat(100));

let passed = 0;
tests.forEach(([startTime, endTime, profit, expected], index) => {
    // Test all approaches (skip recursive for large inputs)
    const result2 = jobSchedulingMemoization(startTime, endTime, profit);
    const result3 = jobSchedulingDPBinarySearch(startTime, endTime, profit);
    
    const pass = (result2 === expected && result3 === expected);
    
    // Debug: print all results if test fails
    if (!pass) {
        console.log(`Test ${String(index + 1).padStart(2)} FAIL | Start: ${JSON.stringify(startTime)}`);
        console.log(`  End: ${JSON.stringify(endTime)}, Profit: ${JSON.stringify(profit)}`);
        console.log(`  Memo: ${result2}, DP+BS: ${result3} | Expected: ${expected}`);
    } else {
        console.log(`Test ${String(index + 1).padStart(2)} | Start: ${JSON.stringify(startTime).padEnd(25)} | End: ${JSON.stringify(endTime).padEnd(25)} | Profit: ${JSON.stringify(profit).padEnd(25)} | Output: ${String(result2).padStart(3)} | Expected: ${String(expected).padStart(3)} | PASS`);
        passed++;
    }
});

console.log("=".repeat(100));
console.log(`Tests Passed: ${passed}/${tests.length}`);

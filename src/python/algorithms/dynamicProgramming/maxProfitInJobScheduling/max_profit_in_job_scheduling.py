"""
Maximum Profit in Job Scheduling

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
obtaining a profit of profit[i].

Return the maximum profit you can take such that there are no two jobs in the subset
with overlapping time range.
"""


def job_scheduling_recursive(start_time, end_time, profit):
    """
    Recursive with start times sorting TC: O(2^n) SC: O(n)
    """
    n = len(start_time)
    jobs = sorted(zip(start_time, end_time, profit), key=lambda x: x[0])
    
    def dfs(i):
        if i == n:
            return 0
        
        # Skip current job
        skip = dfs(i + 1)
        
        # Take current job and find next non-overlapping job
        next_idx = i + 1
        while next_idx < n and jobs[i][1] > jobs[next_idx][0]:
            next_idx += 1
        
        take = jobs[i][2] + dfs(next_idx)
        
        return max(skip, take)
    
    return dfs(0)


def job_scheduling_memoization(start_time, end_time, profit):
    """
    Top-down memoization TC: O(n^2) SC: O(n)
    """
    n = len(start_time)
    jobs = sorted(zip(start_time, end_time, profit), key=lambda x: x[0])
    dp = [-1] * n
    
    def dfs(i):
        if i == n:
            return 0
        
        if dp[i] != -1:
            return dp[i]
        
        # Skip current job
        skip = dfs(i + 1)
        
        # Take current job and find next non-overlapping job
        next_idx = i + 1
        while next_idx < n and jobs[i][1] > jobs[next_idx][0]:
            next_idx += 1
        
        take = jobs[i][2] + dfs(next_idx)
        
        dp[i] = max(skip, take)
        return dp[i]
    
    return dfs(0)


def job_scheduling_dp_binary_search(start_time, end_time, profit):
    """
    DP + endtime sorting + Binary search TC: O(n log n) SC: O(n)
    """
    n = len(start_time)
    jobs = sorted(zip(start_time, end_time, profit), key=lambda x: x[1])
    
    def binary_search(idx):
        low, high = 0, idx - 1
        result = -1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if jobs[mid][1] <= jobs[idx][0]:
                result = mid
                low = mid + 1
            else:
                high = mid - 1
        
        return result
    
    dp = [0] * n
    dp[0] = jobs[0][2]
    
    for i in range(1, n):
        # Include current job
        include = jobs[i][2]
        prev = binary_search(i)
        
        if prev != -1:
            include += dp[prev]
        
        # Exclude current job
        exclude = dp[i - 1]
        
        dp[i] = max(include, exclude)
    
    return dp[n - 1]


if __name__ == "__main__":
    # Test cases: [startTime, endTime, profit, expected]
    tests = [
        ([1,2,3,3], [3,4,5,6], [50,10,40,70], 120),
        ([1,2,3,4,6], [3,5,10,6,9], [20,20,100,70,60], 150),
        ([1,1,1], [2,3,4], [5,6,4], 6),
        ([1,2,3,4,5], [2,3,4,5,6], [1,2,3,4,5], 15),
        ([1], [2], [50], 50),
        ([6,15,7,11,1,3,16,2], [19,18,19,16,10,8,19,8], [2,9,1,19,5,7,3,19], 41),
        ([4,2,4,8,2], [5,5,5,10,8], [1,2,8,10,4], 18),
        ([1,2,2,3], [2,5,3,4], [3,4,1,2], 7),
        ([1,3,6,8], [2,5,7,9], [5,12,4,10], 31),
        ([1,2,3,4,5,6], [3,4,5,6,7,8], [5,6,5,4,11,2], 21)
    ]
    
    print("Maximum Profit in Job Scheduling - Test Results:")
    print("=" * 100)
    
    passed = 0
    for i, (start_time, end_time, profit, expected) in enumerate(tests, 1):
        # Test all approaches (skip recursive for large inputs)
        result1 = job_scheduling_recursive(start_time, end_time, profit) if len(start_time) < 10 else expected
        result2 = job_scheduling_memoization(start_time, end_time, profit)
        result3 = job_scheduling_dp_binary_search(start_time, end_time, profit)
        
        pass_test = (result2 == expected and result3 == expected)
        
        # Debug: print all results if test fails
        if not pass_test:
            print(f"Test {i:2d} FAIL | Start: {start_time}")
            print(f"  End: {end_time}, Profit: {profit}")
            print(f"  Recursive: {result1}, Memo: {result2}, DP+BS: {result3} | Expected: {expected}")
        else:
            print(f"Test {i:2d} | Start: {str(start_time):25s} | End: {str(end_time):25s} | Profit: {str(profit):25s} | Output: {result2:3d} | Expected: {expected:3d} | PASS")
            passed += 1
    
    print("=" * 100)
    print(f"Tests Passed: {passed}/{len(tests)}")

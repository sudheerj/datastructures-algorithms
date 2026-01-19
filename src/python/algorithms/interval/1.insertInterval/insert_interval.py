"""
Insert Interval

Given a set of non-overlapping intervals sorted by start time and a new interval,
insert the new interval into the intervals (merge if necessary).

Time Complexity: O(n)
Space Complexity: O(n)
"""


def insert(intervals, new_interval):
    """
    Insert and merge interval.
    TC: O(n), SC: O(n)
    """
    result = []
    i = 0
    n = len(intervals)
    
    # Add all intervals before new_interval
    while i < n and intervals[i][1] < new_interval[0]:
        result.append(intervals[i])
        i += 1
    
    # Merge overlapping intervals
    while i < n and intervals[i][0] <= new_interval[1]:
        new_interval[0] = min(new_interval[0], intervals[i][0])
        new_interval[1] = max(new_interval[1], intervals[i][1])
        i += 1
    
    result.append(new_interval)
    
    # Add remaining intervals
    while i < n:
        result.append(intervals[i])
        i += 1
    
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"intervals": [[1, 3], [6, 9]], "new_interval": [2, 5]},
        {"intervals": [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], "new_interval": [4, 8]},
    ]
    
    for test in test_cases:
        print(f"Intervals: {test['intervals']}")
        print(f"New interval: {test['new_interval']}")
        print(f"Result: {insert([i[:] for i in test['intervals']], test['new_interval'][:])}")
        print()

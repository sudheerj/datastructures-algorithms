"""
Non-overlapping Intervals

Given an array of intervals, return the minimum number of intervals
you need to remove to make the rest non-overlapping.

Time Complexity: O(n log n)
Space Complexity: O(1)
"""


def erase_overlap_intervals(intervals):
    """
    Greedy approach - sort by start time.
    TC: O(n log n), SC: O(1)
    """
    if not intervals:
        return 0
    
    # Sort by start time
    intervals.sort(key=lambda x: x[0])
    
    min_remove_count = 0
    prev_end = intervals[0][1]
    
    for i in range(1, len(intervals)):
        start = intervals[i][0]
        end = intervals[i][1]

        if start >= prev_end:
            # No overlap, keep this interval
            prev_end = end
        else:
            # Overlap, remove this interval
            min_remove_count += 1
            prev_end = min(prev_end, end)
    
    return min_remove_count


# Test cases
if __name__ == "__main__":
    test_cases = [
        [[1, 2], [2, 3], [3, 4], [1, 3]],  # 1
        [[1, 2], [1, 2], [1, 2]],           # 2
        [[1, 2], [2, 3]],                   # 0
    ]
    
    for intervals in test_cases:
        print(f"Intervals: {intervals}")
        print(f"Min removals: {erase_overlap_intervals([i[:] for i in intervals])}")
        print()

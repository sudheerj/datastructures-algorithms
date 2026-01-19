"""
Non-overlapping Intervals

Given an array of intervals, return the minimum number of intervals
you need to remove to make the rest non-overlapping.

Time Complexity: O(n log n)
Space Complexity: O(1)
"""


def erase_overlap_intervals(intervals):
    """
    Greedy approach - sort by end time.
    TC: O(n log n), SC: O(1)
    """
    if not intervals:
        return 0
    
    # Sort by end time
    intervals.sort(key=lambda x: x[1])
    
    count = 0
    prev_end = float('-inf')
    
    for start, end in intervals:
        if start >= prev_end:
            # No overlap, keep this interval
            prev_end = end
        else:
            # Overlap, remove this interval
            count += 1
    
    return count


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

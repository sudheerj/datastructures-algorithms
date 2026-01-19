"""
Merge Intervals

Given an array of intervals, merge all overlapping intervals.

Time Complexity: O(n log n)
Space Complexity: O(n)
"""


def merge(intervals):
    """
    Sort and merge.
    TC: O(n log n), SC: O(n)
    """
    if not intervals:
        return []
    
    # Sort by start time
    intervals.sort(key=lambda x: x[0])
    
    result = [intervals[0]]
    
    for current in intervals[1:]:
        last = result[-1]
        
        if current[0] <= last[1]:
            # Overlapping - merge
            last[1] = max(last[1], current[1])
        else:
            # Non-overlapping - add new interval
            result.append(current)
    
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        [[1, 3], [2, 6], [8, 10], [15, 18]],  # [[1, 6], [8, 10], [15, 18]]
        [[1, 4], [4, 5]],                       # [[1, 5]]
    ]
    
    for intervals in test_cases:
        print(f"Intervals: {intervals}")
        print(f"Merged: {merge([i[:] for i in intervals])}")
        print()

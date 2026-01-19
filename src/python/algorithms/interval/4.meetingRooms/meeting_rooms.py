"""
Meeting Rooms

Given an array of meeting time intervals consisting of start and end times,
determine if a person could attend all meetings.

Time Complexity: O(n log n)
Space Complexity: O(1)
"""


def can_attend_meetings(intervals):
    """
    Sort and check for overlaps.
    TC: O(n log n), SC: O(1)
    """
    if not intervals:
        return True
    
    intervals.sort(key=lambda x: x[0])
    
    for i in range(1, len(intervals)):
        if intervals[i][0] < intervals[i - 1][1]:
            return False
    
    return True


# Test cases
if __name__ == "__main__":
    test_cases = [
        [[0, 30], [5, 10], [15, 20]],  # False
        [[7, 10], [2, 4]],              # True
    ]
    
    for intervals in test_cases:
        print(f"Intervals: {intervals}")
        print(f"Can attend all: {can_attend_meetings([i[:] for i in intervals])}")
        print()

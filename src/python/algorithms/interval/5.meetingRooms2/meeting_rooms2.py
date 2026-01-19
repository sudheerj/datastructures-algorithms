"""
Meeting Rooms II

Given an array of meeting time intervals, find the minimum number of conference rooms required.

Time Complexity: O(n log n)
Space Complexity: O(n)
"""

import heapq


def min_meeting_rooms(intervals):
    """
    Using min heap.
    TC: O(n log n), SC: O(n)
    """
    if not intervals:
        return 0
    
    # Sort by start time
    intervals.sort(key=lambda x: x[0])
    
    # Min heap to track end times of ongoing meetings
    heap = []
    
    for start, end in intervals:
        if heap and heap[0] <= start:
            heapq.heappop(heap)
        
        heapq.heappush(heap, end)
    
    return len(heap)


def min_meeting_rooms_two_pointers(intervals):
    """
    Using two pointers with separate start and end arrays.
    TC: O(n log n), SC: O(n)
    """
    if not intervals:
        return 0
    
    starts = sorted([i[0] for i in intervals])
    ends = sorted([i[1] for i in intervals])
    
    rooms = 0
    end_ptr = 0
    
    for start in starts:
        if start < ends[end_ptr]:
            rooms += 1
        else:
            end_ptr += 1
    
    return rooms


# Test cases
if __name__ == "__main__":
    test_cases = [
        [[0, 30], [5, 10], [15, 20]],  # 2
        [[7, 10], [2, 4]],              # 1
    ]
    
    for intervals in test_cases:
        print(f"Intervals: {intervals}")
        print(f"Min rooms (heap): {min_meeting_rooms([i[:] for i in intervals])}")
        print(f"Min rooms (two pointers): {min_meeting_rooms_two_pointers([i[:] for i in intervals])}")
        print()

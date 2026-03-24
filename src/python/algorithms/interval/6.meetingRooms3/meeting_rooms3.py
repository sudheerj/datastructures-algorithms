"""
Meeting Rooms III

Given n rooms and a list of meetings, return the room that held the most meetings.
If there are ties, return the room with the lowest number.

Time Complexity: O(m * log n) where m is number of meetings
Space Complexity: O(n)
"""

import heapq

def most_booked(n, meetings):
    """
    Using two heaps - available rooms and busy rooms.
    TC:O(m * log n) + O(m * log m) => O(m * log m), SC: O(n)
    """
    # Sort meetings by start time
    meetings.sort()
    
    # min-heap of available rooms (room numbers)
    available = list(range(n))
    heapq.heapify(available)
    
    # min-heap of occupied rooms: (end_time, room)
    occupied = []
    
    # Count how many times each room is used
    count = [0] * n
    
    for start, end in meetings:
        duration = end - start
        
        # 1. Free up rooms that have finished
        while occupied and occupied[0][0] <= start:
            end_time, room = heapq.heappop(occupied)
            heapq.heappush(available, room)
        
        # 2. If a room is available → assign it
        if available:
            room = heapq.heappop(available)
            heapq.heappush(occupied, (end, room))
        
        else:
            # 3. No room available → delay meeting
            end_time, room = heapq.heappop(occupied)
            new_end = end_time + duration
            heapq.heappush(occupied, (new_end, room))
        
        count[room] += 1
    
    # Return room with maximum bookings (smallest index if tie)
    return count.index(max(count))

# Test cases
if __name__ == "__main__":
    test_cases = [
        {"n": 2, "meetings": [[0, 10], [1, 5], [2, 7], [3, 4]]},  # 0
        {"n": 3, "meetings": [[1, 20], [2, 10], [3, 5], [4, 9], [6, 8]]},  # 1
    ]
    
    for test in test_cases:
        print(f"Rooms: {test['n']}")
        print(f"Meetings: {test['meetings']}")
        print(f"Most booked room: {most_booked(test['n'], [m[:] for m in test['meetings']])}")
        print()

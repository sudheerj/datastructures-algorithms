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
    TC: O(m * log n), SC: O(n)
    """
    # Sort meetings by start time
    meetings.sort(key=lambda x: x[0])
    
    # Min heap of available rooms
    available = list(range(n))
    heapq.heapify(available)
    
    # Min heap of (end_time, room) for busy rooms
    busy = []
    
    # Count meetings per room
    room_count = [0] * n
    
    for start, end in meetings:
        # Free up rooms that have finished
        while busy and busy[0][0] <= start:
            _, room = heapq.heappop(busy)
            heapq.heappush(available, room)
        
        if available:
            # Use the smallest available room
            room = heapq.heappop(available)
            heapq.heappush(busy, (end, room))
        else:
            # Wait for the earliest room to be free
            end_time, room = heapq.heappop(busy)
            heapq.heappush(busy, (end_time + end - start, room))
        
        room_count[room] += 1
    
    # Return room with most meetings (smallest index if tie)
    max_meetings = max(room_count)
    for i in range(n):
        if room_count[i] == max_meetings:
            return i


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

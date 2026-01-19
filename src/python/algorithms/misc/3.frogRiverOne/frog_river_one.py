"""
Frog River One

A frog wants to cross a river by jumping on leaves.
Find the earliest time when the frog can jump to the other side.

Time Complexity: O(n)
Space Complexity: O(n) or O(X)
"""


def frog_river_one(destination_position, positions_list):
    """
    Using set to track covered positions.
    TC: O(n), SC: O(n)
    """
    positions = set()
    
    for i, pos in enumerate(positions_list):
        positions.add(pos)
        
        if len(positions) == destination_position:
            return i
    
    return -1


def frog_river_two(destination_position, positions_list):
    """
    Using boolean array to track covered positions.
    TC: O(n), SC: O(X)
    """
    seen = [False] * destination_position
    uncovered = destination_position
    
    for i, pos in enumerate(positions_list):
        if not seen[pos - 1]:
            seen[pos - 1] = True
            uncovered -= 1
            
            if uncovered == 0:
                return i
    
    return -1


# Test cases
if __name__ == "__main__":
    test_cases = [
        (5, [1, 3, 1, 4, 2, 3, 5, 4]),  # Output: 6
        (3, [1, 3, 1, 1]),              # Output: -1
        (1, [1]),                        # Output: 0
        (3, [3, 2, 1]),                  # Output: 2
        (2, [1, 1, 1, 2]),               # Output: 3
    ]
    
    for dest, positions in test_cases:
        result1 = frog_river_one(dest, positions)
        result2 = frog_river_two(dest, positions)
        print(f"Destination: {dest}, Positions: {positions}")
        print(f"  Using set: {result1}, Using array: {result2}")

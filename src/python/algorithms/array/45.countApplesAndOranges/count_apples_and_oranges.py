"""
Count Apples and Oranges

Count how many apples and oranges land on Sam's house.
Apples fall from position 'a' and oranges fall from position 'b'.
Sam's house is between 's' and 't'.

Time Complexity: O(n + m) where n is apples, m is oranges
Space Complexity: O(1)
"""


def count_apples_and_oranges(s, t, a, b, apples, oranges):
    """
    Count fruits that land within the house range.
    TC: O(n + m), SC: O(1)
    """
    apple_count = sum(1 for pos in apples if s <= pos + a <= t)
    orange_count = sum(1 for pos in oranges if s <= pos + b <= t)
    
    print(f"{apple_count} {orange_count}")
    return (apple_count, orange_count)


def count_apples_and_oranges_loop(s, t, a, b, apples, oranges):
    """
    Using explicit loop.
    TC: O(n + m), SC: O(1)
    """
    apple_count = 0
    for pos in apples:
        landing_pos = pos + a
        if s <= landing_pos <= t:
            apple_count += 1
    
    orange_count = 0
    for pos in oranges:
        landing_pos = pos + b
        if s <= landing_pos <= t:
            orange_count += 1
    
    print(f"{apple_count} {orange_count}")
    return (apple_count, orange_count)


# Test cases
if __name__ == "__main__":
    # s=house start, t=house end, a=apple tree, b=orange tree
    print("Test 1:")
    count_apples_and_oranges(7, 11, 5, 15, [-2, 2, 1], [5, -6])  # Output: 1 1
    
    print("Test 2:")
    count_apples_and_oranges(10, 20, 5, 25, [10, -5, 0, 15], [-10, 5, 20])  # Output: 2 1
    
    print("Test 3:")
    count_apples_and_oranges(5, 15, 3, 17, [2, 3, -4], [3, -2, -1])  # Output: 2 1
    
    print("Test 4:")
    count_apples_and_oranges(1, 5, 0, 6, [1, 2, 3], [-1, -2, -3])  # Output: 3 3

"""
Max Non-overlapping Segments

Find the maximum number of non-overlapping segments.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_non_overlapping_segments(a, b):
    """
    Greedy approach - sort by end time and count non-overlapping.
    TC: O(n), SC: O(1) - assuming already sorted by end
    """
    n = len(a)
    if n == 0:
        return 0
    
    count = 1
    prev_end = b[0]
    
    for i in range(1, n):
        if a[i] > prev_end:
            count += 1
            prev_end = b[i]
    
    return count


# Test cases
if __name__ == "__main__":
    # Example: segments = [(1,5), (3,6), (7,8)]
    a = [1, 3, 7, 9, 9]
    b = [5, 6, 8, 9, 10]
    print(f"A (starts): {a}")
    print(f"B (ends): {b}")
    print(f"Max non-overlapping segments: {max_non_overlapping_segments(a, b)}")  # 3

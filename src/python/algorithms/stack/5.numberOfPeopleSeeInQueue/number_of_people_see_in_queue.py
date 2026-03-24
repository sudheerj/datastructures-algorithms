"""
Number of People Seen in Queue

Given an array of distinct heights, return an array where each element is
the number of people that person can see to their right in the queue.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def can_see_persons_count(heights):
    """
    Monotonic stack approach, processing right to left.
    TC: O(n), SC: O(n)
    """
    length = len(heights)
    visibility_count = [0] * length
    stack = []

    for i in range(length - 1, -1, -1):
        # Pop shorter people from stack as they're blocked by current person
        while stack and heights[i] > stack[-1]:
            stack.pop()
            visibility_count[i] += 1

        # If stack is not empty, current person can see one more person (first taller one)
        if stack:
            visibility_count[i] += 1

        stack.append(heights[i])

    return visibility_count


# Test cases
if __name__ == "__main__":
    test_cases = [
        ([10, 6, 8, 5, 11, 9], [3, 1, 2, 1, 1, 0]),
        ([6, 5, 4, 3, 2, 1], [1, 1, 1, 1, 1, 0]),
        ([1, 2, 3, 4, 5, 6], [1, 1, 1, 1, 1, 0]),
    ]

    for heights, expected in test_cases:
        result = can_see_persons_count(heights)
        print(f"Heights: {heights} | Output: {result} | Expected: {expected}")

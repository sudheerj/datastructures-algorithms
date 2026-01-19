"""
Daily Temperatures

Given an array of integers temperatures, return an array answer such that
answer[i] is the number of days you have to wait until a warmer temperature.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def daily_temperatures(temperatures):
    """
    Using monotonic decreasing stack.
    TC: O(n), SC: O(n)
    """
    n = len(temperatures)
    result = [0] * n
    stack = []  # Stack of indices
    
    for i in range(n):
        while stack and temperatures[i] > temperatures[stack[-1]]:
            prev_index = stack.pop()
            result[prev_index] = i - prev_index
        stack.append(i)
    
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        [73, 74, 75, 71, 69, 72, 76, 73],  # [1, 1, 4, 2, 1, 1, 0, 0]
        [30, 40, 50, 60],                   # [1, 1, 1, 0]
        [30, 60, 90],                       # [1, 1, 0]
    ]
    
    for temps in test_cases:
        print(f"Temperatures: {temps}")
        print(f"Days to wait: {daily_temperatures(temps)}")
        print()

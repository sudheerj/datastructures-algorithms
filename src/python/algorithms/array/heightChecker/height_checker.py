# Frequency counting  TC: O(n)  SC: O(1)

def height_checker(heights: list[int]) -> int:
    count = [0] * 101

    for h in heights:
        count[h] += 1

    mismatches = 0
    current_height = 1
    for h in heights:
        while count[current_height] == 0:
            current_height += 1
        if h != current_height:
            mismatches += 1
        count[current_height] -= 1

    return mismatches


if __name__ == "__main__":
    test_cases = [
        ([1, 1, 4, 2, 1, 3], 3),   # 3 students out of position
        ([5, 1, 2, 3, 4],    5),   # all students out of position
        ([1, 2, 3, 4, 5],    0),   # already sorted
        ([2, 1, 2, 1, 1, 2, 2, 1], 4),  # mixed mismatches
        ([1],                0),   # single student
        ([3, 3, 3, 3],       0),   # all same height
    ]

    for heights, expected in test_cases:
        result = height_checker(heights)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

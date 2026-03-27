def trapping_rain_water(heights):

    if not heights: 
        return 0
    
    left, right = 0, len(heights)-1
    leftMax = heights[0]
    rightMax = heights[right]
    res = 0

    while left < right:
        if leftMax <= rightMax:
            left += 1
            leftMax = max(leftMax, heights[left])
            res += leftMax - heights[left]
        else:
            right -= 1
            rightMax = max(rightMax, heights[right])
            res += rightMax - heights[right]

    return res


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"heights": [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], "expected": 6},
        {"heights": [4, 2, 0, 3, 2, 5], "expected": 9},
        {"heights": [1, 1], "expected": 0},
        {"heights": [], "expected": 0},
        {"heights": [3, 0, 0, 2, 0, 4], "expected": 10},
    ]

    for test in test_cases:
        result = trapping_rain_water(test["heights"])
        print(f"Heights: {test['heights']}")
        print(f"Trapped water: {result} (expected: {test['expected']})")
        print()



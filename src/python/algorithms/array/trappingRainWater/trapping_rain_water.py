"""
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
"""

def trapping_rain_water(heights):
    if not heights:
        return 0
    left, right = 0, len(heights) - 1
    left_max, right_max = heights[0], heights[-1]
    res = 0
    while left < right:
        if left_max <= right_max:
            left += 1
            left_max = max(left_max, heights[left])
            res += left_max - heights[left]
        else:
            right -= 1
            right_max = max(right_max, heights[right])
            res += right_max - heights[right]
    return res

def trapping_rain_water2(heights):
    n = len(heights)
    if n == 0:
        return 0
    left_max = [0] * n
    right_max = [0] * n
    for i in range(1, n):
        left_max[i] = max(left_max[i-1], heights[i-1])
    for j in range(n-2, -1, -1):
        right_max[j] = max(right_max[j+1], heights[j+1])
    water = 0
    for i in range(n):
        water += max(0, min(left_max[i], right_max[i]) - heights[i])
    return water

if __name__ == "__main__":
    # Test 1: General case
    print(trapping_rain_water([0,1,0,2,1,0,1,3,2,1,2,1])) # 6
    print(trapping_rain_water2([0,1,0,2,1,0,1,3,2,1,2,1])) # 6

    # Test 2: V-shaped
    print(trapping_rain_water([4,2,0,3,2,5])) # 9
    print(trapping_rain_water2([4,2,0,3,2,5])) # 9

    # Test 3: Flat - no water
    print(trapping_rain_water([1,1])) # 0
    print(trapping_rain_water2([1,1])) # 0

    # Test 4: Empty array
    print(trapping_rain_water([])) # 0
    print(trapping_rain_water2([])) # 0

    # Test 5: Deep valley
    print(trapping_rain_water([3,0,0,2,0,4])) # 10
    print(trapping_rain_water2([3,0,0,2,0,4])) # 10

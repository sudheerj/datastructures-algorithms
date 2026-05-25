# Approach 1: Two Pointers — O(n) time, O(1) space
def trapping_rain_water1(height):
    if not height:
        return 0
    left, right = 0, len(height) - 1
    left_max, right_max = height[0], height[right]
    res = 0
    while left < right:
        if left_max <= right_max:
            left += 1
            left_max = max(left_max, height[left])
            res += left_max - height[left]
        else:
            right -= 1
            right_max = max(right_max, height[right])
            res += right_max - height[right]
    return res


# Approach 2: Prefix/Suffix Arrays — O(n) time, O(n) space
def trapping_rain_water2(height):
    n = len(height)
    if n == 0:
        return 0
    left_max = [0] * n
    right_max = [0] * n
    left_max[0] = height[0]
    for i in range(1, n):
        left_max[i] = max(left_max[i - 1], height[i])
    right_max[n - 1] = height[n - 1]
    for j in range(n - 2, -1, -1):
        right_max[j] = max(right_max[j + 1], height[j])
    water = 0
    for i in range(n):
        water += min(left_max[i], right_max[i]) - height[i]
    return water


# Approach 3: Brute Force — O(n²) time, O(1) space
def trapping_rain_water3(height):
    n = len(height)
    if n == 0:
        return 0
    water = 0
    for i in range(n):
        left_max = max(height[:i + 1])
        right_max = max(height[i:])
        water += min(left_max, right_max) - height[i]
    return water


if __name__ == "__main__":
    t1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    t2 = [4, 2, 0, 3, 2, 5]
    t3 = [1, 1]
    t4 = []
    t5 = [3, 0, 0, 2, 0, 4]

    # Approach 1: Two Pointers
    r1 = trapping_rain_water1(t1)
    print(f"Test 1 (two-ptr): {'[PASS]' if r1 == 6 else '[FAIL]'} result={r1} expected=6")
    r2 = trapping_rain_water1(t2)
    print(f"Test 2 (two-ptr): {'[PASS]' if r2 == 9 else '[FAIL]'} result={r2} expected=9")
    r3 = trapping_rain_water1(t3)
    print(f"Test 3 (two-ptr): {'[PASS]' if r3 == 0 else '[FAIL]'} result={r3} expected=0")
    r4 = trapping_rain_water1(t4)
    print(f"Test 4 (two-ptr): {'[PASS]' if r4 == 0 else '[FAIL]'} result={r4} expected=0")
    r5 = trapping_rain_water1(t5)
    print(f"Test 5 (two-ptr): {'[PASS]' if r5 == 10 else '[FAIL]'} result={r5} expected=10")

    # Approach 2: Prefix/Suffix Arrays
    r6 = trapping_rain_water2(t1)
    print(f"Test 1 (prefix): {'[PASS]' if r6 == 6 else '[FAIL]'} result={r6} expected=6")
    r7 = trapping_rain_water2(t2)
    print(f"Test 2 (prefix): {'[PASS]' if r7 == 9 else '[FAIL]'} result={r7} expected=9")
    r8 = trapping_rain_water2(t3)
    print(f"Test 3 (prefix): {'[PASS]' if r8 == 0 else '[FAIL]'} result={r8} expected=0")
    r9 = trapping_rain_water2(t4)
    print(f"Test 4 (prefix): {'[PASS]' if r9 == 0 else '[FAIL]'} result={r9} expected=0")
    r10 = trapping_rain_water2(t5)
    print(f"Test 5 (prefix): {'[PASS]' if r10 == 10 else '[FAIL]'} result={r10} expected=10")

    # Approach 3: Brute Force
    r11 = trapping_rain_water3(t1)
    print(f"Test 1 (brute): {'[PASS]' if r11 == 6 else '[FAIL]'} result={r11} expected=6")
    r12 = trapping_rain_water3(t2)
    print(f"Test 2 (brute): {'[PASS]' if r12 == 9 else '[FAIL]'} result={r12} expected=9")
    r13 = trapping_rain_water3(t3)
    print(f"Test 3 (brute): {'[PASS]' if r13 == 0 else '[FAIL]'} result={r13} expected=0")
    r14 = trapping_rain_water3(t4)
    print(f"Test 4 (brute): {'[PASS]' if r14 == 0 else '[FAIL]'} result={r14} expected=0")
    r15 = trapping_rain_water3(t5)
    print(f"Test 5 (brute): {'[PASS]' if r15 == 10 else '[FAIL]'} result={r15} expected=10")

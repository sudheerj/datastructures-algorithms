def sqrt1(num):
    if num < 2:
        return num
    left, right = 1, num // 2
    result = 0
    while left <= right:
        mid = left + (right - left) // 2
        if mid <= num // mid:
            result = mid
            left = mid + 1
        else:
            right = mid - 1
    return result

def sqrt2(num):
    if num < 2:
        return num
    result = 0
    for i in range(1, num // 2 + 1):
        if i * i > num:
            return result
        result = i
    return result

if __name__ == "__main__":
    test_cases = [0, 1, 4, 8, 9, 15, 16, 25, 26, 100, 101]
    print("Testing sqrt1:")
    for n in test_cases:
        print(f"sqrt1({n}) = {sqrt1(n)}")
    print("\nTesting sqrt2:")
    for n in test_cases:
        print(f"sqrt2({n}) = {sqrt2(n)}")

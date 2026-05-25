# Approach 1: Prefix/postfix optimized — O(n) time, O(1) space (output excluded)
def product_except_self1(nums):
    result = [1] * len(nums)
    prefix = 1
    for i in range(len(nums)):
        result[i] = prefix
        prefix *= nums[i]
    postfix = 1
    for i in range(len(nums) - 1, -1, -1):
        result[i] *= postfix
        postfix *= nums[i]
    return result


# Approach 2: Prefix/postfix arrays — O(n) time, O(n) space
def product_except_self2(nums):
    n = len(nums)
    prefix_arr = [1] * n
    postfix_arr = [1] * n
    for i in range(1, n):
        prefix_arr[i] = nums[i - 1] * prefix_arr[i - 1]
    for i in range(n - 2, -1, -1):
        postfix_arr[i] = nums[i + 1] * postfix_arr[i + 1]
    return [prefix_arr[i] * postfix_arr[i] for i in range(n)]


# Approach 3: Division — O(n) time, O(1) space
def product_except_self3(nums):
    product, zero_count = 1, 0
    for num in nums:
        if num != 0:
            product *= num
        else:
            zero_count += 1
    if zero_count > 1:
        return [0] * len(nums)
    result = []
    for num in nums:
        if zero_count > 0:
            result.append(product if num == 0 else 0)
        else:
            result.append(product // num)
    return result


# Approach 4: Brute force — O(n²) time, O(1) space
def product_except_self4(nums):
    result = []
    for i in range(len(nums)):
        product = 1
        for j in range(len(nums)):
            if i == j:
                continue
            product *= nums[j]
        result.append(product)
    return result


if __name__ == "__main__":
    t1, t2, t3, t4, t5 = [1,2,3,4], [-1,1,0,-3,3], [1,2,3,4,5], [0,0], [2,3,4]
    e1, e2, e3, e4, e5 = [24,12,8,6], [0,0,9,0,0], [120,60,40,30,24], [0,0], [12,8,6]

    # Approach 1: prefix/postfix optimized
    r1 = product_except_self1(t1)
    print(f"Test 1 (opt): {'[PASS]' if r1 == e1 else '[FAIL]'} result={r1} expected={e1}")
    r2 = product_except_self1(t2)
    print(f"Test 2 (opt): {'[PASS]' if r2 == e2 else '[FAIL]'} result={r2} expected={e2}")
    r3 = product_except_self1(t3)
    print(f"Test 3 (opt): {'[PASS]' if r3 == e3 else '[FAIL]'} result={r3} expected={e3}")
    r4 = product_except_self1(t4)
    print(f"Test 4 (opt): {'[PASS]' if r4 == e4 else '[FAIL]'} result={r4} expected={e4}")
    r5 = product_except_self1(t5)
    print(f"Test 5 (opt): {'[PASS]' if r5 == e5 else '[FAIL]'} result={r5} expected={e5}")

    # Approach 2: prefix/postfix arrays
    r6 = product_except_self2(t1)
    print(f"Test 1 (arr): {'[PASS]' if r6 == e1 else '[FAIL]'} result={r6} expected={e1}")
    r7 = product_except_self2(t2)
    print(f"Test 2 (arr): {'[PASS]' if r7 == e2 else '[FAIL]'} result={r7} expected={e2}")
    r8 = product_except_self2(t3)
    print(f"Test 3 (arr): {'[PASS]' if r8 == e3 else '[FAIL]'} result={r8} expected={e3}")
    r9 = product_except_self2(t4)
    print(f"Test 4 (arr): {'[PASS]' if r9 == e4 else '[FAIL]'} result={r9} expected={e4}")
    r10 = product_except_self2(t5)
    print(f"Test 5 (arr): {'[PASS]' if r10 == e5 else '[FAIL]'} result={r10} expected={e5}")

    # Approach 3: division
    r11 = product_except_self3(t1)
    print(f"Test 1 (div): {'[PASS]' if r11 == e1 else '[FAIL]'} result={r11} expected={e1}")
    r12 = product_except_self3(t2)
    print(f"Test 2 (div): {'[PASS]' if r12 == e2 else '[FAIL]'} result={r12} expected={e2}")
    r13 = product_except_self3(t3)
    print(f"Test 3 (div): {'[PASS]' if r13 == e3 else '[FAIL]'} result={r13} expected={e3}")
    r14 = product_except_self3(t4)
    print(f"Test 4 (div): {'[PASS]' if r14 == e4 else '[FAIL]'} result={r14} expected={e4}")
    r15 = product_except_self3(t5)
    print(f"Test 5 (div): {'[PASS]' if r15 == e5 else '[FAIL]'} result={r15} expected={e5}")

    # Approach 4: brute force
    r16 = product_except_self4(t1)
    print(f"Test 1 (brute): {'[PASS]' if r16 == e1 else '[FAIL]'} result={r16} expected={e1}")
    r17 = product_except_self4(t2)
    print(f"Test 2 (brute): {'[PASS]' if r17 == e2 else '[FAIL]'} result={r17} expected={e2}")
    r18 = product_except_self4(t3)
    print(f"Test 3 (brute): {'[PASS]' if r18 == e3 else '[FAIL]'} result={r18} expected={e3}")
    r19 = product_except_self4(t4)
    print(f"Test 4 (brute): {'[PASS]' if r19 == e4 else '[FAIL]'} result={r19} expected={e4}")
    r20 = product_except_self4(t5)
    print(f"Test 5 (brute): {'[PASS]' if r20 == e5 else '[FAIL]'} result={r20} expected={e5}")

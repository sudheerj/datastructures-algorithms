# Approach 1: Sum difference — O(n) time, O(1) space
def missing_number1(nums):
    missing = len(nums)
    for i in range(len(nums)):
        missing += i - nums[i]
    return missing


# Approach 2: XOR — O(n) time, O(1) space
def missing_number2(nums):
    missing = len(nums)
    for i in range(len(nums)):
        missing ^= i ^ nums[i]
    return missing


# Approach 3: HashSet — O(n) time, O(n) space
def missing_number3(nums):
    num_set = set(nums)
    for i in range(len(nums) + 1):
        if i not in num_set:
            return i
    return -1


if __name__ == "__main__":
    nums1 = [3, 1, 0]
    nums2 = [5, 9, 7, 1, 2, 4, 0, 6, 8, 3]
    nums3 = [0]
    nums4 = [1]
    nums5 = [0, 1, 2, 3, 4, 5, 6, 7, 9]

    # Approach 1: sum difference
    r1 = missing_number1(nums1)
    print(f"Test 1a (sum) - [3,1,0]: {'[PASS]' if r1 == 2 else '[FAIL]'} result={r1} expected=2")
    r2 = missing_number1(nums2)
    print(f"Test 2a (sum) - 10-elem missing 10: {'[PASS]' if r2 == 10 else '[FAIL]'} result={r2} expected=10")
    r3 = missing_number1(nums3)
    print(f"Test 3a (sum) - [0]: {'[PASS]' if r3 == 1 else '[FAIL]'} result={r3} expected=1")
    r4 = missing_number1(nums4)
    print(f"Test 4a (sum) - [1]: {'[PASS]' if r4 == 0 else '[FAIL]'} result={r4} expected=0")
    r5 = missing_number1(nums5)
    print(f"Test 5a (sum) - missing 8: {'[PASS]' if r5 == 8 else '[FAIL]'} result={r5} expected=8")

    # Approach 2: XOR
    r6 = missing_number2(nums1)
    print(f"Test 1b (xor) - [3,1,0]: {'[PASS]' if r6 == 2 else '[FAIL]'} result={r6} expected=2")
    r7 = missing_number2(nums2)
    print(f"Test 2b (xor) - 10-elem missing 10: {'[PASS]' if r7 == 10 else '[FAIL]'} result={r7} expected=10")
    r8 = missing_number2(nums3)
    print(f"Test 3b (xor) - [0]: {'[PASS]' if r8 == 1 else '[FAIL]'} result={r8} expected=1")
    r9 = missing_number2(nums4)
    print(f"Test 4b (xor) - [1]: {'[PASS]' if r9 == 0 else '[FAIL]'} result={r9} expected=0")
    r10 = missing_number2(nums5)
    print(f"Test 5b (xor) - missing 8: {'[PASS]' if r10 == 8 else '[FAIL]'} result={r10} expected=8")

    # Approach 3: HashSet
    r11 = missing_number3(nums1)
    print(f"Test 1c (set) - [3,1,0]: {'[PASS]' if r11 == 2 else '[FAIL]'} result={r11} expected=2")
    r12 = missing_number3(nums2)
    print(f"Test 2c (set) - 10-elem missing 10: {'[PASS]' if r12 == 10 else '[FAIL]'} result={r12} expected=10")
    r13 = missing_number3(nums3)
    print(f"Test 3c (set) - [0]: {'[PASS]' if r13 == 1 else '[FAIL]'} result={r13} expected=1")
    r14 = missing_number3(nums4)
    print(f"Test 4c (set) - [1]: {'[PASS]' if r14 == 0 else '[FAIL]'} result={r14} expected=0")
    r15 = missing_number3(nums5)
    print(f"Test 5c (set) - missing 8: {'[PASS]' if r15 == 8 else '[FAIL]'} result={r15} expected=8")

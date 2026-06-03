def circularArrayLoop(nums):
    n = len(nums)
    def next_index(current):
        return (current + nums[current]) % n

    for i in range(n):
        if nums[i] == 0:
            continue
        direction = nums[i] > 0
        slow, fast = i, i
        while True:
            # Move slow pointer
            next_slow = next_index(slow)
            # Move fast pointer
            next_fast = next_index(fast)
            if nums[fast] * nums[next_fast] <= 0 or nums[slow] * nums[next_slow] <= 0:
                break
            fast2 = next_index(next_fast)
            if nums[fast] * nums[fast2] <= 0:
                break
            slow, fast = next_slow, fast2
            if slow == fast:
                if slow == next_index(slow):
                    break
                return True
        # Mark all nodes in this path as 0
        j = i
        val = nums[i]
        while nums[j] * val > 0:
            nxt = next_index(j)
            nums[j] = 0
            j = nxt
    return False

if __name__ == "__main__":
    tests = [
        ([2,-1,1,2,2], True),
        ([-1,2], False),
        ([-2,1,-1,-2,-2], False),
        ([1,1,2], True),
        ([1,2,3,4,5,6,7,8,9,10], True),
        ([1,-1,5,1,4], False),
        ([1,1,1,1,1,1,1,1,1,1], True),
        ([0,1,2], False),
    ]
    for idx, (nums, expected) in enumerate(tests, 1):
        result = circularArrayLoop(nums[:])
        print(f"Test {idx}: Output={result}, Expected={expected} [{'PASS' if result==expected else 'FAIL'}]")

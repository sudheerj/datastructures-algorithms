import heapq

def findScore(nums):
    n = len(nums)
    heap = [(nums[i], i) for i in range(n)]
    heapq.heapify(heap)

    marked = [False] * n
    score = 0

    while heap:
        value, index = heapq.heappop(heap)

        if marked[index]:
            continue

        score += value

        marked[index] = True

        if index > 0:
            marked[index-1] = True
        if index < n-1:
            marked[index+1] = True

    return score

def run_tests():
    tests = [
        # (nums, expected)
        ([2, 1, 3, 4, 5, 2], 7),
        ([2, 3, 5, 1, 3, 2], 5),
        ([1], 1),
        ([5, 4, 3, 2, 1], 9),
        ([1, 2, 3, 4, 5], 9),
        ([2, 2, 2], 4),
        ([7, 7, 7, 7], 14),
        ([10, 1, 10, 1, 10], 2),
    ]

    for i, (nums, expected) in enumerate(tests, 1):
        result = findScore(nums[:])
        status = "PASS" if result == expected else "FAIL"

        print(f"Test {i}: {status}")
        print(f"  nums = {nums}")
        print(f"  Expected = {expected}")
        print(f"  Got      = {result}\n")


if __name__ == "__main__":
    run_tests()

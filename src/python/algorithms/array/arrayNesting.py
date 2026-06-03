def arrayNesting1(nums):
    maxLength = 0
    for i in range(len(nums)):
        if nums[i] == -1:
            continue
        count = 0
        curr = i
        while nums[curr] != -1:
            next_idx = nums[curr]
            nums[curr] = -1
            curr = next_idx
            count += 1
        maxLength = max(maxLength, count)
    return maxLength

def arrayNesting2(nums):
    maxLength = 0
    visited = [False] * len(nums)
    for i in range(len(nums)):
        if visited[i]:
            continue
        count = 0
        curr = i
        while not visited[curr]:
            next_idx = nums[curr]
            visited[curr] = True
            curr = next_idx
            count += 1
        maxLength = max(maxLength, count)
    return maxLength

def deep_copy(arr):
    return arr[:]

def run_tests():
    tests = [
        [5,4,0,3,1,6,2],
        [0,1,2],
        [1,0,3,4,2],
        [2,0,1],
        [1,2,3,4,0],
        [0],
        [1,2,0],
    ]
    expected = [4,1,3,3,5,1,3]
    print("Testing arrayNesting1 (in-place):")
    for i, test in enumerate(tests):
        result = arrayNesting1(deep_copy(test))
        print(f"Test {i+1}: Output={result}, Expected={expected[i]} [{'PASS' if result == expected[i] else 'FAIL'}]")
    print("\nTesting arrayNesting2 (visited array):")
    for i, test in enumerate(tests):
        result = arrayNesting2(deep_copy(test))
        print(f"Test {i+1}: Output={result}, Expected={expected[i]} [{'PASS' if result == expected[i] else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()

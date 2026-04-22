def permutations(nums):
    result = []
    def backtrack(current):
        if len(current) == len(nums):
            result.append(current[:])
            return
        for num in nums:
            if num in current:
                continue
            current.append(num)
            backtrack(current)
            current.pop()
    backtrack([])
    return result

if __name__ == "__main__":
    # Example 1: Standard case
    print("Input: [1, 2, 3]")
    print("Output:", permutations([1, 2, 3]))

    # Example 2: Two elements
    print("Input: [0, 1]")
    print("Output:", permutations([0, 1]))

    # Example 3: Single element
    print("Input: [1]")
    print("Output:", permutations([1]))

    # Example 4: Empty array
    print("Input: []")
    print("Output:", permutations([]))

    # Example 5: Negative numbers
    print("Input: [-1, 2]")
    print("Output:", permutations([-1, 2]))

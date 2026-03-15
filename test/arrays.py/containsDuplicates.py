def contains_duplicates(nums):
    seen = set()

    for num in nums:
        if num in seen:
            return True
        seen.add(num)

    return False

def contains_duplicates1(nums):
    seen = {}

    for num in nums:
        if num in seen:
            return True    
        seen[num] = True

    return False

def contains_duplicates2(nums):

    return len(set(nums)) != len(nums)

def contains_duplicates3(nums):
    nums.sort()

    for i in range(1, len(nums)):
        if nums[i] == nums[i-1]:
            return True
    return False

def contains_duplicates4(nums):

    for i in range(len(nums)-1):
        for j in range(i+1, len(nums)):
            if nums[i] == nums[j]:
                return True

    return False

# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 1],      # True
        [1, 2, 3, 4],      # False
        [1, 1, 1, 3, 3, 4, 3, 2, 4, 2],  # True
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Contains duplicate: {contains_duplicates(nums)}")
        print(f"Contains duplicate: {contains_duplicates1(nums)}")
        print(f"Contains duplicate: {contains_duplicates2(nums)}")
        print(f"Contains duplicate: {contains_duplicates3(nums)}")
        print(f"Contains duplicate: {contains_duplicates4(nums)}")
        print()




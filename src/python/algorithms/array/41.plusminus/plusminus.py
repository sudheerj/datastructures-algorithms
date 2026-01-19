"""
Plus Minus

Given an array of integers, calculate the ratios of positive, negative, and zero elements.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def plus_minus(arr):
    """
    Count ratios of positive, negative, and zero elements.
    TC: O(n), SC: O(1)
    """
    length = len(arr)
    
    positive_count = 0
    negative_count = 0
    zero_count = 0
    
    for num in arr:
        if num > 0:
            positive_count += 1
        elif num < 0:
            negative_count += 1
        else:
            zero_count += 1
    
    positive_ratio = positive_count / length
    negative_ratio = negative_count / length
    zero_ratio = zero_count / length
    
    print(f"{positive_ratio:.5f}")
    print(f"{negative_ratio:.5f}")
    print(f"{zero_ratio:.5f}")
    
    return (positive_ratio, negative_ratio, zero_ratio)


# Test cases
if __name__ == "__main__":
    numbers1 = [1, -2, 0, 3, -4, 5, 0]
    print("Array:", numbers1)
    plus_minus(numbers1)
    print()
    
    numbers2 = [-1, -2, -3, 0, 0, 0]
    print("Array:", numbers2)
    plus_minus(numbers2)
    print()
    
    numbers3 = [1, 2, 3, 4, 5]
    print("Array:", numbers3)
    plus_minus(numbers3)

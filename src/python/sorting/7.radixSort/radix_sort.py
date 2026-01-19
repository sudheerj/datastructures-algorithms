"""
Radix Sort Algorithm

Time Complexity: O(nk) where k is the number of digits
Space Complexity: O(n + k)

Radix sort is a non-comparative sorting algorithm that sorts integers
by processing individual digits from least significant to most significant.
"""


def get_digit(num, place):
    """
    Gets the digit at the specified place value.
    
    Args:
        num: The number
        place: The place value (0 for ones, 1 for tens, etc.)
    
    Returns:
        The digit at the specified place
    """
    return abs(num) // (10 ** place) % 10


def digit_count(num):
    """
    Counts the number of digits in a number.
    
    Args:
        num: The number
    
    Returns:
        Number of digits
    """
    if num == 0:
        return 1
    count = 0
    while num > 0:
        count += 1
        num //= 10
    return count


def most_digits(nums):
    """
    Finds the maximum number of digits in the array.
    
    Args:
        nums: List of numbers
    
    Returns:
        Maximum number of digits
    """
    max_digits = 0
    for num in nums:
        max_digits = max(max_digits, digit_count(abs(num)))
    return max_digits


def radix_sort(nums):
    """
    Sorts an array of non-negative integers using radix sort.
    
    Args:
        nums: List of non-negative integers
    
    Returns:
        Sorted array
    """
    max_digit_count = most_digits(nums)
    
    for k in range(max_digit_count):
        # Create buckets for each digit (0-9)
        digit_buckets = [[] for _ in range(10)]
        
        for num in nums:
            digit = get_digit(num, k)
            digit_buckets[digit].append(num)
        
        # Flatten the buckets back into nums
        nums = []
        for bucket in digit_buckets:
            nums.extend(bucket)
    
    return nums


# Usage example
if __name__ == "__main__":
    arr = [170, 45, 75, 90, 802, 24, 2, 66]
    print(f"Original: {arr}")
    sorted_arr = radix_sort(arr)
    print(f"Sorted: {sorted_arr}")

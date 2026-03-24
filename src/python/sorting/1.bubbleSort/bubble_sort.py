"""
Bubble Sort Algorithm

Time Complexity: O(n^2)
Space Complexity: O(1)

Bubble sort repeatedly steps through the list, compares adjacent elements,
and swaps them if they are in the wrong order.
"""


def bubble_sort(nums):
    """
    Sorts an array using bubble sort algorithm.
    
    Args:
        array: List of comparable elements
    
    Returns:
        Sorted array
    """
    n = len(nums)
    
    for i in range(n - 1):
        swapped = False
        
        for j in range(n - i - 1):
            if nums[j] > nums[j + 1]:
                swap(nums, j, j + 1)
                swapped = True
        
        # Early exit if no swaps were made (list is sorted)
        if not swapped:
            break
    
    return nums


def swap(nums, first_index, second_index):
    """Swaps two elements in an array."""
    nums[first_index], nums[second_index] = nums[second_index], nums[first_index]


# Usage example
if __name__ == "__main__":
    test_nums = [40, 50, 20, 0, -10, 30, 10]
    print(f"Original: {test_nums}")
    print(f"Sorted: {bubble_sort(test_nums)}")

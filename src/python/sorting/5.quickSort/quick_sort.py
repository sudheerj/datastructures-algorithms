"""
Quick Sort Algorithm

Time Complexity: O(n log n) average, O(n^2) worst
Space Complexity: O(log n)

Quick sort is a divide-and-conquer algorithm that selects a pivot element
and partitions the array around the pivot, then recursively sorts the partitions.
"""


def swap(array, first_index, second_index):
    """Swaps two elements in an array."""
    array[first_index], array[second_index] = array[second_index], array[first_index]


def pivot(array, pivot_index=0, end_index=None):
    """
    Partitions the array around a pivot element.
    
    Args:
        array: List of comparable elements
        pivot_index: Starting index (default 0)
        end_index: Ending index (default array length - 1)
    
    Returns:
        Final position of the pivot element
    """
    if end_index is None:
        end_index = len(array) - 1
    
    swap_index = pivot_index
    
    for i in range(pivot_index + 1, end_index + 1):
        if array[i] < array[pivot_index]:
            swap_index += 1
            swap(array, swap_index, i)
    
    swap(array, pivot_index, swap_index)
    
    return swap_index


def quick_sort(array, left=0, right=None):
    """
    Sorts an array using quick sort algorithm.
    
    Args:
        array: List of comparable elements
        left: Starting index (default 0)
        right: Ending index (default array length - 1)
    """
    if right is None:
        right = len(array) - 1
    
    if left < right:
        pivot_index = pivot(array, left, right)
        quick_sort(array, left, pivot_index - 1)
        quick_sort(array, pivot_index + 1, right)


# Usage example
if __name__ == "__main__":
    my_unsorted_array = [5, 1, 6, 2, 4, 3, 7]
    print(f"Original: {my_unsorted_array}")
    quick_sort(my_unsorted_array)
    print(f"Sorted: {my_unsorted_array}")

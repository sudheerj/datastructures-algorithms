"""
Selection Sort Algorithm

Time Complexity: O(n^2)
Space Complexity: O(1)

Selection sort divides the array into sorted and unsorted regions,
repeatedly finding the minimum element from the unsorted region
and moving it to the sorted region.
"""


def selection_sort(array):
    """
    Sorts an array using selection sort algorithm.
    
    Args:
        array: List of comparable elements
    
    Returns:
        Sorted array
    """
    n = len(array)
    
    for i in range(n - 1):
        min_index = i
        
        for j in range(i + 1, n):
            if array[j] < array[min_index]:
                min_index = j
        
        if min_index != i:
            swap(array, min_index, i)
    
    return array


def swap(array, first_index, second_index):
    """Swaps two elements in an array."""
    array[first_index], array[second_index] = array[second_index], array[first_index]


# Usage example
if __name__ == "__main__":
    test_array = [40, 50, 20, 0, -10, 30, 10]
    print(f"Original: {test_array}")
    print(f"Sorted: {selection_sort(test_array)}")

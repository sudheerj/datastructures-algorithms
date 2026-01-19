"""
Bubble Sort Algorithm

Time Complexity: O(n^2)
Space Complexity: O(1)

Bubble sort repeatedly steps through the list, compares adjacent elements,
and swaps them if they are in the wrong order.
"""


def bubble_sort(array):
    """
    Sorts an array using bubble sort algorithm.
    
    Args:
        array: List of comparable elements
    
    Returns:
        Sorted array
    """
    n = len(array)
    
    for i in range(n - 1):
        swapped = False
        
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                swap(array, j, j + 1)
                swapped = True
        
        # Early exit if no swaps were made (array is sorted)
        if not swapped:
            break
    
    return array


def swap(array, first_index, second_index):
    """Swaps two elements in an array."""
    array[first_index], array[second_index] = array[second_index], array[first_index]


# Usage example
if __name__ == "__main__":
    test_array = [40, 50, 20, 0, -10, 30, 10]
    print(f"Original: {test_array}")
    print(f"Sorted: {bubble_sort(test_array)}")

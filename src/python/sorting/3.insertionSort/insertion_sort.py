"""
Insertion Sort Algorithm

Time Complexity: O(n^2)
Space Complexity: O(1)

Insertion sort builds the sorted array one element at a time,
by repeatedly inserting the next element into its correct position.
"""


def insertion_sort(array):
    """
    Sorts an array using insertion sort algorithm.
    
    Args:
        array: List of comparable elements
    
    Returns:
        Sorted array
    """
    for i in range(1, len(array)):
        temp = array[i]
        j = i - 1
        
        while j >= 0 and array[j] > temp:
            array[j + 1] = array[j]
            j -= 1
        
        array[j + 1] = temp
    
    return array


# Usage example
if __name__ == "__main__":
    test_array = [5, 1, 6, 2, 4, 3]
    print(f"Original: {test_array}")
    insertion_sort(test_array)
    print(f"Sorted: {test_array}")

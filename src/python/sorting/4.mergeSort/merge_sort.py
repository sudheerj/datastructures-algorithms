"""
Merge Sort Algorithm

Time Complexity: O(n log n)
Space Complexity: O(n)

Merge sort is a divide-and-conquer algorithm that divides the array
into halves, recursively sorts them, and then merges the sorted halves.
"""


def merge(array1, array2):
    """
    Merges two sorted arrays into one sorted array.
    
    Args:
        array1: First sorted array
        array2: Second sorted array
    
    Returns:
        Merged sorted array
    """
    combined = []
    i = 0
    j = 0
    
    while i < len(array1) and j < len(array2):
        if array1[i] < array2[j]:
            combined.append(array1[i])
            i += 1
        else:
            combined.append(array2[j])
            j += 1
    
    # Add remaining elements
    while i < len(array1):
        combined.append(array1[i])
        i += 1
    
    while j < len(array2):
        combined.append(array2[j])
        j += 1
    
    return combined


def merge_sort(array):
    """
    Sorts an array using merge sort algorithm.
    
    Args:
        array: List of comparable elements
    
    Returns:
        Sorted array
    """
    if len(array) < 2:
        return array
    
    mid = len(array) // 2
    left_array = array[:mid]
    right_array = array[mid:]
    
    return merge(merge_sort(left_array), merge_sort(right_array))


# Usage example
if __name__ == "__main__":
    original_array = [2, 1, 4, 3, 6, 5]
    print(f"Original: {original_array}")
    sorted_array = merge_sort(original_array)
    print(f"Sorted: {sorted_array}")

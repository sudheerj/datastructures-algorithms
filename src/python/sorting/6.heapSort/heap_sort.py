"""
Heap Sort Algorithm

Time Complexity: O(n log n)
Space Complexity: O(1)

Heap sort uses a binary heap data structure to sort elements.
It first builds a max heap, then repeatedly extracts the maximum element.
"""


def heap_sort(arr):
    """
    Sorts an array using heap sort algorithm.
    
    Args:
        arr: List of comparable elements
    """
    size = len(arr)

    # Build max heap
    for i in range(size // 2 - 1, -1, -1):
        heapify(arr, size, i)

    # Extract elements from heap one by one
    for i in range(size - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # Swap
        heapify(arr, i, 0)


def heapify(arr, size, parent_index):
    """
    Maintains the heap property for a subtree.
    
    Args:
        arr: Array representing the heap
        size: Size of the heap
        parent_index: Index of the parent node
    """
    largest = parent_index
    left_child = 2 * parent_index + 1
    right_child = 2 * parent_index + 2

    if left_child < size and arr[left_child] > arr[largest]:
        largest = left_child

    if right_child < size and arr[right_child] > arr[largest]:
        largest = right_child

    if parent_index != largest:
        arr[parent_index], arr[largest] = arr[largest], arr[parent_index]
        heapify(arr, size, largest)


# Usage example
if __name__ == "__main__":
    arr = [40, 50, 20, 0, -10, 30, 10]
    print(f"Original: {arr}")
    heap_sort(arr)
    print(f"Sorted: {arr}")

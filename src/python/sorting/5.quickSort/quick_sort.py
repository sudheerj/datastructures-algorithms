"""
Quick Sort Algorithm

Time Complexity: O(n log n) average, O(n^2) worst
Space Complexity: O(log n)

Quick sort is a divide-and-conquer algorithm that selects a pivot element
and partitions the array around the pivot, then recursively sorts the partitions.
"""

import random


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def partition(arr, left, right):
    pivot_index = random.randint(left, right)
    swap(arr, left, pivot_index)

    pivot = arr[left]
    swap_index = left

    for i in range(left + 1, right + 1):
        if arr[i] < pivot:
            swap_index += 1
            swap(arr, swap_index, i)

    swap(arr, left, swap_index)
    return swap_index


def quick_sort(arr, left=0, right=None):
    if right is None:
        right = len(arr) - 1

    if left < right:
        pivot_index = partition(arr, left, right)
        quick_sort(arr, left, pivot_index - 1)
        quick_sort(arr, pivot_index + 1, right)


# Usage example
if __name__ == "__main__":
    my_unsorted_array = [5, 1, 6, 2, 4, 3, 7]
    print(f"Original: {my_unsorted_array}")
    quick_sort(my_unsorted_array)
    print(f"Sorted: {my_unsorted_array}")

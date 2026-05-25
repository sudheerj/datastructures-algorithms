import heapq
from typing import List


def kth_largest1(nums: List[int], k: int) -> int:
    """Sorting TC: O(n log n) SC: O(1)"""
    nums.sort()
    return nums[-k]


def kth_largest2(nums: List[int], k: int) -> int:
    """Min-heap of size k TC: O(n log k) SC: O(k)"""
    heap = []
    for num in nums:
        heapq.heappush(heap, num)
        if len(heap) > k:
            heapq.heappop(heap)
    return heap[0]


def kth_largest3(nums: List[int], k: int) -> int:
    """Max-heap TC: O(n log n) SC: O(n)"""
    max_heap = [-num for num in nums]
    heapq.heapify(max_heap)
    for _ in range(k - 1):
        heapq.heappop(max_heap)
    return -max_heap[0]


def kth_largest4(nums: List[int], k: int) -> int:
    """QuickSelect TC: O(n) avg SC: O(n) recursion stack"""
    target = len(nums) - k

    def partition(left: int, right: int) -> int:
        pivot = nums[right]
        i = left
        for j in range(left, right):
            if nums[j] < pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
        nums[i], nums[right] = nums[right], nums[i]
        return i

    def quick_select(left: int, right: int) -> int:
        pivot_idx = partition(left, right)
        if pivot_idx == target:
            return nums[pivot_idx]
        elif pivot_idx < target:
            return quick_select(pivot_idx + 1, right)
        else:
            return quick_select(left, pivot_idx - 1)

    return quick_select(0, len(nums) - 1)


if __name__ == "__main__":
    test_cases = [
        ([3, 2, 1, 5, 6, 4], 2, 5),
        ([3, 2, 3, 1, 2, 4, 5, 5, 6], 4, 4),
        ([1], 1, 1),
        ([7, 6, 5, 4, 3, 2, 1], 3, 5),
        ([1, 2, 3, 4, 5], 1, 5),
    ]

    print("--- kth_largest1 (Sorting) ---")
    for nums, k, expected in test_cases:
        result = kth_largest1(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

    print("--- kth_largest2 (MinHeap) ---")
    for nums, k, expected in test_cases:
        result = kth_largest2(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

    print("--- kth_largest3 (MaxHeap) ---")
    for nums, k, expected in test_cases:
        result = kth_largest3(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

    print("--- kth_largest4 (QuickSelect) ---")
    for nums, k, expected in test_cases:
        result = kth_largest4(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

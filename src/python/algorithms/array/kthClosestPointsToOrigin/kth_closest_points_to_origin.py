import heapq
from typing import List


def kth_closest1(points: List[List[int]], k: int) -> List[List[int]]:
    """Sorting TC: O(n log n) SC: O(log n)"""
    points.sort(key=lambda p: p[0]**2 + p[1]**2)
    return points[:k]


def kth_closest2(points: List[List[int]], k: int) -> List[List[int]]:
    """Max heap size k TC: O(n log k) SC: O(k)"""
    heap = []
    for x, y in points:
        heapq.heappush(heap, (-(x*x + y*y), x, y))
        if len(heap) > k:
            heapq.heappop(heap)
    return [[x, y] for _, x, y in heap]


def kth_closest3(points: List[List[int]], k: int) -> List[List[int]]:
    """Min heap TC: O(n + k log n) SC: O(n)"""
    heap = [(x*x + y*y, x, y) for x, y in points]
    heapq.heapify(heap)
    return [[x, y] for _, x, y in heapq.nsmallest(k, heap)]


def kth_closest4(points: List[List[int]], k: int) -> List[List[int]]:
    """QuickSelect TC: O(n) avg, O(n²) worst SC: O(log n)"""
    def dist(p):
        return p[0]**2 + p[1]**2

    def partition(left, right):
        pivot_dist = dist(points[right])
        store = left
        for i in range(left, right):
            if dist(points[i]) <= pivot_dist:
                points[store], points[i] = points[i], points[store]
                store += 1
        points[store], points[right] = points[right], points[store]
        return store

    left, right = 0, len(points) - 1
    while left < right:
        pivot_idx = partition(left, right)
        if pivot_idx == k:
            break
        elif pivot_idx < k:
            left = pivot_idx + 1
        else:
            right = pivot_idx - 1
    return points[:k]


if __name__ == "__main__":
    test_cases = [
        ([[1, 3], [-2, 2]],           1, [[-2, 2]]),
        ([[3, 3], [5, -1], [-2, 4]],  2, [[-2, 4], [3, 3]]),
        ([[0, 1], [1, 0]],            2, [[0, 1], [1, 0]]),
        ([[1, 0]],                    1, [[1, 0]]),
        ([[-5, 4], [0, 0], [1, 1]],   2, [[0, 0], [1, 1]]),
    ]

    for fn, label in [
        (kth_closest1, "kth_closest1 (sorting)"),
        (kth_closest2, "kth_closest2 (max heap)"),
        (kth_closest3, "kth_closest3 (min heap)"),
        (kth_closest4, "kth_closest4 (quickselect)"),
    ]:
        print(f"--- {label} ---")
        for points, k, expected in test_cases:
            result = fn([p[:] for p in points], k)
            status = "PASS" if sorted(result) == sorted(expected) else "FAIL"
            print(f"[{status}] result={sorted(result)} expected={sorted(expected)}")

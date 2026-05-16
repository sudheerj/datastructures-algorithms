# Median Finder (Find Median from Data Stream)
# Design a data structure supporting addNum and findMedian on a live integer stream.
# TC: addNum -> O(log n), findMedian -> O(1), SC: O(n)

import heapq

class MedianFinder:
    def __init__(self):
        self.max_heap: list[int] = []  # lower half (max-heap via negation)
        self.min_heap: list[int] = []  # upper half (min-heap)

    def add_num(self, num: int) -> None:
        heapq.heappush(self.max_heap, -num)
        heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        if len(self.max_heap) < len(self.min_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def find_median(self) -> float:
        if len(self.max_heap) == len(self.min_heap):
            return (-self.max_heap[0] + self.min_heap[0]) / 2.0
        return float(-self.max_heap[0])


# Test cases
tests = [
    ([1, 2, 3],            2.0),
    ([1, 2],               1.5),
    ([5],                  5.0),
    ([40, 30, 50, 10, 20], 30.0),
    ([1, 7, 3, 9, 2, 8],   5.0),
]

for nums, expected in tests:
    mf = MedianFinder()
    for n in nums:
        mf.add_num(n)
    result = mf.find_median()
    status = "✓" if result == expected else f"✗ (expected {expected})"
    print(f"add_num({nums}) => find_median() = {result} {status}")

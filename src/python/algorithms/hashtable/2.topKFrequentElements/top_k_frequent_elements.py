"""
Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements.

Time Complexity: O(n)
Space Complexity: O(n)
"""

import heapq
from collections import Counter

def top_k_frequent_buckets(nums, k):
    """
    Using bucket sort.
    TC: O(n), SC: O(n)
    """
    count = Counter(nums)
    
    # Create buckets where index = frequency
    buckets = [[] for _ in range(len(nums) + 1)]
    
    for num, freq in count.items():
        buckets[freq].append(num)
    
    result = []
    for i in range(len(buckets) - 1, 0, -1):
        for num in buckets[i]:
            result.append(num)
            if len(result) == k:
                return result
    
    return result


import heapq
def top_k_frequent_heap(nums, k):
    count = Counter(nums)

    res = []
    for num, c in count.items():
        heapq.heappush(res, (c, num))
        if len(res) > k:
            heapq.heappop(res)

    return [num for c, num in sorted(res, reverse=True)]

def top_k_frequent_heap_largest(nums, k):
    """
    Using min-heap.
    TC: O(n log k), SC: O(n)
    """
    count = Counter(nums)
    return heapq.nlargest(k, count.keys(), key=count.get)


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"nums": [1, 1, 1, 2, 2, 3], "k": 2},  # [1, 2]
        {"nums": [1], "k": 1},                    # [1]
    ]
    
    for test in test_cases:
        print(f"nums: {test['nums']}, k: {test['k']}")
        print(f"Bucket sort: {top_k_frequent_buckets(test['nums'], test['k'])}")
        print(f"Heap (manual): {top_k_frequent_heap(test['nums'], test['k'])}")
        print(f"Heap: {top_k_frequent_heap_largest(test['nums'], test['k'])}")
        print()

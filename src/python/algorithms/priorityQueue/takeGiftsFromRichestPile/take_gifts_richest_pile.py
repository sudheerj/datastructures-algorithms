import heapq
import math

def pickGifts(gifts, k):
    heap = [-gift for gift in gifts]
    heapq.heapify(heap)

    for _ in range(k):
        largest = -heapq.heappop(heap)
        heapq.heappush(heap, -math.isqrt(largest))
    return -sum(heap)

def run_tests():
    tests = [
        # (gifts, k, expected)
        ([25, 64, 9, 4, 100], 4, 29),
        ([1, 1, 1, 1], 4, 4),
        ([100], 1, 10),
        ([100], 2, 3),
        ([16], 1, 4),
        ([16], 2, 2),
        ([15], 1, 3),
        ([9, 9], 2, 6),
        ([4, 4, 4], 2, 8),
        ([5, 7, 9], 0, 21),
    ]

    for i, (gifts, k, expected) in enumerate(tests, 1):
        result = pickGifts(gifts[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"Test {i}: {status}")
        print(f"  gifts={gifts}, k={k}")
        print(f"  Expected: {expected}")
        print(f"  Got:      {result}\n")


if __name__ == "__main__":
    run_tests()
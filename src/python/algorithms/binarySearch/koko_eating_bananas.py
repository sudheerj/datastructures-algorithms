"""
Koko Eating Bananas (LeetCode 875)
Binary Search and Brute Force solutions
"""
import math

def minEatingSpeed_binary_search(piles, h):
    left, right = 1, max(piles)
    ans = right
    while left <= right:
        mid = (left + right) // 2
        hours = sum((pile + mid - 1) // mid for pile in piles)
        if hours <= h:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1
    return ans

def minEatingSpeed_bruteforce(piles, h):
    for k in range(1, max(piles)+1):
        hours = sum((pile + k - 1) // k for pile in piles)
        if hours <= h:
            return k
    return max(piles)

if __name__ == "__main__":
    test_piles = [
        [3, 6, 7, 11],
        [30, 11, 23, 4, 20],
        [30, 11, 23, 4, 20]
    ]
    test_h = [8, 5, 6]
    expected = [4, 30, 23]

    print("Testing Koko Eating Bananas (Binary Search):")
    for i, (piles, h) in enumerate(zip(test_piles, test_h)):
        res = minEatingSpeed_binary_search(piles, h)
        print(("PASS" if res == expected[i] else "FAIL"), f"Test {i+1}: got {res}, expected {expected[i]}")

    print("\nTesting Koko Eating Bananas (Brute Force):")
    for i, (piles, h) in enumerate(zip(test_piles, test_h)):
        res = minEatingSpeed_bruteforce(piles, h)
        print(("PASS" if res == expected[i] else "FAIL"), f"Test {i+1}: got {res}, expected {expected[i]}")

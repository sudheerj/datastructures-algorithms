"""
Number of 1 Bits (Hamming Weight)

Write a function that takes an unsigned integer and returns the number of '1' bits it has.

Time Complexity: O(1) - fixed 32-bit integer
Space Complexity: O(1)
"""


def hamming_weight(n):
    """
    Count number of 1 bits.
    TC: O(1), SC: O(1)
    """
    count = 0
    while n:
        count += n & 1
        n >>= 1
    return count


def hamming_weight_optimized(n):
    """
    Brian Kernighan's algorithm - only loops for number of set bits.
    TC: O(k) where k is number of 1 bits, SC: O(1)
    """
    count = 0
    while n:
        n &= (n - 1)  # Clear the least significant bit
        count += 1
    return count


# Test cases
if __name__ == "__main__":
    test_cases = [
        11,         # 3 (binary: 1011)
        128,        # 1 (binary: 10000000)
        4294967293  # 31 (binary: 11111111111111111111111111111101)
    ]
    
    for n in test_cases:
        print(f"Number: {n}, Binary: {bin(n)}")
        print(f"Number of 1 bits: {hamming_weight(n)}")
        print()

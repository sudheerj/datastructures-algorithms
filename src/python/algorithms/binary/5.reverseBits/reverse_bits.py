"""
Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

Time Complexity: O(1)
Space Complexity: O(1)
"""


def reverse_bits(n):
    """
    Reverse bits of a 32-bit integer.
    TC: O(1), SC: O(1)
    """
    result = 0
    for _ in range(32):
        result = (result << 1) | (n & 1)
        n >>= 1
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        43261596,    # 964176192
        4294967293,  # 3221225471
    ]
    
    for n in test_cases:
        print(f"Input: {n} (binary: {bin(n)})")
        result = reverse_bits(n)
        print(f"Reversed: {result} (binary: {bin(result)})")
        print()

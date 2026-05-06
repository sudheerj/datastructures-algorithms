"""
Reverse Same Char Position

Given a string, reverse it and count how many characters remain at the same position as in the original.

Time Complexity: O(n)
Space Complexity: O(1)
"""

def reverse_same_char_position(s):
    length = len(s)
    count = 0
    for i in range(length):
        if s[i] == s[length - 1 - i]:
            count += 1
    return count


if __name__ == "__main__":
    # Test 1: Palindrome - all chars same position after reverse
    print("Test 1:", reverse_same_char_position("abcba"))  # 5

    # Test 2: No chars same position after reverse
    print("Test 2:", reverse_same_char_position("abcd"))  # 0

    # Test 3: Even-length palindrome
    print("Test 3:", reverse_same_char_position("abba"))  # 4

    # Test 4: Only middle char stays
    print("Test 4:", reverse_same_char_position("hello"))  # 1 (l at index 2)

    # Test 5: All same characters
    print("Test 5:", reverse_same_char_position("aaaa"))  # 4

    # Test 6: Single character
    print("Test 6:", reverse_same_char_position("a"))  # 1

"""
Valid Anagram

Given two strings s and t, return true if t is an anagram of s.

Time Complexity: O(n)
Space Complexity: O(1) - fixed 26 characters
"""

from collections import Counter


def is_anagram(s, t):
    """
    Using Counter.
    TC: O(n), SC: O(1)
    """
    return Counter(s) == Counter(t)


def is_anagram_array(s, t):
    """
    Using character count array.
    TC: O(n), SC: O(1)
    """
    if len(s) != len(t):
        return False
    
    count = [0] * 26
    
    for i in range(len(s)):
        count[ord(s[i]) - ord('a')] += 1
        count[ord(t[i]) - ord('a')] -= 1
    
    return all(c == 0 for c in count)


def is_anagram_sort(s, t):
    """
    Using sorting.
    TC: O(n log n), SC: O(n)
    """
    return sorted(s) == sorted(t)


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"s": "anagram", "t": "nagaram"},  # True
        {"s": "rat", "t": "car"},           # False
    ]
    
    for test in test_cases:
        print(f"s: '{test['s']}', t: '{test['t']}'")
        print(f"Is anagram: {is_anagram(test['s'], test['t'])}")
        print()

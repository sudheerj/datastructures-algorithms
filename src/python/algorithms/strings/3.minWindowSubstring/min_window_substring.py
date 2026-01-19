"""
Minimum Window Substring

Given two strings s and t, return the minimum window substring of s
such that every character in t is included in the window.

Time Complexity: O(m + n)
Space Complexity: O(m + n)
"""

from collections import Counter


def min_window(s, t):
    """
    Sliding window approach.
    TC: O(m + n), SC: O(m + n)
    """
    if not s or not t or len(s) < len(t):
        return ""
    
    t_count = Counter(t)
    required = len(t_count)
    
    left = 0
    formed = 0
    window_counts = {}
    
    min_len = float('inf')
    min_left = 0
    
    for right in range(len(s)):
        char = s[right]
        window_counts[char] = window_counts.get(char, 0) + 1
        
        if char in t_count and window_counts[char] == t_count[char]:
            formed += 1
        
        while formed == required:
            if right - left + 1 < min_len:
                min_len = right - left + 1
                min_left = left
            
            left_char = s[left]
            window_counts[left_char] -= 1
            
            if left_char in t_count and window_counts[left_char] < t_count[left_char]:
                formed -= 1
            
            left += 1
    
    return "" if min_len == float('inf') else s[min_left:min_left + min_len]


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"s": "ADOBECODEBANC", "t": "ABC"},  # "BANC"
        {"s": "a", "t": "a"},                 # "a"
        {"s": "a", "t": "aa"},                # ""
    ]
    
    for test in test_cases:
        print(f"s: '{test['s']}', t: '{test['t']}'")
        print(f"Min window: '{min_window(test['s'], test['t'])}'")
        print()

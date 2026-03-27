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
    
    substr_count = Counter(t)
    window_str_count = {}

    having = 0
    required = len(substr_count)
    
    left = 0
    
    min_length = float('inf')
    best_window = [-1, -1]
    
    for right in range(len(s)):
        right_char = s[right]
        window_str_count[right_char] = 1 + window_str_count.get(right_char, 0)
        
        if right_char in substr_count and window_str_count[right_char] == substr_count[right_char]:
            having += 1
        
        while having == required:
            if right - left + 1 < min_length:
                min_length = right - left + 1
                best_window[0] = left
                best_window[1] = right
            
            left_char = s[left]
            window_str_count[left_char] -= 1
            
            if left_char in substr_count and window_str_count[left_char] < substr_count[left_char]:
                having -= 1
            
            left += 1
    
    return "" if min_length == float('inf') else s[best_window[0]:best_window[1]+1]


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

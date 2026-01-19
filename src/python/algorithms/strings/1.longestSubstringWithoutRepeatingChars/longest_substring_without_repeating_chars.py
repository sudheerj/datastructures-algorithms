"""
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Time Complexity: O(n)
Space Complexity: O(min(m, n)) where m is charset size
"""


def length_of_longest_substring(s):
    """
    Sliding window with hash set.
    TC: O(n), SC: O(min(m, n))
    """
    char_set = set()
    left = 0
    max_length = 0
    
    for right in range(len(s)):
        while s[right] in char_set:
            char_set.remove(s[left])
            left += 1
        
        char_set.add(s[right])
        max_length = max(max_length, right - left + 1)
    
    return max_length


def length_of_longest_substring_optimized(s):
    """
    Sliding window with hash map for direct jump.
    TC: O(n), SC: O(min(m, n))
    """
    char_index = {}
    left = 0
    max_length = 0
    
    for right, char in enumerate(s):
        if char in char_index and char_index[char] >= left:
            left = char_index[char] + 1
        
        char_index[char] = right
        max_length = max(max_length, right - left + 1)
    
    return max_length


# Test cases
if __name__ == "__main__":
    test_cases = [
        "abcabcbb",  # 3 ("abc")
        "bbbbb",      # 1 ("b")
        "pwwkew",     # 3 ("wke")
    ]
    
    for s in test_cases:
        print(f"String: '{s}'")
        print(f"Longest substring length: {length_of_longest_substring(s)}")
        print()

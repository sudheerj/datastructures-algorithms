"""
Maximum Length Between Equal Characters

Given a string s, return the length of the longest substring between two equal characters,
excluding the two characters. If there is no such substring, return -1.

Time Complexity: O(n)
Space Complexity: O(1) - at most 26 characters
"""


def max_length_between_equal_chars(s):
    """
    Track first occurrence of each character.
    TC: O(n), SC: O(1)
    """
    first_occurrence = {}
    max_length = -1
    
    for i, char in enumerate(s):
        if char in first_occurrence:
            max_length = max(max_length, i - first_occurrence[char] - 1)
        else:
            first_occurrence[char] = i
    
    return max_length


# Test cases
if __name__ == "__main__":
    test_cases = [
        "aa",      # Output: 0
        "abca",    # Output: 2
        "cbzxy",   # Output: -1
        "cabbac",  # Output: 4
    ]
    
    for s in test_cases:
        result = max_length_between_equal_chars(s)
        print(f"Input: '{s}' => Max length: {result}")

"""
Valid Palindrome

Given a string s, return true if it is a palindrome after converting all uppercase
letters to lowercase and removing all non-alphanumeric characters.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def is_palindrome(s):
    """
    Two pointer approach.
    TC: O(n), SC: O(1)
    """
    left, right = 0, len(s) - 1
    
    while left < right:
        while left < right and not s[left].isalnum():
            left += 1
        while left < right and not s[right].isalnum():
            right -= 1
        
        if s[left].lower() != s[right].lower():
            return False
        
        left += 1
        right -= 1
    
    return True


def is_palindrome_simple(s):
    """
    Using string operations.
    TC: O(n), SC: O(n)
    """
    cleaned = ''.join(char.lower() for char in s if char.isalnum())
    return cleaned == cleaned[::-1]


# Test cases
if __name__ == "__main__":
    test_cases = [
        "A man, a plan, a canal: Panama",  # True
        "race a car",                       # False
        " ",                                # True
    ]
    
    for s in test_cases:
        print(f"String: '{s}'")
        print(f"Is palindrome: {is_palindrome(s)}")
        print()

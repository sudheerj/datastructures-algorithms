"""
Valid Parentheses (Balanced Brackets)

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def is_valid(s):
    """
    Using stack to match brackets.
    TC: O(n), SC: O(n)
    """
    stack = []
    bracket_map = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in bracket_map:
            top = stack.pop() if stack else '#'
            if bracket_map[char] != top:
                return False
        else:
            stack.append(char)
    
    return len(stack) == 0


# Test cases
if __name__ == "__main__":
    test_cases = [
        "()",      # True
        "()[]{}",  # True
        "(]",      # False
        "([)]",    # False
        "{[]}",    # True
    ]
    
    for s in test_cases:
        print(f"'{s}' is valid: {is_valid(s)}")

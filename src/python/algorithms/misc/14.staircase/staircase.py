"""
Staircase

Print a staircase of size n using # symbols and spaces.

Time Complexity: O(n^2)
Space Complexity: O(n)
"""


def staircase(n):
    """
    Print a right-aligned staircase.
    TC: O(n^2), SC: O(n)
    """
    for i in range(1, n + 1):
        spaces = ' ' * (n - i)
        hashes = '#' * i
        print(spaces + hashes)


def staircase_left(n):
    """
    Print a left-aligned staircase.
    TC: O(n^2), SC: O(n)
    """
    for i in range(1, n + 1):
        print('#' * i)


# Test cases
if __name__ == "__main__":
    print("Right-aligned staircase (n=4):")
    staircase(4)
    
    print("\nRight-aligned staircase (n=6):")
    staircase(6)
    
    print("\nLeft-aligned staircase (n=4):")
    staircase_left(4)

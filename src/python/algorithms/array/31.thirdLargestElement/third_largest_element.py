"""
Third Largest Element

Given an integer array, return the third largest distinct element.
If it doesn't exist, return a message indicating that.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def third_largest_element(arr):
    """
    Track three largest elements in single pass.
    TC: O(n), SC: O(1)
    """
    first = second = third = float('-inf')
    
    for num in arr:
        if num == first or num == second or num == third:
            continue
        
        if num > first:
            first, second, third = num, first, second
        elif num > second:
            second, third = num, second
        elif num > third:
            third = num
    
    if third == float('-inf'):
        return "There are no 3 unique elements in an array"
    return third


def third_largest_element_sort(arr):
    """
    Using set and sorting.
    TC: O(n log n), SC: O(n)
    """
    unique_arr = list(set(arr))
    
    if len(unique_arr) < 3:
        return "There are no 3 unique elements in an array"
    
    unique_arr.sort(reverse=True)
    return unique_arr[2]


# Test cases
if __name__ == "__main__":
    test_cases = [
        [33, 90, 10, 50, 33, 77, 90, 4],  # Output: 50
        [1, 2],                            # Output: "There are no..."
        [3, 2, 1],                         # Output: 1
        [1, 1, 2],                         # Output: "There are no..."
    ]
    
    for arr in test_cases:
        result1 = third_largest_element(arr)
        result2 = third_largest_element_sort(arr)
        print(f"Input: {arr}")
        print(f"  Single pass: {result1}")
        print(f"  Using sort: {result2}")

# Search Insert Position (Python)

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

## Example

Input: nums = [1,3,5,6], target = 5  
Output: 2

Input: nums = [1,3,5,6], target = 2  
Output: 1

## Approach
- Use binary search to find the target or the insert position.
- If the target is not found, the left pointer will be at the correct insert position.

## Complexity
- Time: O(log n)
- Space: O(1)

## Test Cases
See `test_search_insert_position.py` for sample test cases.

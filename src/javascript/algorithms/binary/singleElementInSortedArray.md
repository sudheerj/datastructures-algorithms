# Single Element in a Sorted Array (LeetCode 540)

Given a sorted array where every element appears exactly twice except for one element which appears only once, find that single element in O(log n) time and O(1) space.

## Example

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10

## Approach

### Binary Search on Pair Alignment (O(log n) time, O(1) space)
- Use binary search to find the single element by checking the alignment of pairs.
- If mid is even and nums[mid] == nums[mid+1], the single element is after mid.
- If mid is odd, decrement mid to make it even for comparison.

## Java Implementation
See [SingleElementInSortedArray.java](../../../java1/algorithms/binarySearch/singleElementInSortedArray/SingleElementInSortedArray.java)

## Python Implementation
See [singleElementInSortedArray.py](singleElementInSortedArray.py)

## JavaScript Implementation
See [singleElementInSortedArray.js](singleElementInSortedArray.js)

## Test Cases
| Input                        | Output |
|------------------------------|--------|
| [1,1,2,3,3,4,4,8,8]          | 2      |
| [3,3,7,7,10,11,11]           | 10     |
| [1,1,2,2,3,3,4,4,5]          | 5      |
| [0,1,1,2,2,3,3]              | 0      |
| [1,1,2,2,3,3,4]              | 4      |
| [5]                          | 5      |
| [1,1,2]                      | 2      |

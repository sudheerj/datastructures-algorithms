# Frequency of the Most Frequent Element (LeetCode 1838)

Given an integer array nums and an integer k, you are allowed to increment any element of the array at most k times in total. Return the maximum possible frequency of an element after performing at most k increments.

## Example

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment 1 by 3 and 2 by 2 to make all elements equal to 4.

Input: nums = [1,4,8,13], k = 5
Output: 2

## Approach

### Sorting + Sliding Window + Greedy (O(n log n) time, O(1) space)
- Sort the array.
- Use a sliding window to find the largest window where the cost to make all elements equal to the rightmost element is ≤ k.

## Java Implementation
See [FrequencyOfMostFrequent.java](../../java1/algorithms/array/frequencyOfMostFrequent/FrequencyOfMostFrequent.java)

## Python Implementation
See [frequencyOfMostFrequent.py](../../../../python/algorithms/array/frequencyOfMostFrequent.py)

## JavaScript Implementation
See [frequencyOfMostFrequent.js](../../../../javascript/algorithms/array/frequencyOfMostFrequent.js)

## Test Cases
| nums                | k  | Output |
|---------------------|----|--------|
| [1,2,4]             | 5  | 3      |
| [1,4,8,13]          | 5  | 2      |
| [3,9,6]             | 2  | 1      |
| [1,1,1,2,2,4]       | 0  | 3      |
| [1,2,2,2,2,2]       | 3  | 6      |
| [1]                 | 0  | 1      |
| [1,2,3,4,5]         | 10 | 5      |

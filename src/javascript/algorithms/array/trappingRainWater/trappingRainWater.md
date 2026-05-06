# trappingRainWater.js

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Approaches
- **Two Pointer:** O(n) time, O(1) space
- **DP (Prefix & Suffix Arrays):** O(n) time, O(n) space

## Example
**Input:** [0,1,0,2,1,0,1,3,2,1,2,1]  
**Output:** 6

## Steps
### Two Pointer Approach
1. Initialize two pointers at the start and end of the array.
2. Track the maximum height seen from the left and right.
3. Move the pointer with the smaller max inward, updating max and adding trapped water at each step.
4. Continue until pointers meet.

### DP (Prefix & Suffix Arrays)
1. Create arrays to store the max height to the left and right of each index.
2. For each index, calculate the minimum of left and right max heights.
3. The trapped water at each index is the min of left/right max minus the height at that index.
4. Sum for all indices to get total trapped water.

## Test Cases
- [0,1,0,2,1,0,1,3,2,1,2,1] → 6
- [4,2,0,3,2,5] → 9
- [1,1] → 0
- [] → 0
- [3,0,0,2,0,4] → 10

## Usage
```js
console.log(trappingRainWater([0,1,0,2,1,0,1,3,2,1,2,1])); // 6
console.log(trappingRainWater2([0,1,0,2,1,0,1,3,2,1,2,1])); // 6
```

# Circular Array Loop

Given a circular array of integers, determine if there is a cycle (loop) in the array that meets the following conditions:
- The loop must be in a single direction (all positive or all negative numbers).
- The loop must be longer than 1 element (no self-loop).

## Approach
- Use fast/slow pointer (Floyd's cycle detection) with direction check and marking visited.
- Time: O(n)
- Space: O(1)

## Java Implementation
See [CircularArrayLoop.java](CircularArrayLoop.java)

## Python Implementation
See [circular_array_loop.py](../../../../python/algorithms/array/circular_array_loop.py)

## JavaScript Implementation
See [circularArrayLoop.js](../../../../javascript/algorithms/array/circularArrayLoop.js)

## Example Test Cases
| nums                  | Output |
|-----------------------|--------|
| [2,-1,1,2,2]          | true   |
| [-1,2]                | false  |
| [-2,1,-1,-2,-2]       | false  |
| [1,1,2]               | true   |
| [1,2,3,4,5,6,7,8,9,10]| true   |
| [1,-1,5,1,4]          | false  |
| [1,1,1,1,1,1,1,1,1,1] | true   |
| [0,1,2]               | false  |

## Test Output
All operations should match the expected output above.

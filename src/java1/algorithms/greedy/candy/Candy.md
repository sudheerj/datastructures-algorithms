# Candy Problem

Given an array ratings representing the rating of each child, distribute candies to children such that:
- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies needed.

## Approach
- Use two passes: left-to-right and right-to-left.
- First pass ensures right neighbor rule, second pass ensures left neighbor rule.
- Sum the candies array for the answer.

## Test Cases
| Input                | Output | Expected | Status |
|----------------------|--------|----------|--------|
| [1,0,2]              | 5      | 5        | PASS   |
| [1,2,2]              | 4      | 4        | PASS   |
| [1,3,2,2,1]          | 7      | 7        | PASS   |
| [1,2,87,87,87,2,1]   | 13     | 13       | PASS   |
| [1,3,4,5,2]          | 9      | 9        | PASS   |
| [1,2,3,1,0]          | 9      | 9        | PASS   |
| [1,6,10,8,7,3,2]     | 18     | 18       | PASS   |
| [1,2,2,1,2,2,1]      | 12     | 12       | PASS   |
| [1,2,3,4,5]          | 15     | 15       | PASS   |
| [5,4,3,2,1]          | 15     | 15       | PASS   |

## Links
- [Java Solution](../../java1/algorithms/greedy/candy/Candy.java)
- [Python Solution](../../python/algorithms/greedy/candy.py)
- [JavaScript Solution](../../javascript/algorithms/greedy/candy.js)
